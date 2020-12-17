package org.academiadecodigo.kotxiposix.bookRoom;

public class Main {

    public static void main(String[] args) {

        int numberOfRooms = 10;
        String hotelName = "Plateau Resort";

        Client client1 = new Client("Ana");
        Client client2 = new Client("Richard");
        Client client3 = new Client("Marie");


        Hotel hotel = new Hotel(hotelName, numberOfRooms);

        client1.earnMyHotel(hotel);
        client1.takeKey();
        //System.out.println(client1.seeRoomNumber());

        client2.earnMyHotel(hotel);
        client2.takeKey();
        //System.out.println(client2.seeRoomNumber());

        hotel.printRooms();

        client1.giveKey();
        System.out.println();
        hotel.printRooms();


    }
}
