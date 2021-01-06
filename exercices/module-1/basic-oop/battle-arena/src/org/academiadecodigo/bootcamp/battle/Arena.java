package org.academiadecodigo.bootcamp.battle;

public class Arena {

    private final Player playerOne;
    private final Player playerTwo;

    public Arena(Player playerOne, Player playerTwo){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void battle(){

        Player toAttack = playerOne;

        while (!playerOne.lost() && !playerTwo.lost()){

            playRound(toAttack);
            toAttack = getDefender(toAttack);
            displayStatus(toAttack);
        }

        displayResults();
    }

    private void displayStatus(Player player){

        System.out.println(player.toString());
        System.out.println();
    }

    private void playRound(Player player){

        if (player == playerOne){

            playerOne.pAttack(playerTwo);
        }
        else {

            playerTwo.pAttack(playerOne);
        }
    }

    private Player getDefender(Player player){

      if (player == playerOne){

          return playerTwo;
      }
      return playerOne;
    }

    private void displayResults(){

        System.out.println(playerOne);
        System.out.println(playerTwo);
    }
}
