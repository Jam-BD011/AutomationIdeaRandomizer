package com.AtmIdeaRndo.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * GUI Driver Class
 */
public class IdeaRandoGUI extends Application{
	
	@Override
	public void start(Stage appStage) throws Exception {
		
		//load screen from fxml
		Parent root = FXMLLoader.load(getClass().getResource("/AIRMainScreen.fxml"));
		Scene rootScene = new Scene(root);
		appStage.setTitle("Automation Idea Randomizer");
		appStage.setScene(rootScene);
		appStage.show();
			
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
