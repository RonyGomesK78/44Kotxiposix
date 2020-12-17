package org.academiadecodigo.bootcamp;

public class Player {

    private String name;
    private int chosenNumbers[] = new int[10];
    private int countAttempts = 0;

    public Player(String name){

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public int chooseNumber(int maxNumber){

        int chosen = RandomNumberGenerator.generateNumber(maxNumber); ;
        boolean exist = true;

        while(exist){

            for(int i = 0; i < countAttempts + 1; i++){

                if(chosen == chosenNumbers[i]) {

                    chosen = RandomNumberGenerator.generateNumber(maxNumber);
                    i = -1;
                }
            }
            setChosenNumbers(chosen);
            exist = false;
        }
        return chosen;
    }

    private void setChosenNumbers(int choice){

        chosenNumbers[countAttempts] = choice;

        countAttempts++;
    }



}
