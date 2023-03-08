package com.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingsDB {

    ///region attributes
    private List<Booking> bookingsDB;
    ///endregion

    ///region constructors
    public BookingsDB() {
        bookingsDB = new ArrayList<>();
    }
    ///endregion

    ///region getters and setters
    public List<Booking> getBookingsDB() {
        // returning copy of the collection (encapsulation)!
        return new ArrayList<>(bookingsDB);
    }
    ///endregion

    ///region override
    ///endregion

    ///region Custom methods
    public boolean add(Booking booking) {
        for (Booking savedBooking : this.bookingsDB ) {
            if ( savedBooking.getRoom().getRoomNumber() == booking.getRoom().getRoomNumber()
                && isTimeOverlaping(savedBooking, booking)) {
                return false;
            }
        }
        this.bookingsDB.add(booking);
        return true;
    }

    /*
     * Multiple check testing if the time intervals in new and old reservations
     * are somehow overlaping.
     */
    private boolean isTimeOverlaping(Booking oldBooking, Booking newBooking) {
        double[] oldInterval = bookingToEpochDaysInterval(oldBooking);
        double[] newInterval = bookingToEpochDaysInterval(newBooking);

        return (
                // new start inside old interval
                isInsideInterval(newInterval[0], oldInterval[0], oldInterval[1])
                // OR new end inside old interval
                || isInsideInterval(newInterval[1], oldInterval[0], oldInterval[1])
                // OR
                || (
                        // old start inside new interval
                        isInsideInterval(oldInterval[0], newInterval[0], newInterval[1])
                        // AND old end inside new interval
                        && isInsideInterval(oldInterval[1], newInterval[0], newInterval[1])
                        // (ie. new interval starts before and end after old):
                )
        );
    }
    ///endregion

    ///region Helpers
    private double[] bookingToEpochDaysInterval(Booking booking) {
        double[] interval = new double[2];

        interval[0] = booking.getStartDate().toEpochDay();
        interval[1] = booking.getEndDate().toEpochDay();

        return interval;
    }
    private boolean isInsideInterval(double tested, double start, double end) {  // mel by tento helper byt instancni nebo stat. metoda? Nebo v uplne jine tride???
        return tested >= start && tested <= end;
    }
    ///endregion
}
