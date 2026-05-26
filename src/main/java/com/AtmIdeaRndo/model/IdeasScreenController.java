package com.AtmIdeaRndo.model;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;

/**
 * Controller class for all ideas screen
 */
public class IdeasScreenController {

	@FXML private ListView<String> ideasList;
	@FXML private Label exportConfirmationLabel;
	@FXML private Button openExportFile;
	private File lastExportedFile;
	
	/**
	 * populate listview with items from passed observablelist
	 * @param currIdeaList ObervableList of Strings
	 */
	public void setIdeas(ObservableList<String> currIdeaList) {
		ideasList.setItems(currIdeaList);
	}
	
	/**
	 * remove an idea from the list
	 * @param event
	 */
	@FXML
	public void removeIdea(ActionEvent event) {
		
		//get the currently selected item from the listview (if any is selected)
		//and remove it from the list
		String selection = ideasList.getSelectionModel().getSelectedItem();
		if(selection != null) {
			ideasList.getItems().remove(selection);
		}
	}
	
	/**
	 * export current ideas list to a text file
	 * @param event
	 */
	@FXML
	public void exportIdeasToTextFile(ActionEvent event) {
		
		//format date and time, get  current date and time, and format the current time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();		
		String date = now.format(formatter);

		//write to file try-catch
		try {
			//file name is the formatted date, set to text file
			FileOutputStream fStream = new FileOutputStream(date + ".txt");
			PrintWriter outFS = new PrintWriter(fStream);
			
			//write current ideas as strings into file
			for(String idea : ideasList.getItems()) {
				outFS.println(idea);
			}
			//close streams and confirm export
			//enable button to open last exported list
			outFS.close();
			fStream.close();
			lastExportedFile = new File(date + ".txt");
			exportConfirmationLabel.setText("Ideas exported to " + lastExportedFile.getName() + "!");
			openExportFile.setDisable(false);
			
		}
		catch(IOException excpt) {
			Alert alert = new Alert(AlertType.ERROR, "Caught IO Error:" + excpt.getLocalizedMessage());
			alert.showAndWait();
		}
	}
	
	/**
	 * open last exported file
	 * @param event
	 */
	@FXML
	public void openExportFile(ActionEvent event) {
		System.out.println("beep boop");
		
		//try-catch for opening last written file
		try {
			if(lastExportedFile!= null && lastExportedFile.exists()) {
				Desktop.getDesktop().open(lastExportedFile);
			}
			else {
				Alert alert = new Alert(AlertType.WARNING, "No file exists!");
				alert.showAndWait();
			}
		}
		catch(IOException excpt) {
			Alert alert = new Alert(AlertType.ERROR, "Caught File error: " + excpt.getLocalizedMessage());
			alert.showAndWait();
		}
	}
	
	/**
	 * return to home screen
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void goHome(ActionEvent event) throws Exception{

		Parent root = FXMLLoader.load(getClass().getResource("/AIRMainScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

	/**
	 * exit program
	 * @param event
	 */
	@FXML 
	public void exitProgram(ActionEvent event) {
		Platform.exit();
	}
}
