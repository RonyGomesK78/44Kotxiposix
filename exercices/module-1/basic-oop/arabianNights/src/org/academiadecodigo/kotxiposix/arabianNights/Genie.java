package org.academiadecodigo.kotxiposix.arabianNights;

public class Genie {

    final private int wishesNumber;
    final private GenieType genieType;
    private WishType wishType;
    private int wishesRemaining;
    private int grantedWishes = 0;

    public Genie(GenieType genieType, int wishesNumber){

        this.genieType = genieType;
        this.wishesNumber = wishesNumber;
        wishesRemaining = wishesNumber;
    }

    public int getGrantedWishes() {

        return grantedWishes;
    }

    public int getWishesNumber() {

        return wishesNumber;
    }

    public int getWishesRemaining() {

        return wishesRemaining;
    }

    public WishType getWishType() {

        return wishType;
    }

    public GenieType getGenieType() {

        return genieType;
    }

    public void setWishesRemaining(){

        wishesRemaining--;
        grantedWishes++;
    }

    public boolean grantWish(){

        if(wishesRemaining > 0){

            System.out.println("Hello I'm a " + genieType);
            System.out.println("You have " + wishesRemaining + " wishes remaining.");

            System.out.println("Your wish to " + wishType.values()[RandomNumberGenerator.generateNumber(5)].getWish() + " was granted");
            System.out.println();

            wishesRemaining--;
            grantedWishes++;

            return true;
        }

        return false;
    }

}
