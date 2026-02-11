module org.example.w3_labwork_csc311 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.w3_labwork_csc311 to javafx.fxml;
    exports org.example.w3_labwork_csc311;
}