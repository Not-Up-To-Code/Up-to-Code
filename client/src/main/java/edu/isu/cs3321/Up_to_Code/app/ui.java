//MIT License
//
//Copyright (c) 2022 Thomas Evans, Benjamin Keninger, Sina Khajeh Pour, Braxton Soto
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in all
//copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//SOFTWARE.
package edu.isu.cs3321.Up_to_Code.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ui extends Application {

    public static final String connection_FXML = "/connection.fxml";
    public static final String home_FXML = "/home.fxml";
    public static final String practiceCatalog_FXML = "/practiceCatalog.fxml";
    public static final String practiceCreator_FXML = "/practiceCreator.fxml";
    public static final String cardCatalog_FXML = "/cardCatalog.fxml";
    public static final String cardCreator_FXML = "/cardCreator.fxml";
    public static final String progressPoker_FXML = "/progressPoker.fxml";
    public static final String chaseTheState_FXML = "/chaseTheState.fxml";
    public static final String objectiveGo_FXML = "/objectiveGo.fxml";
    public static final String checkpointConstruction_FXML = "/checkpointConstruction.fxml";

    public static final List<String> borderColors = Arrays.asList("OrangeRed", "ForestGreen", "DodgerBlue");
    public static final List<String> cardColors = Arrays.asList("Khaki", "PaleGreen", "PowderBlue");

    public static final List<String> wideCardSVGs = Arrays.asList("#wideCardBack", "#wideCardState1", "#wideCardState2", "#wideCardState3", "#wideCardState4", "#wideCardState5", "#wideCardState6", "#wideCardBanner", "#wideCardBorder", "#cardSymbol");
    public static final List<String> wideCardTexts = Arrays.asList("#cardName", "#wideStateText1", "#wideStateText2", "#wideStateText3", "#wideStateText4", "#wideStateText5", "#wideStateText6", "#wideBriefDesc", "#wideDetailedDesc");


    public static final HashMap<String,String> cardSymbols = new HashMap<>(){{
        put("Alpha", "m 54.189453,14.023438 c -3.551127,-0.01733 -5.87912,0.05722 -8.908203,0.738281 -3.029104,0.681061 -6.854586,1.927454 -9.574219,4.394531 -2.719637,2.467081 -3.942639,5.851619 -4.658203,8.427734 -0.71556,2.576101 -0.945638,4.687766 -0.628906,8.576172 0.316731,3.888394 1.053524,9.813293 3.939453,13.732422 2.885894,3.919081 7.612935,5.113988 12.492187,5.730469 4.879242,0.616479 10.21018,0.683401 15.671875,0.527344 5.461693,-0.156057 11.715279,-0.655919 16.548829,-6.941407 1.947326,-2.532279 3.623602,-6.040319 5.203125,-9.904297 1.439404,3.884529 2.823201,7.64147 4.412109,11.871094 l 2.476562,-0.929687 c -1.95835,-5.21307 -3.756769,-10.055487 -5.429687,-14.607422 1.763436,-4.848647 3.401317,-10.166807 5.042969,-15.546875 l -2.529297,-0.773438 c -1.305941,4.279865 -2.660786,8.312388 -4.021485,12.275391 -1.80555,-5.009618 -3.153121,-9.031834 -5.888671,-11.861328 -2.817787,-2.914554 -6.81571,-4.20795 -11.236329,-4.900391 -4.42064,-0.692444 -9.360985,-0.791263 -12.912109,-0.808593 z m -0.01172,2.646484 c 3.511426,0.01714 8.355915,0.126077 12.513672,0.777344 4.157779,0.65127 7.532274,1.837173 9.744141,4.125 2.211923,2.287884 3.559593,6.080872 5.458984,11.330078 0.282987,0.782069 0.706237,1.888645 1.011719,2.722656 -1.85966,4.975319 -3.812146,9.214539 -5.931641,11.970703 -4.226856,5.496551 -9.134961,5.756136 -14.52539,5.910156 -5.390427,0.154021 -10.60192,0.08143 -15.265625,-0.507812 -4.663694,-0.589246 -8.480231,-1.668371 -10.69336,-4.673828 -2.213093,-3.00541 -3.130143,-8.653546 -3.433593,-12.378907 -0.30345,-3.725347 -0.119505,-5.267361 0.542968,-7.652343 0.662469,-2.384968 1.780992,-5.269325 3.884766,-7.177735 2.103779,-1.908413 5.583709,-3.143453 8.376953,-3.771484 2.793266,-0.628036 4.804985,-0.690965 8.316406,-0.673828 z");
        put("Competency", "m 60.077127,3.356555 -8.843143,17.725284 -19.61502,2.763922 14.125631,13.887857 -3.432832,19.508861 17.573086,-9.142122 17.493467,9.292695 -0.46309,-2.770965 L 74.113388,37.855484 88.357637,24.089493 68.766991,21.157125 Z m -0.02709,6.2655406 6.864581,14.0617184 15.475366,2.316539 -11.251759,10.874244 2.578686,15.433119 -13.818517,-7.34067 -13.881358,7.222052 2.711385,-15.41091 -11.158599,-10.970654 15.494864,-2.183299 z");
    }};

    Stage mainStage;
    uiController controller;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        primaryStage.setTitle("Essence Kernel Tools");

        showConnect();

        primaryStage.show();
    }

    //fxml change handlers
    public void showConnect() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new connectionController(this));
        loader.setLocation(getClass().getResource(connection_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        mainStage.setTitle("Essence Kernel Tools");
        mainStage.setScene(scene);
    }

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
        ChoiceBox cardType = (ChoiceBox) scene.lookup("#cardTypeChoice");

        for(String color : borderColors){
            borderColor.getItems().add(color);
        }
        for(String color :cardColors){
            cardColor.getItems().add(color);
        }
        for(String key : cardSymbols.keySet()){
            cardType.getItems().add(key);
        }

        borderColor.setValue(borderColors.get(0));
        cardColor.setValue(cardColors.get(0));
        cardType.setValue("Alpha");

        SVGPath border = (SVGPath) scene.lookup("#wideCardBorder");
        SVGPath banner = (SVGPath) scene.lookup("#wideCardBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#cardSymbol");

        border.setFill(Paint.valueOf((String) borderColor.getValue()));
        banner.setFill(Paint.valueOf((String) cardColor.getValue()));
        symbol.setFill(Paint.valueOf((String) borderColor.getValue()));

        mainStage.setTitle("Essence Card Creator");
        mainStage.setScene(scene);
    }

    public void showWideCard(){
        Scene scene = mainStage.getScene();

        for(String id : wideCardSVGs){
            System.out.println(id);
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(true);
        }

        for(String id : wideCardTexts){
            System.out.println(id);
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(true);
        }
    }

    public void hideWideCard(){
        Scene scene = mainStage.getScene();

        for(String id : wideCardSVGs){
            System.out.println(id);
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(false);
        }

        for(String id : wideCardTexts){
            System.out.println(id);
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(false);
        }
    }

    //pushes color changes to the card render
    public void updateCard(){
        Scene scene = mainStage.getScene();

        ChoiceBox borderColor = (ChoiceBox) scene.lookup("#borderColorChoice");
        ChoiceBox cardColor = (ChoiceBox) scene.lookup("#cardColorChoice");
        ChoiceBox cardType = (ChoiceBox) scene.lookup("#cardTypeChoice");

        SVGPath border = (SVGPath) scene.lookup("#wideCardBorder");
        SVGPath banner = (SVGPath) scene.lookup("#wideCardBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#cardSymbol");

        border.setFill(Paint.valueOf((String) borderColor.getValue()));
        banner.setFill(Paint.valueOf((String) cardColor.getValue()));

        symbol.setContent(cardSymbols.get(cardType.getValue()));
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

    public void showRequired() throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Connection invalid");
        alert.setContentText("The Url and port can not be empty.");

        alert.showAndWait();
    }

    public void showError() throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText("There was an Error when connecting to the server.");

        alert.showAndWait();
    }

    public void showFailedConnection() throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Connection Failed");
        alert.setContentText("Connection to the server has failed. Check that you've entered the Url and Port correctly.");

        alert.showAndWait();
    }

    //SVG for wide card
    // M 13.353516,0.125 C 6.0474485,0.125 0.125,6.0474484 0.125,13.353516 V 432.07031 c 0,7.30607 5.9224482,13.22852 13.228516,13.22852 H 639.24219 c 7.30607,0 13.22851,-5.92245 13.22851,-13.22852 V 13.353516 C 652.4707,6.0474494 646.54826,0.125 639.24219,0.125 Z m 0,2.6445313 H 639.24219 c 5.88605,0 10.58398,4.6979389 10.58398,10.5839847 V 432.07031 c 0,5.88605 -4.69793,10.58399 -10.58398,10.58399 H 13.353516 c -5.8860443,0 -10.5839847,-4.69795 -10.5839847,-10.58399 V 13.353516 c 0,-5.8860448 4.6979401,-10.5839847 10.5839847,-10.5839847 z
    //SVG for small card
    //m 18.197511,-0.85351563 c -10.5315547,0 -19.05102662,8.51652803 -19.05102663,19.04625363 V 426.24804 c 10e-9,10.52973 8.51947193,19.04625 19.05102663,19.04625 H 307.18036 c 10.53155,0 19.05103,-8.51652 19.05103,-19.04625 V 18.192738 c 0,-10.5297263 -8.51948,-19.04625363 -19.05103,-19.04625363 z m 0,2.56763903 H 307.18036 c 9.15317,0 16.48294,7.3270255 16.48294,16.4786146 V 426.24804 c 0,9.15159 -7.32977,16.47861 -16.48294,16.47861 H 18.197511 c -9.1531796,0 -16.4829417,-7.32702 -16.4829417,-16.47861 V 18.192738 c 0,-9.1515898 7.3297621,-16.4786146 16.4829417,-16.4786146 z

}
