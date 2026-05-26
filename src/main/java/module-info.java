module AutomationIdeaRandomizer {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
	requires java.desktop;

    exports com.AtmIdeaRndo.model;
    opens com.AtmIdeaRndo.model to javafx.fxml;
}