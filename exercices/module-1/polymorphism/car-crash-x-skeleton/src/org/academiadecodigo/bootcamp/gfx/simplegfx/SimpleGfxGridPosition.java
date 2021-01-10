package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        /*simpleGfxGrid = grid;
        rectangle = new Rectangle(SimpleGfxGrid.PADDING, SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());
        rectangle.fill();*/
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;


        rectangle = new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        rectangle.fill();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {


        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {

        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int col = getCol(); //save the logic position(col & row) before the moveInDirection method
        int row = getRow();

        super.moveInDirection(direction, distance);

        //int moveCol = col != getCol() ? getCol() - col : 0; // compare the the logic position against the after
        //int moveRow = row != getRow() ? getRow() - row : 0; // and before move method call, if different compute how many rows or cols moved

        int x = simpleGfxGrid.columnToX(getCol() - col) - SimpleGfxGrid.PADDING;
        int y = simpleGfxGrid.rowToY(getRow() - row) - SimpleGfxGrid.PADDING;

        rectangle.translate(x, y);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}
