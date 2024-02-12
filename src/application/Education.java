/**

 * File: Education.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Scale;

public class Education {
	 private List<String> enoteEntries = new ArrayList<>();
	 private List<String> egoalEntries = new ArrayList<>();
	 private List<String> etoDoEntries = new ArrayList<>();
	private ProgressController progressController;
	double progress;
	 @FXML
	    private Label usernameLabel;
	@FXML
	private Button eExitButton;
	@FXML
	private Button eGoalButton;
	@FXML
	private Button eToDoButton;
	@FXML
	private Button eNoteButton;

	private int chosenCharacterIndex;
	@FXML
	private ImageView chosenCharacterImageView;

	@FXML
	private Pane egoalPane;

	@FXML
	private Pane etoDoPane;

	@FXML
	private Pane enotePane;
	
	@FXML
	private ProgressBar eBar;
	@FXML
	private ProgressBar hBar;
	@FXML
	private ProgressBar fBar;
	
	private void loadNoteEntriesFromFile(String filename) {
	       try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/enoteEntries.txt"))) {
	           String line;
	           while ((line = bufferedReader.readLine()) != null) {
	               enoteEntries.add(line);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	   private void loadGoalEntriesFromFile(String filename) {
	       try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/egoalEntries.txt"))) {
	           String line;
	           while ((line = bufferedReader.readLine()) != null) {
	              egoalEntries.add(line);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }


	   }
	   private void loadToDoEntriesFromFile(String filename) {
		   try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/etoDoEntries.txt"))) {
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                etoDoEntries.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	   }
	   private void saveNoteEntriesToFile(String filename) {
	       try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/enoteEntries.txt"))) {
	           for (String entry : enoteEntries) {
	               printWriter.println(entry);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	   private void saveGoalEntriesToFile(String filename) {
	      try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/egoalEntries.txt"))) {
	           for (String entry : egoalEntries) {
	               printWriter.println(entry);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }


	   }
	   private void saveToDoEntriesToFile(String filename) {
		   try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/etoDoEntries.txt"))) {
	            for (String entry : etoDoEntries) {
	                printWriter.println(entry);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	   }
	   private void displayGoalEntries() {
		   egoalPane.getChildren().clear();
	        double yOffset = 10.0; // Initial Y-offset for the first goal entry
	        for (String goal : egoalEntries) {
	            TextFlow goalEntry = createGoalEntryField(goal);
	            goalEntry.setLayoutY(yOffset);
	            egoalPane.getChildren().add(goalEntry);
	            yOffset += 30.0; // Update Y-offset for the next goal entry
	        }


	   }
	   private void displayToDoEntries() {
		   etoDoPane.getChildren().clear();
	        double yOffset = 10.0; // Initial Y-offset for the first todo entry
	        for (String toDo : etoDoEntries) {
	            TextFlow toDoEntry = createToDoEntryField(toDo);
	            toDoEntry.setLayoutY(yOffset);
	            etoDoPane.getChildren().add(toDoEntry);
	            yOffset += 30.0; // Update Y-offset for the next todo entry
	        }
	       }


	       
	   private void displayNoteEntries() {
		   enotePane.getChildren().clear();
	        double yOffset = 10.0; // Initial Y-offset for the first note entry
	        for (String note : enoteEntries) {
	            TextFlow noteEntry = createNoteEntryField(note);
	            noteEntry.setLayoutY(yOffset);
	            enotePane.getChildren().add(noteEntry);
	            yOffset += 30.0; // Update Y-offset for the next note entry
	        }
	   }
	   private TextFlow createNoteEntryField(String text) {
	       TextField noteTextField = new TextField(text);
	       noteTextField.setPrefWidth(250);
	       noteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
	       TextFlow noteEntry = new TextFlow(noteTextField);
	       noteTextField.setEditable(false);
	       noteTextField.setOnKeyPressed(event -> {
	           if (event.getCode() == KeyCode.ENTER) {
	               saveNoteEntriesToFile("/textFiles/enoteEntries.txt");
	               event.consume();
	           }
	       });
	       return noteEntry;
	   }


	private TextFlow createGoalEntryField(String text) {
	       TextField goalTextField = new TextField(text);
	       goalTextField .setPrefWidth(250);
	       goalTextField .setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
	       TextFlow goalEntry = new TextFlow(goalTextField);
	       goalTextField .setEditable(false);
	       goalTextField .setOnKeyPressed(event -> {
	           if (event.getCode() == KeyCode.ENTER) {
	               saveGoalEntriesToFile("/textFiles/egoalEntries.txt");
	               event.consume();
	           }
	       });
	       return goalEntry;
	   }




	private TextFlow createToDoEntryField(String text) {
		 TextField toDoTextField = new TextField(text);
	        toDoTextField.setPrefWidth(250);
	        toDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
	        TextFlow toDoEntry = new TextFlow(toDoTextField);
	        toDoTextField.setEditable(false);
	        toDoTextField.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ENTER) {
	                saveToDoEntriesToFile("/textFiles/etoDoEntries.txt");
	                event.consume();
	            }
	        });
	        return toDoEntry;
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
		    	 // Load goal entries
		        loadGoalEntriesFromFile("/textFiles/egoalEntries.txt");
		        displayGoalEntries();
		        // Load to-do entries
		        loadToDoEntriesFromFile("/textFiles/etoDoEntries.txt");
		        displayToDoEntries();
		    	 loadNoteEntriesFromFile("/textFiles/enoteEntries.txt");
		         displayNoteEntries();
		        if (chosenCharacterImageView != null) {
		            chosenCharacterIndex = ChosenCharacterInfo.getChosenCharacterIndex();
		            String[] characterImageUrls = { "/images/raccoon.png",
		            		"/images/cat.png",
		            		"/images/dog.png",
		            		"/images/fox.png",
		            		"/images/bear.png",
		            		"/images/rabbit.png" };
		            Image chosenCharacterImage = new Image(getClass().getResourceAsStream(characterImageUrls[chosenCharacterIndex]));
		            chosenCharacterImageView.setImage(chosenCharacterImage);
		        } else {
		            System.err.println("chosenCharacterImageView is null. Check FXML file and controller.");
		        }
		       
		        
		        
		        progressController = ProgressController.getInstance();
		        hBar.setProgress(progressController.getHBarProgress());
		        eBar.setProgress(progressController.getEBarProgress());
		        fBar.setProgress(progressController.getFBarProgress());
		       
		        applyHoverEffect(eExitButton);
		        applyHoverEffect(eToDoButton);
		        applyHoverEffect(eNoteButton);
		        applyHoverEffect(eGoalButton);
		       
		        String username = "magytooo";
		        usernameLabel.setText(username);
		    }
		    @FXML
		    private void goalButtonAction() {
		        createGoalEntry();
		       
		    }
		    @FXML
		    private void toDoButtonAction() {
		        createToDoEntry();
		        
		    }
		    @FXML
		    private void noteButtonAction() {
		        createNoteEntry();
		        
		    }
		   
		  
			
			/*
			 * private void createToDoEntry() { TextField newToDoTextField = new
			 * TextField(); newToDoTextField.setPrefWidth(250); newToDoTextField.
			 * setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';"
			 * );
			 * 
			 * double updatedProgress = progressController.getEBarProgress() + 0.05;
			 * progressController.updateEBarProgress(updatedProgress);
			 * eBar.setProgress(updatedProgress);
			 * 
			 * 
			 * double lastToDoY = 10.0; if (!etoDoEntries.isEmpty()) { lastToDoY =
			 * etoDoPane.getChildren().isEmpty() ? 10.0 :
			 * etoDoPane.getChildren().get(etoDoPane.getChildren().size() - 1).getLayoutY();
			 * lastToDoY += 30.0; }
			 * 
			 * newToDoTextField.setLayoutX(5); newToDoTextField.setLayoutY(lastToDoY);
			 * newToDoTextField.
			 * setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-font-size: 16px;"
			 * ); newToDoTextField.setOnKeyPressed(event -> { if (event.getCode() ==
			 * KeyCode.ENTER) { String newToDo = newToDoTextField.getText();
			 * etoDoEntries.add(newToDo); newToDoTextField.setEditable(false);
			 * saveToDoEntriesToFile("/textFiles/etoDoEntries.txt"); displayToDoEntries();
			 * event.consume(); } });
			 * 
			 * etoDoPane.getChildren().add(newToDoTextField);
			 * 
			 * 
			 * Platform.runLater(() -> { newToDoTextField.requestFocus(); }); }
			 */

		    private void createToDoEntry() {
		        TextField newToDoTextField = new TextField();
		        newToDoTextField.setPrefWidth(250);
		        newToDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");

		        double updatedProgress = progressController.getEBarProgress() + 0.05;
		        progressController.updateEBarProgress(updatedProgress);
		        eBar.setProgress(updatedProgress);

		        double lastToDoY = 10.0;
		        if (!etoDoEntries.isEmpty()) {
		            lastToDoY = etoDoPane.getChildren().isEmpty() ? 10.0 : etoDoPane.getChildren().get(etoDoPane.getChildren().size() - 1).getLayoutY();
		            lastToDoY += 30.0; // Add height of the last to-do entry
		        }

		        newToDoTextField.setLayoutX(20); // Adjust X coordinate as needed
		        newToDoTextField.setLayoutY(lastToDoY);

		        newToDoTextField.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newToDo = "* " + newToDoTextField.getText(); // Prepend asterisk (*) to the to-do text
		                etoDoEntries.add(newToDo);
		                saveToDoEntriesToFile("/textFiles/etoDoEntries.txt");
		                displayToDoEntries();
		                newToDoTextField.setEditable(false);
		                event.consume();
		            }
		        });

		        etoDoPane.getChildren().add(newToDoTextField);

		        Platform.runLater(() -> {
		            newToDoTextField.requestFocus();
		        });
		    }



		   
		    private void createNoteEntry() {
		        TextField newNoteTextField = new TextField();
		        newNoteTextField.setPrefWidth(250);
		        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
		       
		        double updatedProgress = progressController.getEBarProgress() + 0.02;
		        progressController.updateEBarProgress(updatedProgress);
		        eBar.setProgress(updatedProgress);
				
		        
		        double lastNoteY = 10.0; 
		        
		        if (!enoteEntries.isEmpty()) {
		            lastNoteY = enotePane.getChildren().isEmpty() ? 10.0 : enotePane.getChildren().get(enotePane.getChildren().size() - 1).getLayoutY();
		            lastNoteY += 30.0; 
		        }
		        newNoteTextField.setLayoutX(5);
		        newNoteTextField.setLayoutY(lastNoteY);
		        newNoteTextField.setPrefWidth(250);
		        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-font-size: 16px;"); // Set transparent background and remove borders
		     
		    
		        newNoteTextField.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newNote = newNoteTextField.getText();
		                enoteEntries.add(newNote);
		                newNoteTextField.setEditable(false);
		                saveNoteEntriesToFile("/textFiles/enoteEntries.txt");
		                displayNoteEntries(); 
		                event.consume();
		            }
		        });
		        enotePane.getChildren().add(newNoteTextField);
		        
		        Platform.runLater(() -> {
		        	newNoteTextField.requestFocus();
		        });
		    }
			
		    private void createGoalEntry() {
		        TextField goalText = new TextField();
		        goalText.setPrefWidth(250);
		        goalText.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-focus-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-padding: 5px;");

		        double updatedProgress = progressController.getEBarProgress() + 0.1;
		        progressController.updateEBarProgress(updatedProgress);
		        eBar.setProgress(updatedProgress);

		        double lastNoteY = 10.0;
		        if (!egoalEntries.isEmpty()) {
		            lastNoteY = egoalPane.getChildren().isEmpty() ? 10.0 : egoalPane.getChildren().get(egoalPane.getChildren().size() - 1).getLayoutY();
		            lastNoteY += 30.0; // Add height of the last note
		        }

		        goalText.setLayoutX(20); // Adjust X coordinate as needed
		        goalText.setLayoutY(lastNoteY);

		        goalText.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newGoal = "\u2022 " + goalText.getText(); // Prepend the bullet point to the goal text
		                egoalEntries.add(newGoal);
		                saveGoalEntriesToFile("/textFiles/egoalEntries.txt");
		                displayGoalEntries();
		                goalText.setEditable(false);
		                event.consume();
		            }
		        });

		        egoalPane.getChildren().add(goalText);

		        Platform.runLater(() -> {
		            goalText.requestFocus();
		        });
		    }

			 



	@FXML
	public void eExitButtonAction(ActionEvent event) throws IOException {
		 progressController.updateEBarProgress(eBar.getProgress());
		Main m = new Main();
		m.changeScene("map1.fxml");
	}
}
