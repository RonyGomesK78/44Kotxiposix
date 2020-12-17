package org.academiadecodigo.kotxiposix.bookRoom;

public class Room {

    private boolean availability;


    public Room(){

        availability = true;
    }
    public boolean getAvailability(){

        return availability;
    }

    public void setAvailability(boolean change){

        availability = change;
    }

    @Override
    public String toString(){

        return String.format(availability ?  "Free" : "Busy");
    }
}
