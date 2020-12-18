package org.academiadecodigo.kotxiposix.bookRoom;

public class Client {

    private String name;
    private Hotel myHotel;
    private int roomNumber;

    public Client(String name){

        this.name = name;
        this.myHotel = null;
        this.roomNumber = -1;
    }

    public String getName(){

        return name;
    }

    public int seeRoomNumber(){

        return roomNumber;
    }

    public void earnMyHotel(Hotel hotel){

        myHotel = hotel;
    }

    public void takeKey(){

        if(myHotel != null){

            if(roomNumber == -1){

                roomNumber = myHotel.checkIn(roomNumber);
            }
        }
    }

    public void giveKey(){

        if(myHotel != null){

            if(myHotel.checkOut(roomNumber)){

                roomNumber = -1;
            }
        }
    }

    public void clientInfo(){

        System.out.println(name + " : " + roomNumber);
    }
}
