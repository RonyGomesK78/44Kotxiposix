package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Utils;
import org.academiadecodigo.carcrash.field.Position;

public abstract class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;
    private CarType carType;
    private int velocity;
    private boolean crashed = false;

    public Car(CarType carType, Position pos, int velocity){

        this.carType = carType;
        this.pos = pos;
        this.velocity = velocity;
    }

    @Override
    public String toString(){

        return getClass().getSimpleName().substring(0, 1);
    }

    public Position getPos() {

        return pos;
    }

    public int getVelocity(){

        return velocity;
    }

    public void setPos(){

        int horOrVer = Utils.getRandom(2);

        switch (horOrVer){

            case 0 : pos.setRow(nextMoveR());break;
            case 1 : pos.setCol(nextMoveC());break;
        }
    }

    private int nextMoveR() {

        int decide = Utils.getRandom(3);
        int posRow = pos.getRow();
        int move = posRow;

        if(decide == 0){

            move = posRow - velocity;

            if (move < 0){

                move = 0;
            }

        }

        else if(decide == 1){

            move = posRow + velocity;

            if (move > 24){

                move = 24;
            }
        }

        return move;
    }

    private int nextMoveC() {

        int decide = Utils.getRandom(2);
        int posCol = pos.getCol();
        int move = posCol;

        if(decide == 0){

            move = posCol - velocity;

            if(move < 0){

                move = 0;
            }

        }
        else if(decide == 1){

            move = posCol + velocity;

            if(move > 99){

                move = 99;
            }
        }

        return move;
    }

    public boolean isCrashed() {

        return crashed;
    }

    public void setCrashed(){

        crashed = true;
    }

}
