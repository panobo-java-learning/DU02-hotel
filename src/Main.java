import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;
import com.engeto.hotel.VacationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ///region Guests region (hardcoded info)
        Guest guest1 = new Guest("Petr", "Sadlo", LocalDate.of(1986, 10, 10));
        Guest guest2 = new Guest("Filip", "Nejzchleba", LocalDate.of(1987, 9, 11));
        Guest guest3 = new Guest("Jana", "Nova", LocalDate.of(1988, 8, 12));
        Guest guest4 = new Guest("Maggi", "Gravenel", LocalDate.of(1967, 12, 31));
        Guest guest5 = new Guest("Alidia", "M'Quhan", LocalDate.of(1998, 12, 10));
        Guest guest6 = new Guest("Judie", "Manjot", LocalDate.of(1997, 3, 3));
        Guest guest7 = new Guest("Louisette", "Lumly", LocalDate.of(1992, 10, 29));
        Guest guest8 = new Guest("Agnesse", "Willerson", LocalDate.of(1990, 3, 15));
        Guest guest9 = new Guest("Krista", "Yekel", LocalDate.of(1986, 5, 30));
        Guest guest10 = new Guest("Neill", "Tree", LocalDate.of(2012, 9, 29));
        Guest guest11 = new Guest("Temp", "Wheldon", LocalDate.of(2015, 8, 1));
        Guest guest12 = new Guest("Whitaker", "James", LocalDate.of(1980, 11, 6));
        ///endregion

        ///region Rooms region (hardcoded info)
        Room room1 = new Room(10, 2, true, true, BigDecimal.valueOf(1230.5));
        Room room2 = new Room(9, 1, true, false, BigDecimal.valueOf(560));
        Room room3 = new Room(8, 3, false, true, BigDecimal.valueOf(1800));
        Room room4 = new Room(7, 4, false, false, BigDecimal.valueOf(2500));
        ///endregion

        ///region App - record bookings
        Booking reservation1 = new Booking(room1,
                new ArrayList<>(),
                LocalDate.of(2022, 12, 30),
                LocalDate.of(2023, 3,3),
                VacationType.WORKING );
        reservation1.addGuestToBooking(guest1);
        reservation1.addGuestToBooking(guest1);
        reservation1.addGuestToBooking(guest2);

        Booking reservation2 = new Booking(room2,
                new ArrayList<>(),
                LocalDate.of(2023, 3, 1),
                LocalDate.of(2023, 3,3),
                VacationType.WORKING );
        reservation2.addGuestToBooking(guest3);
        System.out.println(reservation2);
        reservation2.addGuestToBooking(guest2);
        System.out.println(reservation2);
        reservation2.removeGuestFromBooking(guest3);
        System.out.println(reservation2);
        reservation2.removeGuestFromBooking(guest4);
        System.out.println(reservation2);
        reservation2.addGuestToBooking(guest5);
        System.out.println(reservation2);

        Booking reservation3 = new Booking(room3,
                new ArrayList<>(),
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5,10),
                VacationType.RECREATIVE );
        reservation3.addGuestToBooking(guest6);
//        reservation3.addGuestToBooking(guest7);
        reservation3.addGuestToBooking(guest8);

        Booking reservation4 = new Booking(room4,
                new ArrayList<>(),
                LocalDate.of(2023, 7, 1),
                LocalDate.of(2023, 7,21),
                VacationType.RECREATIVE );
        reservation4.addGuestToBooking(guest9);
        reservation4.addGuestToBooking(guest10);
        reservation4.addGuestToBooking(guest11);
        reservation4.addGuestToBooking(guest12);
        ///endregion

        ///region Report output
        System.out.println("\n-------\nReport:\n-------");
        System.out.println(reservation1);
        System.out.println();
        System.out.println(reservation2);
        System.out.println();
        System.out.println(reservation3);
        System.out.println();
        System.out.println(reservation4);

        ///endregion
    }
}

/* Generated for testing purpose
    Guest guest13 = new Guest("Cyrill", "Hurich", LocalDate.of(19.., 6, 9));
    Guest guest14 = new Guest("Janette", "Coram", LocalDate.of(19.., 8, 12));
    Guest guest15 = new Guest("Zeb", "Highnam", LocalDate.of(19.., 7, 4));
    Guest guest16 = new Guest("Kinna", "Belz", LocalDate.of(19.., 8, 16));
    Guest guest17 = new Guest("Bond", "Whitmell", LocalDate.of(19.., 11, 26));
    Guest guest18 = new Guest("Gothart", "Lowell", LocalDate.of(19.., 11, 21));
    Guest guest19 = new Guest("Ray", "Meiklam", LocalDate.of(19.., 4, 26));
    Guest guest19.. new Guest("Aubrey", "Klempke", LocalDate.of(2022, 10, 14));
    Guest guest21 = new Guest("Denis", "Brazil", LocalDate.of(19.., 7, 12));
    Guest guest22 = new Guest("Virgie", "Shitliffe", LocalDate.of(19.., 5, 30));
*/
