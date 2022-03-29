module com.tripenyazaraz.noita {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tripenyazaraz.noita to javafx.fxml;
    exports com.tripenyazaraz.noita;
}