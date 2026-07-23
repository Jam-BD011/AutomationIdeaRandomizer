package com.AtmIdeaRndo.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;

public class ListFunctions {
	
	private static Integer min = null;
	private static Integer max = null;
	
	static ArrayList<String> functionsList = new ArrayList<String>();
	static ArrayList<String> bodiesList = new ArrayList<String>();
	static ArrayList<String> enginesList = new ArrayList<String>();
	static ArrayList<String> transList = new ArrayList<String>();
	
	//set or re-set vehicle function lists
	public static void setFunctList() throws FileNotFoundException {
		
		try {
			File file = new File("Lists/functions.txt");
			Scanner scnr = new Scanner(file);
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				functionsList.add(line);
			}
			scnr.close();
		}
		finally {
			System.out.println("Set functions successfully");
		}
	}
	
	//set or re-set vehicle function lists
	public static void setBodiesList() throws FileNotFoundException{
		try {
			File file = new File("Lists/bodies.txt");
			Scanner scnr = new Scanner(file);
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				bodiesList.add(line);
			}
			scnr.close();
		}
		finally {
			System.out.println("Set bodies successfully");
		}
	}
		
	//set or re-set vehicle function lists
	public static void setEnginesList() throws FileNotFoundException{
		try {
			File file = new File("Lists/engines.txt");
			Scanner scnr = new Scanner(file);
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				enginesList.add(line);
			}			
			scnr.close();
		}
		finally {
			System.out.println("Set engines successfully");
		}
	}
	
	//set or re-set vehicle function lists
	public static void setTransList() throws FileNotFoundException{
		try {
			File file = new File("Lists/transmissions.txt");
			Scanner scnr = new Scanner(file);
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				transList.add(line);
			}			
			scnr.close();
		}
		finally {
			System.out.println("Set transmissions successfully");
		}
	}

	//return list of car functions
	public static ArrayList<String> getFunctions(){
		return functionsList;
	}
	
	//return list of body styles
	public static ArrayList<String> getBodies(){
		return bodiesList;
	}
	
	//return list of engines
	public static ArrayList<String> getEngines(){
		return enginesList;
	}
	
	//return list of transmissions
	public static ArrayList<String> getTrans(){
		return transList;
	}
	
}
