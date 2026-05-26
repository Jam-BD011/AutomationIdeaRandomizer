package com.AtmIdeaRndo.model;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for main screen
 */
public class MainScreenController {
	
	//strings for car idea, engine type, and transmission type
	private String carBuild;
	private String carEng;
	private String carTrans;
	
	public static ObservableList<String> generatedCars = FXCollections.observableArrayList();
	
	//button and text field for generating idea
	@FXML private Button generateCar;
	@FXML private TextField baseCarInfo;
	
	//checkboxes for generating engine and transmission option
	@FXML private CheckBox engCheckBox;
	@FXML private CheckBox transCheckBox;
	
	/**
	 * generate random car build ideas
	 * @param event
	 */
	@FXML
	public void generateIdea(ActionEvent event) {
		
		//generate a base build
		carBuild = IdeaRandomizer.genRandomBuild();
		baseCarInfo.setText(carBuild);
		
		//if the user wants a random engine, append to the end of the build
		if(engCheckBox.isSelected()) {
			carEng = IdeaRandomizer.genEngine();
			carBuild = carBuild.concat(", " + carEng);			
			baseCarInfo.appendText(" with a " + carEng);
		}
		
		//if the user wants a random transmission, append to the end again
		if(transCheckBox.isSelected()) {
			carTrans = IdeaRandomizer.genTrans();
			carBuild = carBuild.concat(", " + carTrans);
			baseCarInfo.appendText(" and a " + carTrans);
		}
		
		//add the build to the observable list
		generatedCars.add(carBuild);
	}
	
	/**
	 * go to the currently generated ideas screen
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void goToIdea(ActionEvent event) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AIRIdeaScreen.fxml"));
		
		Parent root = loader.load();
		IdeasScreenController ideaController = loader.getController();
		ideaController.setIdeas(generatedCars);
		
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
