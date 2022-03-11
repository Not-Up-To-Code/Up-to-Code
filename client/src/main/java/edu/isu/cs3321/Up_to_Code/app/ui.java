package edu.isu.cs3321.Up_to_Code.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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

    List<String> borderColors = Arrays.asList("OrangeRed", "ForestGreen", "DodgerBlue");
    List<String> cardColors = Arrays.asList("Khaki", "PaleGreen", "PowderBlue");

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
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(home_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Kernel Tools");
        mainStage.setScene(scene);
    }
    public void showPracticeCatalog() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(practiceCatalog_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Practice Catalog");
        mainStage.setScene(scene);
    }
    public void showPracticeCreator() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(practiceCreator_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Practice Creator");
        mainStage.setScene(scene);
    }
    public void showCardCatalog() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(cardCatalog_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Card Catalog");
        mainStage.setScene(scene);
    }
    public void showCardCreator() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(cardCreator_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);

        ChoiceBox borderColor = (ChoiceBox) scene.lookup("#borderColorChoice");
        ChoiceBox cardColor = (ChoiceBox) scene.lookup("#cardColorChoice");

        for(String color : borderColors){
            borderColor.getItems().add(color);
        }
        for(String color :cardColors){
            cardColor.getItems().add(color);
        }

        borderColor.setValue(borderColors.get(0));
        cardColor.setValue(cardColors.get(0));

        SVGPath border = (SVGPath) scene.lookup("#wideCardBorder");
        SVGPath banner = (SVGPath) scene.lookup("#wideCardBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#wideCardAlphaSymbol");

        border.setFill(Paint.valueOf((String) borderColor.getValue()));
        banner.setFill(Paint.valueOf((String) cardColor.getValue()));
        symbol.setFill(Paint.valueOf((String) borderColor.getValue()));

        mainStage.setTitle("Essence Card Creator");
        mainStage.setScene(scene);
    }

    public void updateCardColors(){
        Scene scene = mainStage.getScene();

        ChoiceBox borderColor = (ChoiceBox) scene.lookup("#borderColorChoice");
        ChoiceBox cardColor = (ChoiceBox) scene.lookup("#cardColorChoice");

        SVGPath border = (SVGPath) scene.lookup("#wideCardBorder");
        SVGPath banner = (SVGPath) scene.lookup("#wideCardBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#wideCardAlphaSymbol");

        border.setFill(Paint.valueOf((String) borderColor.getValue()));
        banner.setFill(Paint.valueOf((String) cardColor.getValue()));
        symbol.setFill(Paint.valueOf((String) borderColor.getValue()));
    }

    public void showProgressPoker() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(progressPoker_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Progress Poker");
        mainStage.setScene(scene);
    }
    public void showChaseTheState() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(chaseTheState_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Chase the State");
        mainStage.setScene(scene);
    }
    public void showObjectiveGo() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(objectiveGo_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Objective Go");
        mainStage.setScene(scene);
    }
    public void showCheckpointConstruction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(checkpointConstruction_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Checkpoint Construction");
        mainStage.setScene(scene);
    }

    //SVG for wide card
    // M 13.353516,0.125 C 6.0474485,0.125 0.125,6.0474484 0.125,13.353516 V 432.07031 c 0,7.30607 5.9224482,13.22852 13.228516,13.22852 H 639.24219 c 7.30607,0 13.22851,-5.92245 13.22851,-13.22852 V 13.353516 C 652.4707,6.0474494 646.54826,0.125 639.24219,0.125 Z m 0,2.6445313 H 639.24219 c 5.88605,0 10.58398,4.6979389 10.58398,10.5839847 V 432.07031 c 0,5.88605 -4.69793,10.58399 -10.58398,10.58399 H 13.353516 c -5.8860443,0 -10.5839847,-4.69795 -10.5839847,-10.58399 V 13.353516 c 0,-5.8860448 4.6979401,-10.5839847 10.5839847,-10.5839847 z
    //SVG for small card
    //m 18.197511,-0.85351563 c -10.5315547,0 -19.05102662,8.51652803 -19.05102663,19.04625363 V 426.24804 c 10e-9,10.52973 8.51947193,19.04625 19.05102663,19.04625 H 307.18036 c 10.53155,0 19.05103,-8.51652 19.05103,-19.04625 V 18.192738 c 0,-10.5297263 -8.51948,-19.04625363 -19.05103,-19.04625363 z m 0,2.56763903 H 307.18036 c 9.15317,0 16.48294,7.3270255 16.48294,16.4786146 V 426.24804 c 0,9.15159 -7.32977,16.47861 -16.48294,16.47861 H 18.197511 c -9.1531796,0 -16.4829417,-7.32702 -16.4829417,-16.47861 V 18.192738 c 0,-9.1515898 7.3297621,-16.4786146 16.4829417,-16.4786146 z

}
