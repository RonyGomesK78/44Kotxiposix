package org.academiadecodigo.kotxiposix.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    int row;
    int col;
    int cellSize = 30;
    boolean isPaint = false;

    Rectangle cell;

    public Cell(int col, int row) {

        this.row = row;
        this.col = col;

        cell = new Rectangle(columnToX(col), rowToX(row), cellSize, cellSize);
        cell.draw();
    }

    public int getRow() {

        return row;
    }

    public int getCol() {

        return col;
    }

    public boolean getIsPainted() {

        return isPaint;
    }

    public void paint(){

        isPaint = true;
        cell.setColor(Color.ORANGE);
        cell.fill();
    }

    public void erase(){

        isPaint = false;
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    private int columnToX(int col){

        return col * cellSize;
    }

    private int rowToX(int row){

        return row * cellSize;
    }
}
