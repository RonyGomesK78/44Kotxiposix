package org.academiadecodigo.kotxiposix.arabianNights;

public class RecyclableGenie extends Genie{

    private boolean canRecycled = true;

    public RecyclableGenie(GenieType genieType, int numberOfWishes){

        super(GenieType.RecyclableDemon ,numberOfWishes);
    }

    public boolean isCanRecycled() {

        return canRecycled;
    }

    @Override
    public boolean grantWish(){

        System.out.println("I'm a " + getGenieType());

        if(canRecycled){

            if(getWishesRemaining() > 0){

                System.out.println("You have " + getWishesRemaining() + " wishes remaining.");

                setWishesRemaining();

            }
            else {

                System.out.println("You have no more wishes left but I'll grant you one more");
            }

            System.out.println("Your wish to " + getWishType().values()[RandomNumberGenerator.generateNumber(5)].getWish() + " was granted");
            System.out.println();

            return true;
        }
        else{

            System.out.println("I will not grant anymore wishes, because I've already been  was recycled!!!");
            System.out.println();

            return false;
        }
    }

    public boolean recycle(){

        if(canRecycled){

            canRecycled = false;
            return true;
        }

        return false;
    }
}

