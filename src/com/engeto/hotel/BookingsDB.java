package com.engeto.hotel;

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
    public void add(Booking booking) {
        this.bookingsDB.add(booking);
    }
    ///endregion
}
