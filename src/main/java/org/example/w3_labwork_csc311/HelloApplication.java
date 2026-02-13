package org.example.w3_labwork_csc311;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
    private TextField air, yrs, loan, monPay, total;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 380, 300);
        stage.setTitle("Loan Calculator");
        GridPane gridpane = new GridPane();

        Label label1 = new Label("Annual Interest Rate");
        GridPane.setConstraints(label1,0,0);

        air = new TextField();
        GridPane.setConstraints(air,1,0);

        Label label2 = new Label("Number of Years");
        GridPane.setConstraints(label2,0,1);

        yrs = new TextField();
        GridPane.setConstraints(yrs,1,1);

        Label label3 = new Label("Loan Amount");
        GridPane.setConstraints(label3,0,2);

        loan = new TextField();
        GridPane.setConstraints(loan,1,2);

        Label label4 = new Label("Monthly Payment");
        GridPane.setConstraints(label4,0,3);

        monPay = new TextField();
        GridPane.setConstraints(monPay,1,3);

        Label label5 = new Label("Total Payment");
        GridPane.setConstraints(label5,0,4);

        total = new TextField();
        GridPane.setConstraints(total,1,4);
        total.setEditable(false);

        Button button = new Button("Calculate!");
        button.setOnAction(this::processButtonPress);
        GridPane.setConstraints(button,1,5);

        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(5));

        gridpane.getChildren().addAll(air,label1,label2,yrs,loan,label3,button,label4,monPay,label5,total);

        Scene scene = new Scene(gridpane,330,230);
        stage.setScene(scene);
        stage.show();
    }

    public void processButtonPress(ActionEvent event){
        double annualInterest = Double.parseDouble(air.getText());
        int years = Integer.parseInt(yrs.getText());
        double P = Double.parseDouble(loan.getText());

        double annualRate = annualInterest / 100.0;
        double r = annualRate / 12.0;
        int n = years * 12;

        double M;

        if (r == 0) {
            M = P / n;
        } else {
            M = P * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        }

        double totalPayment = M * n;

        monPay.setText(String.format("%.2f", M));
        total.setText(String.format("%.2f", totalPayment));
    }

    public static void main(String[] args) {
        launch();
    }
}