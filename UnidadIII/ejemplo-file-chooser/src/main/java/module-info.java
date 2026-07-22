module com.unah {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.unah to javafx.fxml;
    exports com.unah;
}
