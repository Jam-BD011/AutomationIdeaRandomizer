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
		
		String[] carFunction = {"Demolition Derby", "Stockcar", "Moonshiner", "Police", "Undercover", "Drag Racing", "Offroad", "Endurance Racing", "Drifting", "Hypermiler", 
								"Baja", "Street", "Getaway", "Rally", "Touge", "Ponycar", "GT2/3/4", "Taxi", "Time Attack", "Hillclimb", "Police Interceptor",
								"Postal", "Construction", "Rock Crawling", "Mud Bogging", "Overland", "Luxury", "Grand Touring", "Concept", "Sleeper",
								"Lemons", "Gambler 500", "XTREME Stance", "Japanese", "Muscle", "European", "Work", "Autocross", "Mafia", "Tuner", "Lowrider",
								"Slab", "DTM", "Super-Touring", "High-speed", "Highway Racer", "Group B", "Group 5", "Sema", "Secret Agent"};
		String[] carType = {"Sedan", "Wagon", "Hatchback", "Coupe", "SUV", "Pickup", "MPV", "Van"};
		
		String carFunct = "";
		String bodyType = "";
		int carYear = 0;
		
		carYear = 1940 + (int)(Math.random() * 74);
		carFunct = carFunction[(int)(Math.random() * carFunction.length)];
		bodyType = carType[(int)(Math.random() * carType.length)];
		
		return carYear + " " + carFunct + " " + bodyType;	
	}
	
	/**
	 * Method for generating random engine
	 * @return String of engine type
	 */
	public static String genEngine() {
		
		String[] engines = {"Inline 3", "Inline 4", "Inline 5", "Inline 6", "60 Deg. V6", "60 Deg. V8", "60 Deg. V12", "90 Deg. V6", "90 Deg. V8", "90 Deg. V10",
				"Boxer 4", "Boxer 6"};
		String randEng = "";
		
		randEng = engines[(int)(Math.random() * engines.length)];
		
		return randEng;
	}
	
	/**
	 * Method for generating random transmission
	 * @return	String of transmission type
	 */
	public static String genTrans() {
		
		String[] transmissions = {"2-Spd Manual", "3-Spd Manual", "4-Spd Manual", "5-Spd Manual", "6-Spd Manual", "6-Spd Manual", "3-Spd Auto", "4-Spd Auto", "5-Spd Auto",
				"6-Spd Auto", "7-Spd Auto", "8-Spd Auto", "9-Spd Auto", "3-Spd Auto", "3-Spd Adv. Auto", "4-Spd Adv. Auto", "5-Spd Adv. Auto",
				"6-Spd Adv. Auto", "7-Spd Adv. Auto", "8-Spd Adv. Auto", "9-Spd Adv. Auto", "2-Spd Auto Manual", "3-Spd Auto Manual", "4-Spd Auto Manual",
				"5-Spd Auto Manual", "6-Spd Auto Manual", "7-Spd Auto Manual", "2-Spd Dual Clutch", "3-Spd Dual Clutch", "4-Spd Dual Clutch",
				"5-Spd Dual Clutch", "6-Spd Dual Clutch", "7-Spd Dual Clutch", "2-Spd Sequential", "3-Spd Sequential", "4-Spd Sequential", "5-Spd Sequential",
				"6-Spd Sequential", "7-Spd Sequential", "Continous"};
		String randTrans = "";
		
		randTrans = transmissions[(int)(Math.random() * transmissions.length)];
		
		return randTrans; 
	}

}