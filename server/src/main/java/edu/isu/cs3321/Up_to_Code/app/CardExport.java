package edu.isu.cs3321.Up_to_Code.app;

/**
 * This file will contain the backend for the exporting cards function of the project
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardExport extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
        FXMLLoader loader=new FXMLLoader(CardExport.class.getResource("/CardExportDocument.fxml"));
        Parent root= loader.load();
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}