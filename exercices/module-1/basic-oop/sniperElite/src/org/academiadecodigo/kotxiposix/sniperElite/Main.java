package org.academiadecodigo.kotxiposix.sniperElite;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(new SniperRifle(3), 15);

        game.start();
    }
}
