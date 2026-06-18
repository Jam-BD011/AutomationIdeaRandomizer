package com.AtmIdeaRndo.model;

/**
 * Class for generating random builds, with random engines and transmissions
 */
public class IdeaRandomizer {
	
	/**
	 * Method for generating a random build
	 * @return String of the car year, function, and body type
	 */
	public static String genRandomBuild() {
		
		String carFunct = "";
		String bodyType = "";
		int carYear = 0;
		
		carYear = 1940 + (int)(Math.random() * 74);
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