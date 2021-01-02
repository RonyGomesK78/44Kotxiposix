package org.academiadecodigo.kotxiposix.arabianNights;

public enum WishType {

    PEACE("set world peace"),
    RICH("be rich"),
    HUNGRY("end world hunger"),
    DISEASES("end diseases"),
    VIOLENCE("end violence");

    private String wish;

    WishType(String wish){

        this.wish = wish;
    }

    public String getWish(){

        return wish;
    }
}
