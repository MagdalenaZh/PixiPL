/**

 * File: Main.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */


package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Font.loadFont(getClass().getResourceAsStream("/Agbalumo-Regular.ttf"), 14);

            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();

            Image icon = new Image(getClass().getResourceAsStream("/images/bcloud.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("PixiPL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    
   @Override
    public void stop() throws Exception {
        clearFileContents("src/textFiles/noteEntries.txt");
        clearFileContents("src/textFiles/goalEntries.txt");
        clearFileContents("src/textFiles/toDoEntries.txt");
        clearFileContents("src/textFiles/fnoteEntries.txt");
        clearFileContents("src/textFiles/fgoalEntries.txt");
        clearFileContents("src/textFiles/ftoDoEntries.txt");
        clearFileContents("src/textFiles/enoteEntries.txt");
        clearFileContents("src/textFiles/egoalEntries.txt");
        clearFileContents("src/textFiles/etoDoEntries.txt");
    }

    private void clearFileContents(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                file.delete(); // Delete the file
                file.createNewFile(); // Recreate the file
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
