module com.example.guichetautomatique {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guichetautomatique to javafx.fxml;
    exports com.example.guichetautomatique;
}