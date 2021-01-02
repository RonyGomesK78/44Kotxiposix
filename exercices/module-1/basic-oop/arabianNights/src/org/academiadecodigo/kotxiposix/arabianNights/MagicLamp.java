package org.academiadecodigo.kotxiposix.arabianNights;

public class MagicLamp {

    final private int numberOfGenies;
    private Genie [] genie;
    private RecyclableGenie recyclableGenie;
    private int remainingGenies;
    private int releaseNumber = 0;


    public MagicLamp(int maximumNumberOfGenies) {

        this.numberOfGenies = maximumNumberOfGenies;
        remainingGenies = maximumNumberOfGenies;
        genie = new Genie[numberOfGenies];

    }

    public int getNumberOfGenies() {

        return numberOfGenies;
    }

    public void rub(int evenOrGrumpy){

        if(remainingGenies > 0){

            if(evenOrGrumpy % 2 == 0){ // create new friendly genie

                genie[releaseNumber] = new FriendlyGenie(GenieType.FriendlyGenie, RandomNumberGenerator.generateNumber(4) + 1); //a genius can grant a maximum of 5 wishes
            }
            else{ // create new grumpy genie

                genie[releaseNumber] = new GrumpyGenie(GenieType.GrumpyGenie, RandomNumberGenerator.generateNumber(4) + 1);
            }

            genie[releaseNumber].grantWish();

            releaseNumber++;
            remainingGenies--;
        }

        else if(releaseNumber >= numberOfGenies && releaseNumber < totalNumberOfWishes()){

            for (int i = 0; i < numberOfGenies; i++){

                if(genie[releaseNumber % numberOfGenies].grantWish()){ //if the next genie have available wishes

                    releaseNumber++;
                    break;
                }

                else{ // else look to the next genie

                    int pos = (releaseNumber % numberOfGenies) + 1;

                    for(int j = 0; j < numberOfGenies; j++){

                        if(pos == releaseNumber % numberOfGenies){

                            pos++;
                        }
                        else if(pos < numberOfGenies){

                            if(genie[pos].grantWish()){

                                releaseNumber++;
                                i = totalNumberOfWishes();
                                break;
                            }
                            else{

                                pos++;
                            }
                        }
                        else{

                            j = 0;
                            pos = j;
                        }
                    }
                }

            }
        }

        else{

            if(recyclableGenie == null){

                recyclableGenie = new RecyclableGenie(GenieType.RecyclableDemon, RandomNumberGenerator.generateNumber(4) + 1);
            }
            recyclableGenie.grantWish();
        }
    }

    private int totalNumberOfWishes(){

        int total = 0;
        for (int i = 0; i < numberOfGenies; i++){

            total += genie[i].getWishesNumber();
        }

        return total;
    }

    public void recharge(RecyclableGenie recyclableGenie){

        recyclableGenie.recycle();

        if(recyclableGenie.getCanRecycled()){

            genie = null;
            releaseNumber = 0;
        }
    }




}
