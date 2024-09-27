/**

 * File: Health.java

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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Scale;

public class Health {
	
	  // Define private lists to store entries
	 private List<String> noteEntries = new ArrayList<>();
	 private List<String> goalEntries = new ArrayList<>();
	 private List<String> toDoEntries = new ArrayList<>();
	
	private ProgressController progressController;
	private int chosenCharacterIndex;
	@FXML
	private Label usernameLabel;
	@FXML
	private ImageView chosenCharacterImageView;
	@FXML
	private Button hExitButton; 
	@FXML
	private Button hGoalButton; 
	@FXML
	private Button hToDoButton; 
	@FXML
	private Button hNoteButton; 
	@FXML
	private Pane goalPane;
	@FXML
	private Pane toDoPane;
	@FXML
	private Pane notePane;
	
	@FXML
	private ProgressBar eBar;
	@FXML
	private ProgressBar hBar;
	@FXML
	private ProgressBar fBar;
	
	double progress;
	
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
	
    
    // methods are responsible for reading data from external files
	private void loadNoteEntriesFromFile(String filename) {
	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/noteEntries.txt"))) {
	        String line;
	        // Read each line from the file until the end is reached
	        while ((line = bufferedReader.readLine()) != null) {
	            // Add each line (note entry) to the 'noteEntries' list
	            noteEntries.add(line);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file reading, print the stack trace
	        e.printStackTrace();//list of method calls
	        					//that have been invoked up to the point where an error or exception occurred
	    }
	}
	
	
	private void loadGoalEntriesFromFile(String filename) {
	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/goalEntries.txt"))) {
	        String line;
	        // Read each line from the file until the end is reached
	        while ((line = bufferedReader.readLine()) != null) {
	            // Add each line (goal entry) to the 'goalEntries' list
	            goalEntries.add(line);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file reading, print the stack trace
	        e.printStackTrace();
	    }
	}
	   
	
	private void loadToDoEntriesFromFile(String filename) {
	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/toDoEntries.txt"))) {
	        String line;
	        // Read each line from the file until the end is reached
	        while ((line = bufferedReader.readLine()) != null) {
	            // Add each line (to-do entry) to the 'toDoEntries' list
	            toDoEntries.add(line);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file reading, print the stack trace
	        e.printStackTrace();
	    }
	}
	   
	// methods handle the task of writing data from the lists back into the corresponding files
	private void saveNoteEntriesToFile(String filename) {
	    try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/noteEntries.txt"))) {
	        // Iterate through each note entry in the 'noteEntries' list
	        for (String entry : noteEntries) {
	            // Write each entry to the file
	            printWriter.println(entry);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file writing, print the stack trace
	        e.printStackTrace();
	    }
	}
	// Saving goal entries to file
	private void saveGoalEntriesToFile(String filename) {
	    try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/goalEntries.txt"))) {
	        // Iterate through each goal entry in the 'goalEntries' list
	        for (String entry : goalEntries) {
	            // Write each entry to the file
	            printWriter.println(entry);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file writing, print the stack trace
	        e.printStackTrace();
	    }
	}
	   
	// Saving to-do entries to file
	private void saveToDoEntriesToFile(String filename) {
	    try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/toDoEntries.txt"))) {
	        // Iterate through each to-do entry in the 'toDoEntries' list
	        for (String entry : toDoEntries) {
	            // Write each entry to the file
	            printWriter.println(entry);
	        }
	    } catch (IOException e) {
	        // If an exception occurs during file writing, print the stack trace
	        e.printStackTrace();
	    }
	}
	   
	// These methods create and display UI elements based on the contents of the lists. 
	//They clear the existing UI elements and regenerate them according to the data in the lists
	private void displayGoalEntries() {
	    // Clear existing children of the goalPane
	    goalPane.getChildren().clear();

	    double yOffset = 10.0; // Initial Y-offset for the first goal entry

	    // Iterate through each goal entry in the 'goalEntries' list
	    for (String goal : goalEntries) {
	        // Create a TextFlow entry for the current goal entry
	        TextFlow goalEntry = createGoalEntryField(goal);

	        // Set the layout Y-coordinate of the goalEntry in the goalPane
	        goalEntry.setLayoutY(yOffset);

	        // Add the goalEntry to the goalPane
	        goalPane.getChildren().add(goalEntry);

	        yOffset += 30.0; // Update Y-offset for the next goal entry
	    }
	}
	
	private void displayToDoEntries() {
	    // Clear existing children of the toDoPane
	    toDoPane.getChildren().clear();

	    double yOffset = 10.0; // Initial Y-offset for the first to do entry

	    // Iterate through each todo entry in the 'toDoEntries' list
	    for (String toDo : toDoEntries) {
	        // Create a TextFlow entry for the current todo entry
	        TextFlow toDoEntry = createToDoEntryField(toDo);

	        // Set the layout Y-coordinate of the toDoEntry in the toDoPane
	        toDoEntry.setLayoutY(yOffset);

	        // Add the toDoEntry to the toDoPane
	        toDoPane.getChildren().add(toDoEntry);

	        yOffset += 30.0; // Update Y-offset for the next todo entry
	    }
	}

	private void displayNoteEntries() {
	    // Clear existing children of the notePane
	    notePane.getChildren().clear();

	    double yOffset = 10.0; // Initial Y-offset for the first note entry

	    // Iterate through each note entry in the 'noteEntries' list
	    for (String note : noteEntries) {
	        // Create a TextFlow entry for the current note entry
	        TextFlow noteEntry = createNoteEntryField(note);

	        // Set the layout Y-coordinate of the noteEntry in the notePane
	        noteEntry.setLayoutY(yOffset);

	        // Add the noteEntry to the notePane
	        notePane.getChildren().add(noteEntry);

	        yOffset += 30.0; // Update Y-offset for the next note entry
	    }
	}
	
	
	// Method to create a UI field for a to-do entry
	private TextFlow createNoteEntryField(String text) {
	    // Create a TextField with the provided text
	    TextField noteTextField = new TextField(text);

	    // Set the preferred width and style for the TextField
	    noteTextField.setPrefWidth(250);
	    noteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");

	    // Wrap the TextField in a TextFlow element
	    TextFlow noteEntry = new TextFlow(noteTextField);

	    // Make the TextField non-editable
	    noteTextField.setEditable(false);

	    // Listen for the Enter key press to save the note entry
	    noteTextField.setOnKeyPressed(event -> {
	        if (event.getCode() == KeyCode.ENTER) {
	            saveNoteEntriesToFile("/textFiles/noteEntries.txt"); // Save the note entry to file
	            event.consume(); // Consume the event to prevent further handling
	        }
	    });

	    return noteEntry; // Return the TextFlow representing the note entry
	}

	// Method to create a UI field for a to-do entry
	private TextFlow createGoalEntryField(String text) {
	    // Create a TextField with the provided text
	    TextField goalTextField = new TextField(text);

	    // Set the preferred width and style for the TextField
	    goalTextField.setPrefWidth(250);
	    goalTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");

	    // Wrap the TextField in a TextFlow element
	    TextFlow goalEntry = new TextFlow(goalTextField);

	    // Make the TextField non-editable
	    goalTextField.setEditable(false);

	    // Listen for the Enter key press to save the goal entry
	    goalTextField.setOnKeyPressed(event -> {
	        if (event.getCode() == KeyCode.ENTER) {
	            saveGoalEntriesToFile("/textFiles/goalEntries.txt"); // Save the goal entry to file
	            event.consume(); // Consume the event to prevent further handling
	        }
	    });

	    return goalEntry; // Return the TextFlow representing the goal entry
	}



	// Method to create a UI field for a to-do entry
	private TextFlow createToDoEntryField(String text) {
	    // Create a TextField with the provided text
	    TextField toDoTextField = new TextField(text);

	    // Set the preferred width and style for the TextField
	    toDoTextField.setPrefWidth(250);
	    toDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");

	    // Wrap the TextField in a TextFlow element
	    TextFlow toDoEntry = new TextFlow(toDoTextField);

	    // Make the TextField non-editable
	    toDoTextField.setEditable(false);

	    // Listen for the Enter key press to save the to-do entry
	    toDoTextField.setOnKeyPressed(event -> {
	        if (event.getCode() == KeyCode.ENTER) {
	            saveToDoEntriesToFile("/textFiles/toDoEntries.txt"); // Save the to-do entry to file
	            event.consume(); // Consume the event to prevent further handling
	        }
	    });

	    return toDoEntry; // Return the TextFlow representing the to-do entry
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
			
		    /**
		     * Initialize the controller after its root element has been completely processed.
		     * This method sets up initial values, loads data from files, displays entries, and applies UI effects.
		     */
		    @FXML
		    private void initialize() {
		        // Load goal entries from file and display them
		        loadGoalEntriesFromFile("/textFiles/sgoalEntries.txt");
		        displayGoalEntries();

		        // Load to-do entries from file and display them
		        loadToDoEntriesFromFile("/textFiles/toDoEntries.txt");
		        displayToDoEntries();

		        // Load note entries from file and display them
		        loadNoteEntriesFromFile("/textFiles/noteEntries.txt");
		        displayNoteEntries();

		        // Set chosen character image if available
		        if (chosenCharacterImageView != null) {
		            chosenCharacterIndex = ChosenCharacterInfo.getChosenCharacterIndex();
		            String[] characterImageUrls = {
		                "/images/raccoon.png",
		                "/images/cat.png",
		                "/images/dog.png",
		                "/images/fox.png",
		                "/images/bear.png",
		                "/images/rabbit.png"
		            };
		            Image chosenCharacterImage = new Image(getClass().getResourceAsStream(characterImageUrls[chosenCharacterIndex]));
		            chosenCharacterImageView.setImage(chosenCharacterImage);
		        } else {
		            System.err.println("chosenCharacterImageView is null. Check FXML file and controller.");
		        }

		        // Initialize progress controller and set progress bars
		        progressController = ProgressController.getInstance();
		        hBar.setProgress(progressController.getHBarProgress());
		        eBar.setProgress(progressController.getEBarProgress());
		        fBar.setProgress(progressController.getFBarProgress());

		        // Apply hover effect to buttons
		        applyHoverEffect(hExitButton);
		        applyHoverEffect(hToDoButton);
		        applyHoverEffect(hNoteButton);
		        applyHoverEffect(hGoalButton);

		        // Set username label
		        String username = "magytooo";
		        usernameLabel.setText(username);
		    }
		   
		 // Create a new to-do entry
		    private void createToDoEntry() {
		        // Create a new TextField for the to-do entry
		        TextField newToDoTextField = new TextField();
		        newToDoTextField.setPrefWidth(250);
		        newToDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
		        
		        // Update progress and set the progress bar
		        double updatedProgress = progressController.getHBarProgress() + 0.05;
		        progressController.updateHBarProgress(updatedProgress);
		        hBar.setProgress(updatedProgress);
		        
		        // Set the initial Y-offset for the new to-do entry
		        double lastToDoY = 10.0;
		        if (!toDoEntries.isEmpty()) {
		            lastToDoY = toDoPane.getChildren().isEmpty() ? 10.0 : toDoPane.getChildren().get(toDoPane.getChildren().size() - 1).getLayoutY();
		            lastToDoY += 30.0; // Add height of the last to-do entry
		        }

		        // Set layout coordinates and style for the new TextField
		        newToDoTextField.setLayoutX(5);
		        newToDoTextField.setLayoutY(lastToDoY);
		        newToDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px;");
		       
		        // Handle ENTER key press to save the to-do entry
		        newToDoTextField.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newToDo = "* " + newToDoTextField.getText();
		                toDoEntries.add(newToDo); // Add the new to-do entry
		                newToDoTextField.setEditable(false); // Make the TextField non-editable
		                saveToDoEntriesToFile("/textFiles/toDoEntries.txt"); // Save to-do entries to file
		                displayToDoEntries(); // Refresh displayed to-do entries
		                event.consume();
		            }
		        });

		        // Add the new TextField for the to-do entry to the UI pane
		        toDoPane.getChildren().add(newToDoTextField);

		        // Set focus on the TextField after a short delay using Platform.runLater
		        Platform.runLater(() -> {
		            newToDoTextField.requestFocus();
		        });
		    }



		 // Create a new note entry
		    private void createNoteEntry() {
		        // Create a new TextField for the note entry
		        TextField newNoteTextField = new TextField();
		        newNoteTextField.setPrefWidth(250);
		        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
		       
		        // Update progress and set the progress bar
		        double updatedProgress = progressController.getHBarProgress() + 0.02;
		        progressController.updateHBarProgress(updatedProgress);
		        hBar.setProgress(updatedProgress);
		        
		        // Set the initial Y-offset for the new note entry
		        double lastNoteY = 10.0;
		        
		        if (!noteEntries.isEmpty()) {
		            lastNoteY = notePane.getChildren().isEmpty() ? 10.0 : notePane.getChildren().get(notePane.getChildren().size() - 1).getLayoutY();
		            lastNoteY += 30.0; // Add height of the last note
		        }
		        
		        // Set layout coordinates and style for the new TextField
		        newNoteTextField.setLayoutX(5);
		        newNoteTextField.setLayoutY(lastNoteY);
		        newNoteTextField.setPrefWidth(250);
		        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-font-size: 16px;"); // Set transparent background and remove borders
		        
		        // Handle ENTER key press to save the note entry
		        newNoteTextField.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newNote = newNoteTextField.getText();
		                noteEntries.add(newNote); // Add the new note entry
		                newNoteTextField.setEditable(false); // Make the TextField non-editable
		                saveNoteEntriesToFile("/textFiles/noteEntries.txt"); // Save note entries to file
		                displayNoteEntries(); // Refresh displayed note entries
		                event.consume();
		            }
		        });
		        
		        // Add the new TextField for the note entry to the UI pane
		        notePane.getChildren().add(newNoteTextField);
		        
		        // Set focus on the TextField after a short delay using Platform.runLater
		        Platform.runLater(() -> {
		            newNoteTextField.requestFocus();
		        });
		    }

		    
		 // Create a new goal entry
		    private void createGoalEntry() {
		        // Create a new TextField for the goal entry
		        TextField goalText = new TextField();
		        goalText.setPrefWidth(250);
		        goalText.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-focus-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-padding: 5px;"); // Set transparent background and remove border
		        
		        // Update progress and set the progress bar
		        double updatedProgress = progressController.getHBarProgress() + 0.1;
		        progressController.updateHBarProgress(updatedProgress);
		        hBar.setProgress(updatedProgress);
		        
		        // Set the initial Y-offset for the new goal entry
		        double lastNoteY = 10.0;
		        if (!goalEntries.isEmpty()) {
		            lastNoteY = goalPane.getChildren().isEmpty() ? 10.0 : goalPane.getChildren().get(goalPane.getChildren().size() - 1).getLayoutY();
		            lastNoteY += 30.0; // Add height of the last goal entry
		        }
		        
		        // Set layout coordinates for the new TextField
		        goalText.setLayoutX(5);
		        goalText.setLayoutY(lastNoteY);
		        
		        // Handle ENTER key press to save the goal entry
		        goalText.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		                String newGoal = "\u2022 " + goalText.getText(); // Prepend the bullet point to the goal text
		                goalEntries.add(newGoal); // Add the new goal entry
		                goalText.setEditable(false); // Make the TextField non-editable
		                saveGoalEntriesToFile("/textFiles/goalEntries.txt"); // Save goal entries to file
		                displayGoalEntries(); // Refresh displayed goal entries
		                event.consume();
		            }
		        });
		        
		        // Add the new TextField for the goal entry to the UI pane
		        goalPane.getChildren().add(goalText);
		        
		        // Set focus on the TextField after a short delay using Platform.runLater
		        Platform.runLater(() -> {
		            goalText.requestFocus();
		        });
		    }


		
		    @FXML
		    public void hExitButtonAction(ActionEvent event) throws IOException {
		        // Update progress and set the progress bar
		        progressController.updateHBarProgress(hBar.getProgress());
		        
		        // Instantiate Main class and change the scene to map1.fxml
		        Main m = new Main();
		        m.changeScene("map1.fxml");
		    }
	}

