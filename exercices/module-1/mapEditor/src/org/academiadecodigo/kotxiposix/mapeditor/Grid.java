package org.academiadecodigo.kotxiposix.mapeditor;

import java.io.*;

public class Grid {

    private int cols;
    private int rows;
    private Cell[][] cells;

    public Grid(int cols, int rows) {

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

    public boolean isPainted(int col, int row) {

        return cells[col][row].getIsPainted();
    }

    public void paint(int col, int row) {

        this.cells[col][row].paint();
    }

    public void erase(int col, int row) {

        this.cells[col][row].erase();
    }

    private int[][] printGrid() {

        int[][] paint = new int[cols][rows];

        for (int i = 0; i < cols; i++) {

            for (int j = 0; j < rows; j++) {

                paint[i][j] = cells[i][j].isPaint ? 1 : 0;
            }
        }

        return paint;
    }

    public void eraseAll(){

        for (int i = 0 ; i < cols; i++){

            for (int j = 0; j < rows; j++) {

                erase(i, j);
            }
        }
    }
    public void saveToFile() throws IOException {

        int[][] paint = printGrid();

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {

            fileWriter = new FileWriter("/Users/codecadet/44kotxiposix/exercices/module-1/mapEditor/resource/files.txt");
            bufferedWriter = new BufferedWriter(fileWriter);


            for (int i = 0; i < cols; i++) {

                String line = "";

                for (int j = 0; j < rows; j++) {

                    line += paint[i][j];
                }
                bufferedWriter.write(line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if (bufferedWriter != null) {

                bufferedWriter.flush();
                bufferedWriter.close();

            }

        }
    }

    public void loadToFile() {

        FileReader fileReader;
        BufferedReader bufferedReader;

        try {

            fileReader = new FileReader("/Users/codecadet/44kotxiposix/exercices/module-1/mapEditor/resource/files.txt");
            bufferedReader = new BufferedReader(fileReader);

            // String result = "";
            String line = "";

            for (int i = 0; i < cols; i++) {

                line = bufferedReader.readLine();

                for (int j = 0; j < rows; j++) {

                    if (line.charAt(j) == '1') {

                        cells[i][j].paint();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void invertColors(){

        for (int i = 0; i < cols; i++) {

            for (int j = 0; j < rows; j++) {

                cells[i][j].invertColors();
            }
        }
    }

}
