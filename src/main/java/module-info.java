module com.example.magicsquare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.magicsquare to javafx.fxml;
    exports com.example.magicsquare;
}