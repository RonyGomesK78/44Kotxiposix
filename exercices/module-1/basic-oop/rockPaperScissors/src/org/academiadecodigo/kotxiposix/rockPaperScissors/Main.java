package org.academiadecodigo.kotxiposix.rockPaperScissors;

public class Main {

    public static void main(String[] args) {


        Player[] players = {

                new Player("Goku"),
                new Player("Vegeta")
        };

        Game game = new Game(5, players);
        game.startGame();
    }
}
