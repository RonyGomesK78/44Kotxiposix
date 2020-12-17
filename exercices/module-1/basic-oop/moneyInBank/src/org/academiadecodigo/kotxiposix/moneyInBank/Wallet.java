package org.academiadecodigo.kotxiposix.moneyInBank;

public class Wallet {

    private int amount;

    public Wallet(int amount){

        this.amount = amount;
    }

    public int takeMoney(int amount){

        if(amount <= this.amount){

            this.amount -= amount;
            return this.amount;
        }

        else{

            return 0; // no money
        }
    }

    public void addMoney(int amount){

        this.amount += amount;
    }

    public int seeMoney(){

        return amount;
    }
}
