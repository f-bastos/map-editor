import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Grid grid;
    private Rectangle cursor;
    private Color color;


    public Cursor(Grid grid, Color color) {
        this.grid = grid;
        this.color = color;
        this.cursor = new Rectangle(Grid.PADDING, Grid.PADDING, grid.getCellSize(), grid.getCellSize());
        drawCursor(color);
    }


    public void drawCursor(Color color) {
        cursor.setColor(color);
        cursor.fill();
    }


    public void moveUp() {
        if (cursor.getY() > Grid.PADDING) {
            cursor.translate(0, -grid.getCellSize());
        }
    }

    public void moveDown() {
        if (cursor.getY() < (grid.rowsToY(grid.getRows()) - grid.getCellSize())) {
            cursor.translate(0, grid.getCellSize());
        }
    }

    public void moveLeft() {
        if (cursor.getX() > Grid.PADDING) {
            cursor.translate(-grid.getCellSize(), 0);
        }
    }

    public void moveRight() {
        if (cursor.getX() < (grid.colsToX(grid.getCols()) - grid.getCellSize())) {
            cursor.translate(grid.getCellSize(), 0);
        }
    }



    // search for rectangule in the cursor position
    // paint if it's unpaint
    // unpaint it it isn't paint
    public void paintUnpaintRectangule () {

        for (int i=0; i<grid.getGridRectangules().length; i++) {

            if (cursor.getX() == grid.getGridRectangules()[i].getX() && cursor.getY() == grid.getGridRectangules()[i].getY()) {

                if (grid.getIsRectangulePainted()[i]) {
                    grid.unpaintRectangule(i);

                } else {
                    grid.paintRectangule(i, grid.getRectaguleGridColor());
                }
            }
        }
    }

}