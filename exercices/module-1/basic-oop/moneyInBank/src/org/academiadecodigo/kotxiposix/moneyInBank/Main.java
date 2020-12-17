package org.academiadecodigo.kotxiposix.moneyInBank;

public class Main {

    public static void main(String[] args) {

        String name = "Maria";

        Person person = new Person(name, new Wallet(20), new Bank(500));

        System.out.println("Once upon a time a young woman called " + person.getName() + " had a dream to buy a gamer laptop that cost 5000 euro");
        System.out.println("Maria had " + person.seeMoneyInWallet() + " euros on her old wallet and " + person.seeMoneyInBank() + " euros on her piggy bank");
        System.out.println("So missing just " + (5000 - seeSavings(person.seeMoneyInWallet(), person.seeMoneyInBank())) + " euros to buy her dream's laptop");
        System.out.println();

        System.out.println("Maria decided to sell some of her stuff... she sold a Samsung tablet for 250 euros!!!");
        person.winMoney(250);
        System.out.println("And she sold his brother's PS5 for 400 euros!!!");
        person.winMoney(400);
        System.out.println("She won 650 euros of her sales... she put 550 euros in her piggy bank and rest in her wallet");
        person.takeMoneyFromWallet(550);
        person.putInBank(550);

        System.out.println();
        System.out.println("So now she have " + person.seeMoneyInWallet() + " euros in her wallet and " + person.seeMoneyInBank() + " euros in piggy bank");
        System.out.println();

        System.out.println("Today it's her birthday...her father give she 600 euros and her mother give she a new  laptop");
        person.winMoney(600);
        System.out.println("But the laptop its not fit what she want and she sold it for 950 euros");
        person.winMoney(950);
        System.out.println();

        System.out.println("She put all the money that she earn on her birthday in the bank");
        person.takeMoneyFromWallet(1550);
        person.putInBank(1550);

        System.out.println();
        System.out.println("So now she have " + person.seeMoneyInWallet() + " euros in her wallet and " + person.seeMoneyInBank() + " euros in piggy bank");
        System.out.println();

        System.out.println("Maria is very happy because she's had less than half for buying the gamer laptop...she now have " + seeSavings(person.seeMoneyInWallet(), person.seeMoneyInBank()));
        System.out.println();

        System.out.println("His brother returned from travel and is very furious and is asking for 700 euros");
        System.out.println("Maria don't have another option and she give him 700 euros");
        person.takeMoneyFromBank(700);
        System.out.println("So now she have " + person.seeMoneyInWallet() + " euros in her wallet and " + person.seeMoneyInBank() + " euros in piggy bank");



        System.out.println("Now she is very sad with herself...and when she's sad she eat a lot of chocolate, she spend all the money at her wallet in chocolate");
        person.spendMoney(person.seeMoneyInWallet());

        System.out.println();
        System.out.println("So now she have " + person.seeMoneyInWallet() + " euros in her wallet and " + person.seeMoneyInBank() + " euros in piggy bank");
        System.out.println();

        System.out.println();
        System.out.println(seeSavings(person.seeMoneyInWallet(), person.seeMoneyInBank()));
        System.out.println();
    }

    private static int seeSavings(int num1, int num2){

        return num1 + num2;
    }

}
