package org.academiadecodigo.kotxiposix.moneyInBank;

public class Bank {

    private int amount;

    public Bank(int amount){

        this.amount = amount;
    }

    public int withdraw(int amount){

        if(amount <= this.amount){

            this.amount -= amount;
            return amount;
        }

        else{

            return 0;
        }
    }

    public void deposit(int amount){

        this.amount += amount;
    }

    public int seeBalance(){

        return amount;
    }
}
