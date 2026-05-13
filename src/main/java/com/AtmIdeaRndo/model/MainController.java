package com.AtmIdeaRndo.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

//controller for fxml-related events
public class MainController {

	@FXML 
	public void exitProgram(ActionEvent event) {
		Platform.exit();
	}
	
}
