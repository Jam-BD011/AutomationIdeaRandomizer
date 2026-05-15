package com.AtmIdeaRndo.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {

	@FXML 
	public void exitProgram(ActionEvent event) {
		Platform.exit();
	}
	
}
