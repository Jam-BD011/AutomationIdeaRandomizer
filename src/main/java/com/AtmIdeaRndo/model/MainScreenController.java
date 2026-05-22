package com.AtmIdeaRndo.model;

import java.util.Vector;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MainScreenController {
	
	//strings for car idea, engine type, and transmission type
	private String carBuild;
	private String carEng;
	private String carTrans;
	
	//vector for storing generated ideas
	public Vector<String> generatedCars = new Vector<String>();
	
	//button and text field for generating idea
	@FXML private Button generateCar;
	@FXML private TextField baseCarInfo;
	
	//checkboxes for generating engine and transmission option
	@FXML private CheckBox engCheckBox;
	@FXML private CheckBox transCheckBox;
	
	//generate car button handler
	@FXML
	public void generateIdea(ActionEvent event) {
		
		carBuild = IdeaRandomizer.genRandomBuild();
		baseCarInfo.setText(carBuild);
		
		if(engCheckBox.isSelected()) {
			carEng = IdeaRandomizer.genEngine();
			carBuild = carBuild.concat(", " + carEng);			
			baseCarInfo.appendText(" with a " + carEng);
		}
		
		if(transCheckBox.isSelected()) {
			carTrans = IdeaRandomizer.genTrans();
			carBuild = carBuild.concat(", " + carTrans);
			baseCarInfo.appendText(" and a " + carTrans);
		}
		
		//add ideas to vector
		generatedCars.add(carBuild);
	
	}
	
	//topbar exit button handler
	@FXML 
	public void exitProgram(ActionEvent event) {
		Platform.exit();
	}
	
}
