package org.academiadecodigo.kotxiposix.mapeditor;

import com.sun.tools.internal.xjc.reader.xmlschema.BindGreen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private enum ColorType {

        GREEN,
        YELLOW,
        BLACK,
        WHITE
    }

    int row;
    int col;
    int cellSize = 30;

    boolean isPaint = false;
    boolean isInverted = false;

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

    public void paint() {

        isPaint = true;

        cell.setColor(!isInverted ?

                Color.RED :
                Color.BLACK
        );

        cell.fill();
    }

    public void invertColors() {

        if (isInverted) {

            if (isPaint){

                cell.setColor(Color.RED);

            }else {

                cell.setColor(Color.BLACK);
                cell.draw();
            }

            isInverted = false;

        } else {

            cell.setColor(isPaint ?

                    Color.BLACK :
                    Color.WHITE
            );

            isInverted = true;
        }


    }

    public void erase() {

        isPaint = false;

        cell.setColor(isInverted ?

                Color.WHITE :
                Color.BLACK
        );

        cell.draw();
    }

    private int columnToX(int col) {

        return col * cellSize;
    }

    private int rowToX(int row) {

        return row * cellSize;
    }

}
