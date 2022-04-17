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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.*;

public class ui extends Application {

    /**
     * Connection class for client server communication
     */
    public static final Connection connect = Connection.instance();

    /**
     * FXML form links
     */
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

    /**
     * Map setup for card color and type selection
     */
    public static final List<String> yellowCard = Arrays.asList("OrangeRed", "Khaki");
    public static final List<String> greenCard = Arrays.asList("ForestGreen", "PaleGreen");
    public static final List<String> blueCard = Arrays.asList("DodgerBlue", "PowderBlue");
    public static final Map<String, List<String>> colors = new HashMap<>(){{
        put("Yellow", yellowCard);
        put("Green", greenCard);
        put("Blue", blueCard);
    }};
    public static final HashMap<String,String> cardSymbols = new HashMap<>(){{
        put("Alpha", "m 54.189453,14.023438 c -3.551127,-0.01733 -5.87912,0.05722 -8.908203,0.738281 -3.029104,0.681061 -6.854586,1.927454 -9.574219,4.394531 -2.719637,2.467081 -3.942639,5.851619 -4.658203,8.427734 -0.71556,2.576101 -0.945638,4.687766 -0.628906,8.576172 0.316731,3.888394 1.053524,9.813293 3.939453,13.732422 2.885894,3.919081 7.612935,5.113988 12.492187,5.730469 4.879242,0.616479 10.21018,0.683401 15.671875,0.527344 5.461693,-0.156057 11.715279,-0.655919 16.548829,-6.941407 1.947326,-2.532279 3.623602,-6.040319 5.203125,-9.904297 1.439404,3.884529 2.823201,7.64147 4.412109,11.871094 l 2.476562,-0.929687 c -1.95835,-5.21307 -3.756769,-10.055487 -5.429687,-14.607422 1.763436,-4.848647 3.401317,-10.166807 5.042969,-15.546875 l -2.529297,-0.773438 c -1.305941,4.279865 -2.660786,8.312388 -4.021485,12.275391 -1.80555,-5.009618 -3.153121,-9.031834 -5.888671,-11.861328 -2.817787,-2.914554 -6.81571,-4.20795 -11.236329,-4.900391 -4.42064,-0.692444 -9.360985,-0.791263 -12.912109,-0.808593 z m -0.01172,2.646484 c 3.511426,0.01714 8.355915,0.126077 12.513672,0.777344 4.157779,0.65127 7.532274,1.837173 9.744141,4.125 2.211923,2.287884 3.559593,6.080872 5.458984,11.330078 0.282987,0.782069 0.706237,1.888645 1.011719,2.722656 -1.85966,4.975319 -3.812146,9.214539 -5.931641,11.970703 -4.226856,5.496551 -9.134961,5.756136 -14.52539,5.910156 -5.390427,0.154021 -10.60192,0.08143 -15.265625,-0.507812 -4.663694,-0.589246 -8.480231,-1.668371 -10.69336,-4.673828 -2.213093,-3.00541 -3.130143,-8.653546 -3.433593,-12.378907 -0.30345,-3.725347 -0.119505,-5.267361 0.542968,-7.652343 0.662469,-2.384968 1.780992,-5.269325 3.884766,-7.177735 2.103779,-1.908413 5.583709,-3.143453 8.376953,-3.771484 2.793266,-0.628036 4.804985,-0.690965 8.316406,-0.673828 z");
        put("Competency", "m 60.077127,3.356555 -8.843143,17.725284 -19.61502,2.763922 14.125631,13.887857 -3.432832,19.508861 17.573086,-9.142122 17.493467,9.292695 -0.46309,-2.770965 L 74.113388,37.855484 88.357637,24.089493 68.766991,21.157125 Z m -0.02709,6.2655406 6.864581,14.0617184 15.475366,2.316539 -11.251759,10.874244 2.578686,15.433119 -13.818517,-7.34067 -13.881358,7.222052 2.711385,-15.41091 -11.158599,-10.970654 15.494864,-2.183299 z");
    }};

    /**
     * List setup for Javafx components that need to be updated or iterated often
     */
    public static final List<String> alphaCardSVGs = Arrays.asList(
            "#alphaBackground", "#alphaBanner", "#alphaBorder", "#alphaCardSymbol",
            "#alphaStateBorder1", "#alphaStateBorder2", "#alphaStateBorder3", "#alphaStateBorder4", "#alphaStateBorder5", "#alphaStateBorder6"
    );
    public static final List<String> alphaCardLabels = Arrays.asList(
            "#cardTypeLabel", "#cardColorLabel"
    );
    public static final List<String> alphaCardTexts = Arrays.asList(
            "#alphaCardName", "#alphaBriefDesc", "#alphaDetailedDesc",
            "#alphaStateText1", "#alphaStateText2", "#alphaStateText3", "#alphaStateText4", "#alphaStateText5", "#alphaStateText6"
    );
    public static final List<String> stateCardSVGs = Arrays.asList(
            "#stateBackground1", "#stateBackground2", "#stateBackground3", "#stateBackground4", "#stateBackground5", "#stateBackground6",
            "#stateBanner1", "#stateBanner2", "#stateBanner3", "#stateBanner4", "#stateBanner5", "#stateBanner6",
            "#stateBorder1", "#stateBorder2", "#stateBorder3", "#stateBorder4", "#stateBorder5", "#stateBorder6",
            "#stateSymbol1", "#stateSymbol2", "#stateSymbol3", "#stateSymbol4", "#stateSymbol5", "#stateSymbol6",
            "#stateLabelBorder1", "#stateLabelBorder2", "#stateLabelBorder3", "#stateLabelBorder4", "#stateLabelBorder5", "#stateLabelBorder6"
    );
    public static final List<String> stateCardLabels = Arrays.asList(
            "#stateAlpha1", "#stateAlpha2", "#stateAlpha3", "#stateAlpha4", "#stateAlpha5", "#stateAlpha6",
            "#stateName1", "#stateName2", "#stateName3", "#stateName4", "#stateName5", "#stateName6"
    );
    public static final List<String> stateCardText = Arrays.asList(
            "#stateChecklist1", "#stateChecklist2", "#stateChecklist3", "#stateChecklist4", "#stateChecklist5", "#stateChecklist6"
    );

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

    /**
     * Change handlers for JavaFX
     * Controls the scene and which FXML is currently being displayed.
     * @throws IOException
     */
    public void showConnect() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new ConnectionController(this));
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

    /**
     * Card creator FXML changer
     * sets drop down menu contents and sets color and type of all cards on load.
     * @throws IOException
     */
    public void showCardCreator() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(cardCreator_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);

        ChoiceBox cardColor = (ChoiceBox) scene.lookup("#cardColorChoice");
        ChoiceBox cardType = (ChoiceBox) scene.lookup("#cardTypeChoice");

        for(String key : colors.keySet()){
            cardColor.getItems().add(key);
        }

        for(String key : cardSymbols.keySet()){
            cardType.getItems().add(key);
        }

        cardColor.setValue("Yellow");
        cardType.setValue("Alpha");

        SVGPath border = (SVGPath) scene.lookup("#alphaBorder");
        SVGPath banner = (SVGPath) scene.lookup("#alphaBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#alphaCardSymbol");

        border.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));
        symbol.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));
        banner.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(1))));

        for(int i = 1; i < 7; i++){
            SVGPath stateborder = (SVGPath) scene.lookup("#alphaStateBorder" + i);
            stateborder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardBorder = (SVGPath) scene.lookup("#stateBorder" + i);
            stateCardBorder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardBanner = (SVGPath) scene.lookup("#stateBanner" + i);
            stateCardBanner.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(1))));

            SVGPath stateCardLabelBorder = (SVGPath) scene.lookup("#stateLabelBorder" + i);
            stateCardLabelBorder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardSymbol = (SVGPath) scene.lookup("#stateSymbol" + i);
            stateCardSymbol.setContent(cardSymbols.get(cardType.getValue()));
            stateCardSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));
        }

        mainStage.setTitle("Essence Card Creator");
        mainStage.setScene(scene);
    }

    /**
     * Creates an Alpha class with associated states and their associated checklistitems
     * then sends the data to the server for storage in the database
     * @throws IOException
     * @throws InterruptedException
     */
    public void cardToJson() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();
        String name = ((TextArea) scene.lookup("#alphaCardName")).getText();
        String briefDesc = ((TextArea) scene.lookup("#alphaBriefDesc")).getText();
        String detailedDesc = ((TextArea) scene.lookup("#alphaDetailedDesc")).getText();
        String cardColor = ((ChoiceBox) scene.lookup("#cardColorChoice")).getValue().toString();
        String competencyCheck = ((ChoiceBox) scene.lookup("#cardTypeChoice")).getValue().toString();
        Boolean isCompetency = false;
        if (competencyCheck == "Alpha"){
            isCompetency = false;
        }
        else{
            isCompetency = true;
        }

        Alpha alpha = new Alpha(name, briefDesc, detailedDesc, cardColor,isCompetency);

        int trueCount = 1;
        for (int i = 1; i < 7; i++){
            String tempStateText = ((TextArea) scene.lookup("#alphaStateText" + i)).getText();

            if (tempStateText != ""){
                State tempState = new State(tempStateText, trueCount);

                String tempChecklistString = ((TextArea) scene.lookup("#stateChecklist" + i)).getText();
                String checklistItems[] = tempChecklistString.split("\\n");

                for (int j = 0; j < checklistItems.length; j++){
                    CheckListItem tempChecklistItem = new CheckListItem(checklistItems[j]);
                    tempState.addCheckListItem(tempChecklistItem);
                }

                alpha.addState(tempState);
                trueCount++;
            }
        }
        trueCount = 1;
        if(alpha.getAlpha() == "" || alpha.getAlpha() == null){
            showCardRequired();
        }else {
            connect.sendAlpha(alpha);
        }
    }

    /**
     * Show/Hide Alpha/State cards are used to toggle which cards are displayed on the screen
     */
    public void showAlphaCard(){
        Scene scene = mainStage.getScene();

        GridPane gridPane = (GridPane) scene.lookup("#stateCardGrid");
        gridPane.setVisible(false);

        for(String id : alphaCardSVGs){
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(true);
        }

        for(String id : alphaCardTexts){
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(true);
        }
    }
    public void hideAlphaCard(){
        Scene scene = mainStage.getScene();

        for(String id : alphaCardSVGs){
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(false);
        }

        for(String id : alphaCardTexts){
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(false);
        }
    }
    public void showStateCard(){
        Scene scene = mainStage.getScene();

        GridPane gridPane = (GridPane) scene.lookup("#stateCardGrid");
        gridPane.setVisible(true);

        for(String id : stateCardSVGs){
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(true);
        }

        for(String id : stateCardLabels){
            Label tempLabel = (Label) scene.lookup(id);
            tempLabel.setVisible(true);
        }

        for(String id : stateCardText){
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(true);
        }
    }
    public void hideStateCard(){
        Scene scene = mainStage.getScene();

        for(String id : stateCardSVGs){
            SVGPath tempPath = (SVGPath) scene.lookup(id);
            tempPath.setVisible(false);
        }

        for(String id : stateCardLabels){
            Label tempLabel = (Label) scene.lookup(id);
            tempLabel.setVisible(false);
        }

        for(String id : stateCardText){
            TextArea tempText = (TextArea) scene.lookup(id);
            tempText.setVisible(false);
        }
    }

    /**
     * Used to display changes made to the card dropdown menus
     */
    public void updateCard(){
        Scene scene = mainStage.getScene();

        ChoiceBox cardColor = (ChoiceBox) scene.lookup("#cardColorChoice");
        ChoiceBox cardType = (ChoiceBox) scene.lookup("#cardTypeChoice");

        SVGPath border = (SVGPath) scene.lookup("#alphaBorder");
        SVGPath banner = (SVGPath) scene.lookup("#alphaBanner");
        SVGPath symbol = (SVGPath) scene.lookup("#alphaCardSymbol");

        border.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));
        banner.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(1))));

        symbol.setContent(cardSymbols.get(cardType.getValue()));
        symbol.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));


        for(int i = 1; i < 7; i++){
            SVGPath stateborder = (SVGPath) scene.lookup("#alphaStateBorder" + i);
            stateborder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardBorder = (SVGPath) scene.lookup("#stateBorder" + i);
            stateCardBorder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardBanner = (SVGPath) scene.lookup("#stateBanner" + i);
            stateCardBanner.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(1))));

            SVGPath stateCardLabelBorder = (SVGPath) scene.lookup("#stateLabelBorder" + i);
            stateCardLabelBorder.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            SVGPath stateCardSymbol = (SVGPath) scene.lookup("#stateSymbol" + i);
            stateCardSymbol.setContent(cardSymbols.get(cardType.getValue()));
            stateCardSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(cardColor.getValue()).get(0))));

            //change text of state cards
            Label stateAlpha = (Label) scene.lookup("#stateAlpha" + i);
            String alphaName = ((TextArea) scene.lookup("#alphaCardName")).getText();
            stateAlpha.setText(alphaName);

            Label stateName = (Label) scene.lookup("#stateName" + i);
            String alphaStateText = ((TextArea) scene.lookup("#alphaStateText" + i)).getText();
            stateName.setText(alphaStateText);

        }

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

    /**
     * Response dialogs for invalid interactions
     * @throws IOException
     */
    public void showRequired() throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Connection invalid");
        alert.setContentText("The Url and port can not be empty.");

        alert.showAndWait();
    }
    public void showCardRequired() throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Card Contents");
        alert.setContentText("The name of the card cannot be empty.");

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