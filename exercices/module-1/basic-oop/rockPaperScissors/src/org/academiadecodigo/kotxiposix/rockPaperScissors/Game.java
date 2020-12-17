package org.academiadecodigo.kotxiposix.rockPaperScissors;

public class Game {

    int rounds;
    Player[] players;
    //RockPaperScissors rockPaperScissors;

    public Game(int rounds, Player[] players) {

        this.rounds = rounds;
        this.players = players;
    }


    public void startGame() {

        for (int i = 0; i < rounds; i++) {


            RockPaperScissors player1Guess =  players[0].chooseObject();
            RockPaperScissors player2Guess =  players[1].chooseObject();

            System.out.println(players[0].getName() + " choose " + player1Guess);
            System.out.println(players[1].getName() + " choose " + player2Guess);


            if(player1Guess == player2Guess){

                System.out.println("Its a tie\n");
                i--;
                continue;
            }

            players[beats(player1Guess, player2Guess)].score();

        }

        System.out.println("\n" + players[0].getName() + " score: " + players[0].getScore());
        System.out.println(players[1].getName() + " score " + players[1].getScore());


    }

    private int  beats(RockPaperScissors player1Guess, RockPaperScissors player2Guess){

        //System.out.println(player1Guess + " : "  + player2Guess);
        if((player1Guess == RockPaperScissors.ROCK && player2Guess == RockPaperScissors.SCISSORS) || (player1Guess == RockPaperScissors.PAPER && player2Guess == RockPaperScissors.ROCK) || (player1Guess == RockPaperScissors.SCISSORS && player2Guess == RockPaperScissors.PAPER)) {

            System.out.println(player1Guess + " " + player1Guess.getAction());
            System.out.println(players[0].getName() + " win!!!");
            System.out.println();
            return 0;
        }
        else{

            System.out.println(player2Guess + " " + player2Guess.getAction());
            System.out.println(players[1].getName() + " win!!!");
            System.out.println();
            return 1;
        }
    }


}
