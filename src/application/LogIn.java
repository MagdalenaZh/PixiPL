/**

 * File: LogIn.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LogIn {

    @FXML
    private Button loginButton;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField usernameBox;
    @FXML
    private PasswordField passwordBox;
    

    public void initialize() {
        // Method called when initializing the login interface
        addHoverAnimation(); // Adds hover animation to the login button
    }

    // Method to add a hover animation to the login button
    private void addHoverAnimation() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), loginButton);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);

        loginButton.setOnMouseEntered(event -> scaleTransition.playFromStart());

        scaleTransition.setOnFinished(event -> {
            ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(100), loginButton);
            reverseTransition.setToX(1);
            reverseTransition.setToY(1);
            reverseTransition.play();
        });
    }

    // Method triggered when the user attempts to log in
    public void userLogIn() throws IOException {
        String username = usernameBox.getText();

        if (username.isEmpty() || passwordBox.getText().isEmpty()) {
            // Inform the user to enter their data if fields are empty
            wrongLogIn.setText("Please enter your data.");
        } else if (username.equals("magytooo") && passwordBox.getText().equals("magito6")) {
            try {
                // Load the next scene after successful login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("afterLogin.fxml"));
                Parent root = loader.load();

                AfterLogin afterLoginController = loader.getController();
                afterLoginController.displayName(username); // Pass the username to display

                // Display the next scene after successful login
                Scene scene = new Scene(root);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Inform the user of wrong credentials if login fails
            wrongLogIn.setText("Wrong username or password!");
        }
    }

}
    

