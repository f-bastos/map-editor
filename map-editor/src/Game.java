import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    private Grid grid;
    private Cursor cursor;


    public Game (int cols, int rows, int cellSize, Color cursorColor, Color rectanguleGridColor) {
        grid = new Grid(cols, rows, cellSize, rectanguleGridColor);
        cursor = new Cursor(grid, cursorColor);
    }


    public void initGame() {
        KeyboardController keyboardController = new KeyboardController(grid, cursor);
    }

    public void saveAndLoad() {
        FileManager fileManager = new FileManager(grid);
    }









}
