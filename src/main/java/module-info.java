module com.tsarbuck.tsarbucks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.tsarbuck.tsarbucks to javafx.fxml;
    exports com.tsarbuck.tsarbucks;
    exports com.tsarbuck.tsarbucks.controllers;
    opens com.tsarbuck.tsarbucks.controllers to javafx.fxml;
}