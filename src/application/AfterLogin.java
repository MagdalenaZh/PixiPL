/**

 * File: AfterLogin.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;
    @FXML
    private Label helloName;


    // Method to display the username
    public void displayName(String username) {
        helloName.setText("Hello " + username + "!");
    }
    
    // Initialization method
    public void initialize() {
        // Using Timeline to delay transitioning to the next scene for 3 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            try {
                // Transition to the next scene after 3 seconds
                characterCreationScene(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        timeline.play(); // Start the timeline
    }

    // Method to transition to the character creation scene
    public void characterCreationScene(ActionEvent event) throws IOException {
        // Instantiate the Main class and change the scene to "map.fxml"
        Main m = new Main();
        m.changeScene("map.fxml");
    }
}
