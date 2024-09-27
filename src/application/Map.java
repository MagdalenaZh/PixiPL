/**

 * File: Map.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Map {
	
private Stage stage;
private Scene scene;

    @FXML
    private BorderPane characterPane;
    @FXML
    private Stage primaryStage;
    @FXML
    private Button readyButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private ImageView characterImageView;

    private int currentImageIndex = 0;

    private String[] characterImageUrls = {
            "/images/raccoon.png",
            "/images/cat.png",
            "/images/dog.png",
            "/images/fox.png",
            "/images/bear.png",
            "/images/rabbit.png"
    };

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
    private void initialize() {
        // Set the initial character image
        updateCharacterImage();
        applyHoverEffect(readyButton);
        applyHoverEffect(rightButton);
        applyHoverEffect(leftButton);
        
    }

    @FXML
    private void handleLeftButtonAction(ActionEvent event) {
        // Handle left button action
        currentImageIndex = (currentImageIndex - 1 + characterImageUrls.length) % characterImageUrls.length;
        updateCharacterImage();
    }

    @FXML
    private void handleRightButtonAction(ActionEvent event) {
        // Handle right button action
        currentImageIndex = (currentImageIndex + 1) % characterImageUrls.length;
        updateCharacterImage();
    }

    @FXML
    private void handleReadyButtonAction(ActionEvent event) throws IOException {
        // Save the chosen character information
        ChosenCharacterInfo.setChosenCharacterIndex(currentImageIndex);

        Parent root = FXMLLoader.load(getClass().getResource("map1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void updateCharacterImage() {
        // Load and set the character image
        Image characterImage = new Image(getClass().getResourceAsStream(characterImageUrls[currentImageIndex]));
        characterImageView.setImage(characterImage);
    }

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Main.fxml");
    }

}
