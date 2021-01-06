package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.Utils;

public class Position {

    private int row;
    private int column;

    public Position(int row, int col){

       this.row = row;
       this.column = col;
    }

    public int getCol() {

        return column;
    }

    public int getRow() {

        return row;
    }

    public void setRow(int row) {

       this.row = row;
    }

    public void setCol(int col) {

        this.column = col;
    }

}
