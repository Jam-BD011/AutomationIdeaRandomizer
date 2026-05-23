package com.AtmIdeaRndo.model;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controller class for all ideas screen
 */
public class IdeasScreenController {

	@FXML private ListView<String> ideasList;
	
	public void setIdeas(ObservableList<String> currIdeaList) {
		ideasList.setItems(currIdeaList);
	}
	
	@FXML
	public void removeIdea(ActionEvent event) {
		//remove button debug
		System.out.println("remove idea");
	}
	
	//export current ideas to text file
	@FXML
	public void exportIdeasToTextFile(ActionEvent event) {
		//export button debug
		System.out.println("export to file");
	}
	
	//return to home screen
	@FXML
	public void goHome(ActionEvent event) throws Exception{
		//home button debug
		System.out.println("goes home");
		
		Parent root = FXMLLoader.load(getClass().getResource("/AirMainScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

	//topbar exit button handler
	@FXML 
	public void exitProgram(ActionEvent event) {
		Platform.exit();
	}
}
