import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;

public class FileManager {

    private Grid grid;


    public FileManager(Grid grid) {
        this.grid = grid;
    }


    // save file with info from painted rectangules
    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("save.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < grid.getGridRectangules().length; i++) {

                if (grid.getIsRectangulePainted()[i]) {
                    writer.write("1");
                } else {
                    writer.write("0");
                }
                writer.newLine();
            }

            writer.flush();
            writer.close();
            System.out.println("Data Entered in to the file successfully");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    // load file with info from painted rectangules and paint them
    public void load() {

        String result;
        try {
            FileReader reader = new FileReader("save.txt");
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";
            result = "";

            while ((line = bReader.readLine()) != null) {
                result += line + " ";
            }

            bReader.close();

            String[] resultLoad = result.split(" ");

            for (int i=0; i<grid.getIsRectangulePainted().length; i++) {

                if (resultLoad[i].equals("1")) {
                    grid.paintRectangule(i, grid.getRectaguleGridColor());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
