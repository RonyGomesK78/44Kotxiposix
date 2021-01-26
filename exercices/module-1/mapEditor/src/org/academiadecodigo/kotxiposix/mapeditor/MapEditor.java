package org.academiadecodigo.kotxiposix.mapeditor;

public class MapEditor {

    private Grid grid;
    private Cursor cursor;

    public MapEditor(int cols, int rows){

        grid = new Grid(cols, rows);
        cursor = new Cursor();
    }

    public Grid getGrid() {

        return grid;
    }

    public Cursor getCursor() {

        return cursor;
    }

    public boolean onEdge(KeyboardManager.Direction direction){

        switch (direction){

            case UP:
                if (cursor.row > 0){

                    return false;
                }
                return true;

            case DOWN:
                if (cursor.row < grid.getRows() - 1){

                    return false;
                }
                return true;

            case LEFT:
                if (cursor.col > 0){

                    return false;
                }
                return true;

            case RIGHT:
                if (cursor.col < grid.getCols() - 1){

                    return false;
                }
                return true;
        }

        return false;
    }

}
