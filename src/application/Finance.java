/**

 * File: Finance.java

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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Scale;

public class Finance {
	 private List<String> fnoteEntries = new ArrayList<>();
	 private List<String> fgoalEntries = new ArrayList<>();
	 private List<String> ftoDoEntries = new ArrayList<>();
	
	 private ProgressController progressController;
	
	 double progress;
	 
	@FXML
	private Label usernameLabel;
	
	private int chosenCharacterIndex;
	 
	@FXML
	private ImageView chosenCharacterImageView;
	@FXML
	private Button fExitButton; 
	@FXML
	private Button fGoalButton; 
	@FXML
	private Button fToDoButton; 
	@FXML
	private Button fNoteButton; 
	@FXML
	private Pane fgoalPane;
	@FXML
	private Pane ftoDoPane;
	@FXML
	private Pane fnotePane;	 
	@FXML
	private ProgressBar eBar;
	@FXML
	private ProgressBar hBar;
	@FXML
	private ProgressBar fBar;
		
	private void loadNoteEntriesFromFile(String filename) {
	       try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/fnoteEntries.txt"))) {
	           String line;
	           while ((line = bufferedReader.readLine()) != null) {
	               fnoteEntries.add(line);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	   
	
	private void loadGoalEntriesFromFile(String filename) {
	       try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/fgoalEntries.txt"))) {
	           String line;
	           while ((line = bufferedReader.readLine()) != null) {
	              fgoalEntries.add(line);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	  
	   
	private void loadToDoEntriesFromFile(String filename) {
		   try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/textFiles/ftoDoEntries.txt"))) {
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                ftoDoEntries.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
	   
	
	private void saveNoteEntriesToFile(String filename) {
	       try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/fnoteEntries.txt"))) {
	           for (String entry : fnoteEntries) {
	               printWriter.println(entry);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	   
	
	private void saveGoalEntriesToFile(String filename) {
	      try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/fgoalEntries.txt"))) {
	           for (String entry : fgoalEntries) {
	               printWriter.println(entry);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	  
	
	private void saveToDoEntriesToFile(String filename) {
		   try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/textFiles/ftoDoEntries.txt"))) {
	            for (String entry : ftoDoEntries) {
	                printWriter.println(entry);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
		   
		
	
	private void displayGoalEntries() {
			   fgoalPane.getChildren().clear();
		        double yOffset = 10.0; // Initial Y-offset for the first goal entry
		        for (String goal : fgoalEntries) {
		            TextFlow goalEntry = createGoalEntryField(goal);
		            goalEntry.setLayoutY(yOffset);
		            fgoalPane.getChildren().add(goalEntry);
		            yOffset += 30.0; // Update Y-offset for the next goal entry
		        }
		   }
		   
		
	
	private void displayToDoEntries() {
			   ftoDoPane.getChildren().clear();
		        double yOffset = 10.0; // Initial Y-offset for the first todo entry
		        for (String toDo : ftoDoEntries) {
		            TextFlow toDoEntry = createToDoEntryField(toDo);
		            toDoEntry.setLayoutY(yOffset);
		            ftoDoPane.getChildren().add(toDoEntry);
		            yOffset += 30.0;
		        }
		     }


		       
	private void displayNoteEntries() {
			   fnotePane.getChildren().clear();
		        double yOffset = 10.0; 
		        for (String note : fnoteEntries) {
		            TextFlow noteEntry = createNoteEntryField(note);
		            noteEntry.setLayoutY(yOffset);
		            fnotePane.getChildren().add(noteEntry);
		            yOffset += 30.0; 
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
		               saveNoteEntriesToFile("/textFiles/fnoteEntries.txt");
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
		               saveGoalEntriesToFile("/textFiles/fgoalEntries.txt");
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
		                saveToDoEntriesToFile("/textFiles/ftoDoEntries.txt");
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
			        loadGoalEntriesFromFile("/textFiles/fgoalEntries.txt");
			        displayGoalEntries();
			        // Load to-do entries
			        loadToDoEntriesFromFile("/textFiles/ftoDoEntries.txt");
			        displayToDoEntries();
			    	 loadNoteEntriesFromFile("/textFiles/fnoteEntries.txt");
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
			       
			        applyHoverEffect(fExitButton);
			        applyHoverEffect(fToDoButton);
			        applyHoverEffect(fNoteButton);
			        applyHoverEffect(fGoalButton);
			       
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
			    
			   
			    private void createToDoEntry() {
			        TextField newToDoTextField = new TextField();
			        newToDoTextField.setPrefWidth(250);
			        newToDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
					
					 double updatedProgress = progressController.getFBarProgress() + 0.05;
					 progressController.updateFBarProgress(updatedProgress);
					 fBar.setProgress(updatedProgress);
					 
			        
			        double lastToDoY = 10.0; 
			        if (!ftoDoEntries.isEmpty()) {
			            lastToDoY = ftoDoPane.getChildren().isEmpty() ? 10.0 : ftoDoPane.getChildren().get(ftoDoPane.getChildren().size() - 1).getLayoutY();
			            lastToDoY += 30.0; 
			        }

			        newToDoTextField.setLayoutX(5);
			        newToDoTextField.setLayoutY(lastToDoY);
			        newToDoTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-font-size: 16px;");
			        newToDoTextField.setOnKeyPressed(event -> {
			            if (event.getCode() == KeyCode.ENTER) {
			                String newToDo = "* " + newToDoTextField.getText();
			                ftoDoEntries.add(newToDo);
			                newToDoTextField.setEditable(false);
			                saveToDoEntriesToFile("/textFiles/ftoDoEntries.txt");
			                displayToDoEntries(); 
			                event.consume();
			            }
			        });

			        ftoDoPane.getChildren().add(newToDoTextField);

			       
			        Platform.runLater(() -> {
			            newToDoTextField.requestFocus();
			        });
			    }


			    
			    private void createNoteEntry() {
			        TextField newNoteTextField = new TextField();
			        newNoteTextField.setPrefWidth(250);
			        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial';");
			       
					double updatedProgress = progressController.getFBarProgress() + 0.02;
					 progressController.updateFBarProgress(updatedProgress);
					 fBar.setProgress(updatedProgress);
					
			        
			        double lastNoteY = 10.0; 
			        
			        if (!fnoteEntries.isEmpty()) {
			            lastNoteY = fnotePane.getChildren().isEmpty() ? 10.0 : fnotePane.getChildren().get(fnotePane.getChildren().size() - 1).getLayoutY();
			            lastNoteY += 30.0; 
			        }
			        newNoteTextField.setLayoutX(5);
			        newNoteTextField.setLayoutY(lastNoteY);
			        newNoteTextField.setPrefWidth(250);
			        newNoteTextField.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-font-size: 16px;"); // Set transparent background and remove borders
			       
			    
			        newNoteTextField.setOnKeyPressed(event -> {
			            if (event.getCode() == KeyCode.ENTER) {
			                String newNote = newNoteTextField.getText();
			                fnoteEntries.add(newNote);
			                newNoteTextField.setEditable(false);
			                saveNoteEntriesToFile("/textFiles/fnoteEntries.txt");
			                displayNoteEntries(); 
			                event.consume();
			            }
			        });
			        fnotePane.getChildren().add(newNoteTextField);
			        
			        Platform.runLater(() -> {
			        	newNoteTextField.requestFocus();
			        });
			    }
				  
			    
			    private void createGoalEntry() {
			       
			        TextField goalText = new TextField();
			        goalText.setPrefWidth(250);
			        goalText.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-focus-color: transparent; -fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-padding: 5px;"); // Set transparent background and remove border
			       
			       
					
					 double updatedProgress = progressController.getFBarProgress() + 0.1;
					 progressController.updateFBarProgress(updatedProgress);
					 fBar.setProgress(updatedProgress);
					 
			        
			        double lastNoteY = 10.0;
		 if (!fgoalEntries.isEmpty()) {
			            lastNoteY = fgoalPane.getChildren().isEmpty() ? 10.0 : fgoalPane.getChildren().get(fgoalPane.getChildren().size() - 1).getLayoutY();
			            lastNoteY += 30.0;
			        }
			        goalText.setLayoutX(5);
			        goalText.setLayoutY(lastNoteY);
			        
			    
			        goalText.setOnKeyPressed(event -> {
			            if (event.getCode() == KeyCode.ENTER) {
			                String newNote = "\u2022 " +goalText.getText();
			                fgoalEntries.add(newNote);
			                goalText.setEditable(false);
			                saveGoalEntriesToFile("/textFiles/fgoalEntries.txt");
			                displayGoalEntries(); 
			                event.consume();
			            }
			        });
			        fgoalPane.getChildren().add(goalText);
			       
			        Platform.runLater(() -> {
			        	goalText .requestFocus();
			        });
			    }
			    
			    
			    
			    @FXML
			public void fExitButtonAction(ActionEvent event) throws IOException {
				progressController.updateFBarProgress(fBar.getProgress());
				Main m = new Main();
			    m.changeScene("map1.fxml");
			}
		}