package edu.isu.cs3321.Up_to_Code.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ui extends Application {

    public static final String home_FXML = "/home.fxml";
    public static final String practiceCatalog_FXML = "/practiceCatalog.fxml";
    public static final String practiceCreator_FXML = "/practiceCreator.fxml";
    public static final String cardCatalog_FXML = "/cardCatalog.fxml";
    public static final String cardCreator_FXML = "/cardCreator.fxml";
    public static final String progressPoker_FXML = "/progressPoker.fxml";
    public static final String chaseTheState_FXML = "/chaseTheState.fxml";
    public static final String objectiveGo_FXML = "/objectiveGo.fxml";
    public static final String checkpointConstruction_FXML = "/checkpointConstruction.fxml";

    Stage mainStage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        primaryStage.setTitle("Essence Kernel Tools");

        showHome();

        primaryStage.show();
    }

    //fxml change handlers
    public void showHome() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController());
        loader.setLocation(getClass().getResource(home_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Kernel Tools");
        mainStage.setScene(scene);
    }
    public void showPracticeCatalog() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController());
        loader.setLocation(getClass().getResource(practiceCatalog_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Practice Catalog");
        mainStage.setScene(scene);
    }
    public void showPracticeCreator() throws IOException {

    }
    public void showCardCatalog() throws IOException {

    }
    public void showCardCreator() throws IOException {

    }
    public void showProgressPoker() throws IOException {

    }
    public void showChaseTheState() throws IOException {

    }
    public void showObjectiveGo() throws IOException {

    }
    public void showCheckpointConstruction() throws IOException {

    }

}
