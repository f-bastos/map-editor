import org.academiadecodigo.simplegraphics.graphics.Color;

public class Main {
    public static void main(String[] args) {


    Game game = new Game(20, 20, 20, Color.GREEN, Color.CYAN);

    game.initGame();

    game.saveAndLoad();

    }
}