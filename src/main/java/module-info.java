module com.example.pokedesdecero {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.pokedesdecero to javafx.fxml;
    exports com.example.pokedesdecero;
}