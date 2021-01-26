package org.academiadecodigo.kotxiposix.mapeditor;

public class Grid {

    private int cols;
    private int rows;
    private Cell[][] cells;

    public Grid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;

        cells = new Cell[cols][rows];

        for (int i = 0; i < cols; i++) {

            for (int j = 0; j < rows; j++) {

                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public int getCols() {

        return cols;
    }

    public int getRows() {

        return rows;
    }

    public boolean isPainted(int col, int row){

        return cells[col][row].getIsPainted();
    }

    public void paint(int col, int row){

        this.cells[col][row].paint();
    }

    public void erase(int col, int row){

        this.cells[col][row].erase();
    }
}
