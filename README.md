# Automation Idea Randomizer
An idea randomizer for the automotive tycoon game Automation. Generates car build ideas for users to create!

## How to Use (Windows Desktop)
1.) On the "Releases" page, download AIRv0.15.zip\
2.) Extract zip contents anywhere\
3.) Run "AIRv0.15.exe"

### (Alternate) Running with Maven
The project is also possible to run using Maven and a JavaSDK.
Ensure the following is installed:

-JDK 25.0.2 [Download JDK 25 Here](https://www.oracle.com/java/technologies/downloads/#jdk25-windows)\
-Apache Maven 3.13 [Download Maven Here](https://maven.apache.org/download.cgi)

1.) Ensure the JDK is installed by runnning: ```java -version```\
2.) Ensure Apache Maven is installed by runnning: ```mvn -version```\
3.) Clone the repo\
4.) Run the following command in the root folder: ```mvn clean javafx:run```

# What's planned:
This project is ongoing, and I have further improvements I would like to make:
- [ ] "Previous ideas" section for viewing recently generated ideas
- [ ] Reading car years, body types, engines, transmissions, and functions from text files for easier end-user editing
- [ ] Exporting generated ideas to a text file
- [ ] Reduce package download size
- [ ] Create custom icons
- [ ] Make the UI fancier

## Update Log
#### 20th May 2026
- Switched to FXML for scenes
    + The current (and so far only) scene, as well as future scenes will utilize FXML for cleaner class reading, better speration of files and functions
- Implemented controller class for new FXML screen

## License Info
Project utilizes MIT License. See "LICENSE.txt" for more info.
