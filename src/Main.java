import com.engeto.hotel.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ///region Guests region (hardcoded info)
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        System.out.println(guest1);
        System.out.println(guest2);
        ///endregion

        ///region Rooms region (hardcoded info)
        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400));
        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);
        ///endregion

        ///region App - record bookings
        Booking reservation1 = new Booking(room1,
                guest1,  // jak to napsat lepe?
                LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26),
                VacationType.WORKING );
//        reservation1.addGuestToBooking(guest1);

        Booking reservation2 = new Booking(room3,
                guest1,  // jak to napsat lepe?
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 9, 14),
                VacationType.RECREATIVE );
        reservation2.addGuestToBooking(guest2);

        BookingsDB bookingsDB = new BookingsDB();
        bookingsDB.add(reservation1);
        bookingsDB.add(reservation2);
        ///endregion

        ///region Report output
        System.out.println("\n---------------------\nReport ( " + LocalDate.now() + "):\n---------------------");
        for (Booking booking : bookingsDB.getBookingsDB() ) {
            System.out.println(booking);
            System.out.println();
        }
        ///endregion
    }
}

