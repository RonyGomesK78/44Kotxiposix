package org.academiadecodigo.kotxiposix.rockPaperScissors;

public enum RockPaperScissors {

    ROCK("Smash SCISSOR"),
    PAPER("Wrap ROCK"),
    SCISSORS("Cut PAPER");

    private String action;

    RockPaperScissors(String action){

        this.action = action;
    }

    public String getAction(){

        return action;
    }
}
