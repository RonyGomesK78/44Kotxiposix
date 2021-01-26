package org.academiadecodigo.kotxiposix.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Cursor extends Cell{

    public Cursor() {

        super(0, 0);

        cell.setColor(Color.GREEN);
        cell.fill();
    }

    public void moveLeft(){

        col--;
        cell.translate(-cellSize, 0);
    }

    public void moveRight(){

        col++;
        cell.translate(cellSize, 0);
    }

    public void moveUp(){

        row--;
        cell.translate(0, -cellSize);
    }

    public void moveDown(){

        row++;
        cell.translate(0, cellSize);
    }

}
