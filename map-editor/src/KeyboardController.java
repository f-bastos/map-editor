import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardController implements KeyboardHandler {

    private Grid grid;
    private Cursor cursor;
    private Keyboard keyboard;
    private FileManager fileManager;


    public KeyboardController(Grid grid, Cursor cursor) {
        this.grid = grid;
        this.cursor = cursor;
        this.keyboard = new Keyboard(this);
        this.fileManager = new FileManager(grid);
        initKeyboardController();
    }


    public void initKeyboardController() {
        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent paintUnpaint = new KeyboardEvent();
        paintUnpaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintUnpaint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);


        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(paintUnpaint);
        keyboard.addEventListener(clear);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                cursor.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.moveDown();
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_SPACE:
                cursor.paintUnpaintRectangule();
                break;

            case KeyboardEvent.KEY_C:
                grid.clearAllPaintedRectangules();
                break;

            case KeyboardEvent.KEY_S:
                fileManager.save();

                break;
            case KeyboardEvent.KEY_L:
                fileManager.load();
                break;

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}









