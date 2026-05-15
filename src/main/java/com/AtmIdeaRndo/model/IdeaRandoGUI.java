package com.AtmIdeaRndo.model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;



/*
 * IMPLEMENT BORDER PANE FOR TOP MENU
 * assign menu to top and
 * then assign the stack pane to the center
 */

/**
 * GUI Driver Class
 */
public class IdeaRandoGUI extends Application{

	//initialize UI layout containers
	Scene scene = null;
	StackPane sceneStack = null;
	
	BorderPane sceneBorder = null;
	
	GridPane sceneGrid = null;
	HBox topHBox = null;
	HBox bottomHBox = null;
	HBox checkHBox  = null;
	
	//initialize buttons, text fields, and check-boxes
	Button generateCar = null;
	Button exitBtn = null;
	Label infoLabel = null;
	Label engCheckLabel = null;
	Label transCheckLabel = null;
	TextField baseCarInfo = null;
	CheckBox engCheckBox = null;
	CheckBox transCheckBox = null;
	
	ToolBar topToolBar = null;
	
	//strings for car info
	String carBuild = null;
	String carEng = null;
	String carTrans = null;
	
	@Override
	public void start(Stage appStage) throws Exception {

		//create layout containers
		sceneGrid = new GridPane();
		sceneBorder = new BorderPane();
		sceneStack = new StackPane();
		topHBox = new HBox();
		bottomHBox = new HBox();
		checkHBox = new HBox();
		engCheckBox = new CheckBox();
		transCheckBox = new CheckBox();
		topToolBar = new ToolBar();
		
		//create and name labels
		infoLabel = new Label("Click the button to generate a build idea!");
		engCheckLabel = new Label("Choose a random engine?");
		transCheckLabel = new Label("Choose a random transmission?");
		
		//create text field, not editable to the user
		baseCarInfo = new TextField();
		baseCarInfo.setEditable(false);
		baseCarInfo.setPrefColumnCount(40);
		
		//create and name button
		generateCar = new Button("Generate Car");
		exitBtn = new Button("Exit");
		
		//event handler for when "generate car" button is pressed
		generateCar.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				//call method from build randomizer class and set result to string
				//then update text field to string
				carBuild = IdeaRandomizer.genRandomBuild();
				baseCarInfo.setText(carBuild);
				
				//if "random engine" checkbox is selected, call method
				//from build randomizer class and append the engine to the current build
				if(engCheckBox.isSelected()) {
					carEng = IdeaRandomizer.genEngine();
					baseCarInfo.appendText(" with a " + carEng);
				}
				
				//if "random trans" checkbox is selected, call method
				//from build randomizer class and append the trans to the current build
				if(transCheckBox.isSelected()) {
					carTrans = IdeaRandomizer.genTrans();
					baseCarInfo.appendText(" and a " + carTrans);
				}
			}	
		});
		
		exitBtn.setOnAction(event -> {
			Platform.exit();
		});
		
		//add info label to the top h-box and position in center
		topHBox.getChildren().addAll(infoLabel);
		topHBox.setSpacing(4.0);
		topHBox.setAlignment(Pos.CENTER);
		
		//add generate car button and text field to the bottom h-box and position in center
		bottomHBox.getChildren().addAll(generateCar, baseCarInfo);
		bottomHBox.setSpacing(4.0);
		bottomHBox.setAlignment(Pos.CENTER);
		
		//add check-box labels and checkboxes to checkbox specific h-box and position in center
		checkHBox.getChildren().addAll(engCheckLabel, engCheckBox, transCheckLabel, transCheckBox);
		checkHBox.setSpacing(6.0);
		checkHBox.setAlignment(Pos.CENTER);
		
		//place the top box , then bottom box, then checkboxes, set gap, then align to center
		sceneGrid.add(topHBox, 0, 0); 		//(column 0, row 0)
		sceneGrid.add(bottomHBox, 0, 1);	//(column 0, row 1)
		sceneGrid.add(checkHBox, 0, 2);		//(column 0, row 2)
		sceneGrid.setVgap(15.0);
		sceneGrid.setAlignment(Pos.CENTER);
		
		topToolBar.getItems().addAll(exitBtn);
		
		sceneBorder.setTop(topToolBar);
		sceneBorder.setCenter(sceneGrid);
		
		sceneStack.getChildren().addAll(sceneBorder);
		scene = new Scene(sceneStack, 600, 200);
		
		//more fxml testing
		Parent newTest = FXMLLoader.load(getClass().getResource("/AirMainScreen.fxml"));
		Scene newTestScene = new Scene(newTest);
		appStage.setScene(newTestScene);
		appStage.show();
		
		//set scene, set title, and then show
		/**
		appStage.setScene(scene);
		appStage.setTitle("Automation Build Randomizer");
		appStage.show();
		**/
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
