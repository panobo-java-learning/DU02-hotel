package com.engeto.hotel;

import java.math.BigDecimal;

public class Room {

    ///region attributes
    private int roomNumber;
    private int numberOfBeds;
    private boolean balconyPresent;
    private boolean viewOfSeaPossible;  // in case of no-smog-fog situation :)
    private BigDecimal priceForNight;
    ///endregion

    ///region constructors
    public Room(int room, int beds, boolean isBalcony, boolean isSeaView, BigDecimal price) {
        roomNumber = room;
        numberOfBeds = beds;
        balconyPresent = isBalcony;
        viewOfSeaPossible = isSeaView;
        priceForNight = price;
    }
    ///endregion

    ///region getters and setters
    public BigDecimal getPriceForNight() {
        return priceForNight;
    }

    public void setPriceForNight(BigDecimal priceForNight) {
        this.priceForNight = priceForNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isBalconyPresent() {
        return balconyPresent;
    }

    public boolean isViewOfSeaPossible() {
        return viewOfSeaPossible;
    }
    ///endregion

    ///region override
    @Override
    public String toString() {
        return "Room %2d: %d bed%s".formatted(this.roomNumber, this.numberOfBeds,
                                                (this.numberOfBeds > 1) ? "s" : "")
                + "%s%s".formatted(
                        (this.balconyPresent) ? ", the room has balcony" : "",
                        (this.viewOfSeaPossible) ? ", nice view at the sea" : "")
                + ", price for a night is " + this.priceForNight + ".";
    }

    ///endregion


}
