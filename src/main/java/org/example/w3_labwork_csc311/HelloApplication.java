package org.example.w3_labwork_csc311;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");*/
        GridPane gridpane = new GridPane();

        Label label1 = new Label("Annual Interest Rate");
        GridPane.setConstraints(label1,0,0);

        TextField air = new TextField();
        GridPane.setConstraints(air,1,0);

        Label label2 = new Label("Number of Years");
        GridPane.setConstraints(label2,0,1);

        TextField yrs = new TextField();
        GridPane.setConstraints(yrs,1,1);

        Label label3 = new Label("Loan Amount");
        GridPane.setConstraints(label3,0,2);

        TextField loan = new TextField();
        GridPane.setConstraints(loan,1,2);

        Button button = new Button("Click!");
        GridPane.setConstraints(button,1,4);

        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(5));

        gridpane.getChildren().addAll(air,label1,label2,yrs,loan,label3,button);

        Scene scene = new Scene(gridpane,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}