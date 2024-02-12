/**

 * File: Map1.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

import java.io.IOException;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;

public class Map1 {
	private ProgressController progressController;
	double progress;
	@FXML
    private Stage primaryStage;
	@FXML
    private Button educationButton; 
	@FXML
    private Button healthButton; 
	@FXML
	private Button financeButton;
	 @FXML
	private Button exitButton;
	
	private int chosenCharacterIndex;
	 
    @FXML
    private ImageView characterImageView;
    @FXML
    private ImageView chosenCharacterImageView;
    @FXML
    private Label usernameLabel;
    @FXML
    private BorderPane anotherBorderPane; 

    @FXML
	private ProgressBar eBar;
	@FXML
	private ProgressBar hBar;
	@FXML
	private ProgressBar fBar;
  
    
    public void setChosenCharacterIndex(int index) {
        chosenCharacterIndex = index;
    }

    public int getChosenCharacterIndex() {
        return chosenCharacterIndex;
    }
    
    private void applyHoverEffect(Button button) {
        Scale scale = new Scale(1.0, 1.0);
        button.getTransforms().add(scale);
        button.getStyleClass().add("underline-button");

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            scale.setX(1.05);
            scale.setY(1.05);
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            scale.setX(1.0);
            scale.setY(1.0);
        });
    }
    @FXML
    public void initialize() {
        // Get the index of the chosen character
        chosenCharacterIndex = ChosenCharacterInfo.getChosenCharacterIndex();

        // Define image URLs for different character types
        String[] characterImageUrls = {
            "/images/raccoon.png",
            "/images/cat.png",
            "/images/dog.png",
            "/images/fox.png",
            "/images/bear.png",
            "/images/rabbit.png"
        };

        // Load the character image based on the chosen index and set it to the characterImageView
        Image characterImage = new Image(getClass().getResourceAsStream(characterImageUrls[chosenCharacterIndex]));
        characterImageView.setImage(characterImage);

        // Load the chosen character image and set it to the chosenCharacterImageView
        Image chosenCharacterImage = new Image(getClass().getResourceAsStream(characterImageUrls[chosenCharacterIndex]));
        chosenCharacterImageView.setImage(chosenCharacterImage);

        // Set the username label
        String username = "magytooo";
        usernameLabel.setText(username);

        // Get an instance of ProgressController
        progressController = ProgressController.getInstance();

        // Set progress bars based on their values from ProgressController
        hBar.setProgress(progressController.getHBarProgress());
        eBar.setProgress(progressController.getEBarProgress());
        fBar.setProgress(progressController.getFBarProgress());
    }

       
    private void moveCharacterImage(ImageView imageView, double toX, double toY) {
        // Create a TranslateTransition to move the imageView to the specified coordinates
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), imageView);
        transition.setToX(toX);
        transition.setToY(toY);
        transition.play(); // Start the transition

        // Apply a hover effect to the exitButton
        applyHoverEffect(exitButton);
    }

    @FXML
    private void handleEducationButtonAction(ActionEvent event) {
        // Calculate the target X-coordinate for the characterImageView based on the educationButton position
        double targetX = educationButton.getLayoutX() - characterImageView.getFitWidth();
        
        // Move the characterImageView to the targetX position with the current Y-coordinate
        moveCharacterImage(characterImageView, targetX, characterImageView.getTranslateY());
        
        // Create a PauseTransition to delay the scene transition
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            try {
                // Load the "education.fxml" file and change the scene to it
                Parent root = FXMLLoader.load(getClass().getResource("education.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); // Display the new scene
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        pause.play(); // Start the pause before transitioning to the next scene
    }

    
    @FXML
    private void handleHealthButtonAction(ActionEvent event) {
        // Calculate the target X-coordinate for the characterImageView based on the healthButton position
        double targetX = healthButton.getLayoutX() + characterImageView.getFitWidth();
        
        // Move the characterImageView to the targetX position with the current Y-coordinate
        moveCharacterImage(characterImageView, targetX, characterImageView.getTranslateY());
        
        // Create a PauseTransition to delay the scene transition
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            try {
                // Load the "health.fxml" file and change the scene to it
                Parent root = FXMLLoader.load(getClass().getResource("health.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); // Display the new scene
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        pause.play(); // Start the pause before transitioning to the next scene
    }

    @FXML
    private void handleFinanceButtonAction(ActionEvent event) {
        // Calculate the target Y-coordinate for the characterImageView based on the financeButton position
        double targetY = financeButton.getLayoutY() + characterImageView.getFitHeight();
        
        // Move the characterImageView to the current X-coordinate and the targetY position
        moveCharacterImage(characterImageView, characterImageView.getTranslateX(), targetY);
        
        // Create a PauseTransition to delay the scene transition
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            try {
                // Load the "finance.fxml" file and change the scene to it
                Parent root = FXMLLoader.load(getClass().getResource("finance.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); // Display the new scene
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        pause.play(); // Start the pause before transitioning to the next scene
    }

    @FXML
    public void exitButtonAction(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Main.fxml"); // Change the scene back to "Main.fxml"
    }
}
