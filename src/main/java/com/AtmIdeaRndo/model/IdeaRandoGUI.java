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

		//more fxml testing
		Parent newTest = FXMLLoader.load(getClass().getResource("/AirMainScreen.fxml"));
		Scene newTestScene = new Scene(newTest);
		appStage.setScene(newTestScene);
		appStage.show();
			
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
