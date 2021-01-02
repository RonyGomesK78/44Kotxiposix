package org.academiadecodigo.kotxiposix.arabianNights;

public class GrumpyGenie extends Genie{

    public GrumpyGenie(GenieType genieType, int numberOfWishes){

        super(genieType, numberOfWishes);
    }

    @Override
    public boolean grantWish(){


        if(getWishesRemaining() > 0){

            System.out.println("I'm a " + getGenieType());
            System.out.println("You have " + getWishesRemaining() + " wishes remaining.");

            if(getGrantedWishes() < 1){

                System.out.println("Your wish to " + getWishType().values()[RandomNumberGenerator.generateNumber(5)].getWish() + " was granted");

                System.out.println();
            }

            else{

                System.out.println("...but I won't give anymore them to you!!!\n");
            }

            setWishesRemaining();

            return true;
        }

        return false;
    }
}
