package org.academiadecodigo.kotxiposix.rockPaperScissors;

public class Main {

    public static void main(String[] args) {


        Player[] players = {

                new Player("Luis"),
                new Player("Rony")
        };

        Game game = new Game(5, players);
        game.startGame();
    }
}
