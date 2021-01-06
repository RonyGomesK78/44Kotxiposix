package org.academiadecodigo.bootcamp.battle;

import org.academiadecodigo.bootcamp.battle.fighters.Fighter;
import org.academiadecodigo.bootcamp.battle.fighters.Marksman;
import org.academiadecodigo.bootcamp.battle.fighters.Troll;
import org.academiadecodigo.bootcamp.battle.fighters.Wizard;

public class Main {

    public static void main(String[] args) {

        Player playerOne = new Player("Ash",
                new Fighter[]{
                        new Troll("Ash Troll"),
                        new Wizard("Ash Wizard"),
                        new Marksman("Ash Wizard")
                });

        Player playerTwo = new Player("Gary",
                new Fighter[]{
                        new Troll("Gary Troll"),
                        new Wizard("Gary Wizard"),
                        new Marksman("Gary Marksman")
                });

        Arena arena = new Arena(playerOne, playerTwo);

        arena.battle();
    }
}
