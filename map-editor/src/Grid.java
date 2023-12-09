import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Grid {

    public static final int PADDING = 10;
    private int cellSize;
    private int cols;
    private int rows;
    private Rectangle grid;
    private Rectangle[] gridRectangules;
    private boolean[] isRectangulePainted;
    private Color rectaguleGridColor;


    public Grid(int cols, int rows, int cellSize, Color rectanguleGridColor) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.rectaguleGridColor = rectanguleGridColor;
        grid = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        grid.draw();
        drawInnerRectangules();
    }


    public int colsToX(int col) {
        return (col * cellSize) + PADDING;
    }

    public int rowsToY(int row) {
        return (row * cellSize) + PADDING;
    }

    public void drawInnerRectangules() {
        gridRectangules = new Rectangle[cols * rows];
        isRectangulePainted = new boolean[cols * rows];

        int h = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rectangle = new Rectangle(colsToX(i), rowsToY(j), cellSize, cellSize);
                rectangle.draw();
                gridRectangules[h] = rectangle;
                h++;
            }
        }
    }

    public void paintRectangule(int index, Color rectaguleGridColor) {
        gridRectangules[index].setColor(rectaguleGridColor);
        gridRectangules[index].fill();
        isRectangulePainted[index] = true;
    }

    public void unpaintRectangule(int index) {
        gridRectangules[index].setColor(Color.BLACK);
        gridRectangules[index].draw();
        isRectangulePainted[index] = false;
    }

    public void clearAllPaintedRectangules() {
        for (int i = 0; i < gridRectangules.length; i++) {
            unpaintRectangule(i);
        }
    }


    public int getCellSize() {
        return cellSize;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Rectangle[] getGridRectangules() {
        return gridRectangules;
    }

    public boolean[] getIsRectangulePainted() {
        return isRectangulePainted;
    }

    public Color getRectaguleGridColor() {
        return rectaguleGridColor;
    }

}