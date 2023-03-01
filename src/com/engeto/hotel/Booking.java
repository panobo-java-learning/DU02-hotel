package com.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private static int reservationNextID = 0;

    ///region attributes
    private Room room;
    private List<Guest> listOfGuests = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private VacationType vacationType;
    private int reservationID;
    ///endregion

    ///region constructors
    public Booking(Room room, List<Guest> listOfGuests, LocalDate startDate, LocalDate endDate, VacationType vacationType) {
        this.reservationID = reservationNextID++;
        this.room = room;
        this.listOfGuests = listOfGuests;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }
    ///endregion

    ///region getters and setters
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Guest> getListOfGuests() {
        return listOfGuests;
    }

    public void setListOfGuests(List<Guest> listOfGuests) {
        this.listOfGuests = listOfGuests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }
    ///endregion

    ///region override
    @Override
    public String toString() {
        String heading_row = "[booking #%03d] Room %d %s%n".formatted(reservationID, room.getRoomNumber(), getVacanciesRatio());
        String guestList = getGuestsList();
        String details = "Accomodated from %s to %s.%nVacation type: %s.".formatted(
                this.startDate, this.endDate, this.vacationType );
        return heading_row + guestList + details;
    }

    ///endregion

    ///region custom and helper methods
    /*
    * Add a guest into the booking.
    * In case the room is already full, do nothing but warning.
    * In case guest is already there, no operation, warning.
    */
    public void addGuestToBooking(Guest guest) {
        if (this.room.getNumberOfBeds() > this.listOfGuests.size()) {
            if ( ! this.listOfGuests.contains(guest)) this.listOfGuests.add(guest);
            else System.err.println("[booking #%03d".formatted(this.reservationID) +"] Warning! <" + guest + "> already present in booking! Nothing to do.");
        } else {
            System.err.println("[booking #%03d".formatted(this.reservationID) +"] Warning! It's not possible to add another guest - room is already occupied!");
        }
    }

    /*
    * Remove a guest from booking.
    * If guest is not present, warn and do nothing.
    */
    public void removeGuestFromBooking(Guest guest) {
        if ( this.listOfGuests.contains(guest)) {
            this.listOfGuests.remove(guest);
        } else {
            System.err.println("[booking #%03d".formatted(this.reservationID) +"] Warning! <" + guest + "> is not present in the booking! Nothing to do.");
        }
    }
    ///endregion

    ///region Helpers region
    private String getGuestsList() {
        if (this.listOfGuests.size() == 0) return "NO GUESTS IN THE BOOKING!\n";
        String msg = "";
        for (Guest guest : this.listOfGuests ) {
            msg += "* %s %s%n".formatted(guest.getName(), guest.getSurname());
        }
        return msg;
    }

    private String getVacanciesRatio() {
        int freeBeds = this.room.getNumberOfBeds() - this.listOfGuests.size();
        return "(%d/%d beds available)".formatted(freeBeds, this.room.getNumberOfBeds());
    }
    ///endregion

}
