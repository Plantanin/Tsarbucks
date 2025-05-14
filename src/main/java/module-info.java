module com.tsarbuck.tsarbucks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.tsarbuck.tsarbucks to javafx.fxml;
    exports com.tsarbuck.tsarbucks;
}