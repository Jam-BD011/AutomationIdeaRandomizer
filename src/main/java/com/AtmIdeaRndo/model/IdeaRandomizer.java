package com.AtmIdeaRndo.model;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Class for generating random builds, with random engines and transmissions
 */
public class IdeaRandomizer {
	
	/**
	 * Method for generating a random build
	 * @param yrMax maximum year retrieved from maxSpinner
	 * @param yrMin minimum year retrieved from minSpinner
	 * @return String of the car year, function, and body type
	 */
	public static String genRandomBuild(Integer yrMin, Integer yrMax) {

		String carFunct = "";
		String bodyType = "";
		int carYear = 0;
		
		carYear = (int) (yrMin + (Math.random() * (yrMax - yrMin + 1)));
		
		//carYear = 1940 + (int)(Math.random() * 74);
		//carYear = ListFunctions.getYearMin() + (int)(Math.random() * ListFunctions.getYearMax());
		//carYear = (int) (min + (Math.random() * max));
		carFunct = ListFunctions.getFunctions().get((int)(Math.random() * ListFunctions.getFunctions().size()));
		bodyType = ListFunctions.getBodies().get((int)(Math.random() * ListFunctions.getBodies().size()));
		
		return carYear + " " + carFunct + " " + bodyType;	
	}
	
	/**
	 * Method for generating random engine
	 * @return String of engine type
	 */
	public static String genEngine() {
		
		String randEng = "";
		
		randEng = ListFunctions.getEngines().get((int)(Math.random() * ListFunctions.getEngines().size()));
		
		return randEng;
	}
	
	/**
	 * Method for generating random transmission
	 * @return	String of transmission type
	 */
	public static String genTrans() {

		String randTrans = "";
		
		randTrans = ListFunctions.getTrans().get((int)(Math.random() * ListFunctions.getTrans().size()));
		
		return randTrans; 
	}

}