package org.academiadecodigo.kotxiposix.moneyInBank;

public class Person {

    private String name;
    private Wallet wallet;
    private Bank piggyBank;

    Person(String name, Wallet wallet, Bank bank){

        this.name = name;
        this.wallet = wallet;
        piggyBank = bank;
    }

    public String getName() {

        return name;
    }

    public void winMoney(int money){

        wallet.addMoney(money);
    }

    public void putInWallet(int money){

        wallet.addMoney(money);
    }

    public void putInBank(int money){

        piggyBank.deposit(money);
    }

    public void spendMoney(int money){

        wallet.takeMoney(money);
    }

    public int seeMoneyInBank(){

        return piggyBank.seeBalance();
    }

    public int seeMoneyInWallet(){

        return wallet.seeMoney();
    }

    public void takeMoneyFromWallet(int amount){

        wallet.takeMoney(amount);
    }

    public void takeMoneyFromBank(int amount){

        piggyBank.withdraw(amount);
    }
}
