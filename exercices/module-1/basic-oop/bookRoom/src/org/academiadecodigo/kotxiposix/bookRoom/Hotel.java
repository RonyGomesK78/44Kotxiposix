package org.academiadecodigo.kotxiposix.bookRoom;

public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel(String name, int roomsTotal){

        rooms = new Room[roomsTotal];

        for(int i = 0; i < roomsTotal; i++){

            rooms[i] = new Room();
        }
    }

    public String getName(){

        return name;
    }

    public int checkIn(int key){

        if(key == -1){


            for(int i = 0; i < rooms.length; i++){

                if(rooms[i].getAvailability()){ //if true means the room is available and  return a key(index)

                    rooms[i].setAvailability(false);
                    return i;
                }
            }
        }

        return -1; // return -1 if the client had already check in or if no rooms is available
    }

    public boolean checkOut(int key){

        boolean canGo = false;

        if(!rooms[key].getAvailability()){//if true means the room is unavailable...so the client can checkout

            rooms[key].setAvailability(true);
            canGo = true;
        }

        return canGo;
    }

    public void printRooms(){

        for(Room room : rooms){

            System.out.println(room.toString());
        }
    }
}
