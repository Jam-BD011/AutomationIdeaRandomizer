# Automation Idea Randomizer
An idea randomizer for the automotive tycoon game Automation. Generates car build ideas for users to create in-game!

## How to Install and Run (Windows Desktop)
1.) On the "Releases" page, download AIRv0.2.zip\
2.) Extract zip contents anywhere\
3.) Run "AIRv0.2.exe"

### (Alternate) Installing and Running with Maven
The project is also possible to run using Maven and a JavaSDK.
Ensure the following is installed:

- JDK 25.0.2 [Download JDK 25 Here](https://www.oracle.com/java/technologies/downloads/#jdk25-windows)
- Apache Maven 3.13 [Download Maven Here](https://maven.apache.org/download.cgi)

1.) Ensure the JDK is installed by runnning: ```java -version```\
2.) Ensure Apache Maven is installed by runnning: ```mvn -version```\
3.) Clone the repo\
4.) Run the following command in the root folder: ```mvn clean javafx:run```

## Once You're Running...
- Click on the "Generate Idea" button to generate a random car build idea!
    + If you want to have a random engine selected for you, check the "Choose a random engine?" checkbox!
    + If you want to have a random transmission selected for you, check the "Choose a random transmission?" checkbox!
- Once you've generated some ideas, hit the "All Ideas" button at the top to go to the Ideas Screen
    + Here is where all your randomly generated ideas can be seen. Scroll down if you can't see them all!
    + If you want to remove an idea from the list, click on the item you want to remove and then click the "Remove Selected Item" button at the bottom to remove that idea
    + You can also export the current list of ideas! Click the "Export to Text File" button to export your current ideas list to a text file
        * Once you've exported the list, you can click the "Open Export File" button to instantly open the text file with the most recent list of ideas
        * The list can also be found in the root folder (where the .exe is located, or where the repository is located)
- Click on the "Exit" button on the top left, or the close window "X" in the top right at any time to exit


## What's planned:
This project is ongoing, and I have further improvements I would like to make:
- [x] "Previous ideas" section for viewing recently generated ideas
- [ ] Reading car years, body types, engines, transmissions, and functions from text files for easier end-user editing
- [x] Exporting generated ideas to a text file
- [ ] Reduce package download size
- [ ] Create custom icons
- [ ] Make the UI fancier
- [ ] Web-accessible version

## Update Log

#### 25th May 2026
- Implemented Ideas Page
    + A new page has been added, allowing you to see all the randomly generated ideas you've made so far! You can also remove ideas from the list now as well
    + The current ideas list can be exported as a text file, which is created in the root folder of the project/executable
        * This may change in the future, they may be moved to a seperate folder for a cleaner file structure
#### 20th May 2026
- Switched to FXML for scenes
    + The current (and so far only) scene, as well as future scenes will utilize FXML for cleaner class reading, better speration of files and functions
- Implemented controller class for new FXML screen

## License Info
Project utilizes MIT License. See ["LICENSE.txt"](LICENSE.txt) for more info.
