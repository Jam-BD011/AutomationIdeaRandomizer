package com.AtmIdeaRndo.model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Controller class for main screen
 */
public class MainScreenController {
	
	//strings for car idea, engine type, and transmission type
	private String carBuild;
	private String carEng;
	private String carTrans;
	private Integer yrMin;
	private Integer yrMax;
	
	//observable list for generated ideas
	public static ObservableList<String> generatedCars = FXCollections.observableArrayList();
	
	//button and text field for generating idea
	@FXML private Button generateCar;
	@FXML private TextField baseCarInfo;
	
	//textfields for min and max years
	@FXML private TextField yrMinTextField;
	@FXML private TextField yrMaxTextField;
	
	//year spinners
	@FXML Spinner<Integer> minSpinner;
	@FXML Spinner<Integer> maxSpinner;
	
	//checkboxes for generating engine and transmission option
	@FXML private CheckBox engCheckBox;
	@FXML private CheckBox transCheckBox;
	
	/**
	 * function for initialization
	 */
	@FXML
	public void initialize() {
		minSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1940, 2025, 1940));
		maxSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1940, 2025, 2014));
	}
	
	/**
	 * generate random car build ideas
	 * @param event
	 */
	@FXML
	public void generateIdea(ActionEvent event) {
		
		//get spinner values
		yrMin = minSpinner.getValue();
		yrMax = maxSpinner.getValue();
		
		//input validation
		if(yrMin > yrMax || yrMax < yrMin) {
			Alert alert = new Alert(AlertType.WARNING, "Minumum year cannot be greater than maximum year!");
			alert.showAndWait();
		}
		else {
			carBuild = IdeaRandomizer.genRandomBuild(yrMin, yrMax);
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
	 * open lists folder
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void openFolder(ActionEvent event) throws Exception{
		try {
			File folder = new File("Lists");
			Desktop.getDesktop().open(folder);
			
		}
		catch(IOException excpt) {
			Alert alert = new Alert(AlertType.ERROR, "Caught error: " + excpt.getLocalizedMessage());
			alert.showAndWait();
		}
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
