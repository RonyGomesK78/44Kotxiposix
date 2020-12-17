package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Carlos");
        Player p2 = new Player("Mateus");
        //Player p3 = new Player("Maria");

        Player[] players = {p1, p2};

        Game game = new Game(players);
        game.start();
    }
}
