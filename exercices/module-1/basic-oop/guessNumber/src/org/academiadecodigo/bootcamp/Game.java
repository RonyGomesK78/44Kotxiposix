package org.academiadecodigo.bootcamp;

public class Game {

    private int maxNumber = 10;
    private int chosenNumber;
    private Player[] players;

    public Game(Player[] players){

        chosenNumber = chooseNumber();
        this.players = players;
    }

    public void start(){

        int numOfPlayers = players.length;
        boolean isNotOver = true;
        int choose;
        int rounds = 3;
        int countRound = rounds;

        System.out.println("SHHHIU THE NUMBER IS : " + chosenNumber);

        while(isNotOver){

            countRound--;

            if(countRound  < 0){

                System.out.println("\n Hey LOSERS...I won the game!!!");
                break;
            }

            for (int i = 0; i < numOfPlayers; i++){


                System.out.println("\nChoose a number between 0 and " + maxNumber + " " + players[i].getName() + "...YOU HAVE ONLY " +  (countRound + 1) + " ATTEMPTS");
                choose = players[i].chooseNumber(maxNumber);
                System.out.println("I choose " + choose);

                if(chosenNumber == choose){

                    System.out.println("SHIT...Your guess is correct!!!");
                    System.out.println(players[i].getName() + " won the game");

                    isNotOver = false;
                    break;
                }
                System.out.println("Your guess is wrong!!!");


            }

        }

    }
    private int chooseNumber(){

        return RandomNumberGenerator.generateNumber(maxNumber);
    }


}
