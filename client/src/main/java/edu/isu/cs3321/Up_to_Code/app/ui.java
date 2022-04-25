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

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ui extends Application {

    /**
     * Connection class for client server communication
     */
    public static final Connection connect = Connection.instance();

    public Connection getConnect(){
        return connect;
    }

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

    /**
     * JavaFX variables
     */
    Stage mainStage;
    uiController controller;

    /**
     * link format for served images from server
     */
    String imageURL = "http://%s:%s/images/%s";

    /**
     * Variable for tracking gameplay
     */
    int stateCounterOne = 0;
    int stateCounterTwo = 0;
    int stateCounterThree = 0;
    int stateCounterFour = 0;
    int stateCounterFive = 0;
    int stateCounterSix = 0;

    Alpha discussionAlpha;

    int gridxPos = 0;
    int gridyPos = 0;

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

    /**
     * Practice catalog FXML changer
     * @throws IOException
     */
    public void showPracticeCatalog() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(practiceCatalog_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Practice Catalog");
        mainStage.setScene(scene);
        mainStage.show();
        loadPracticeCatalog();
    }

    /**
     * Practice catalog loader
     * requests a list of image files in server practices folder then renders them in a gallery view.
     * @throws IOException
     * @throws InterruptedException
     */
    public void loadPracticeCatalog() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();
        TilePane tilePane = (TilePane) scene.lookup("#practiceTilePane");
        tilePane.setTileAlignment(Pos.TOP_LEFT);

        List<String> imgNames = new Gson().fromJson(connect.getPractices(), new TypeToken<List<String>>(){}.getType());

        for (String name : imgNames){
            Button button = new Button();
            button.setPrefWidth(280);
            button.setPrefHeight(280);

            Image image = new Image(String.format(imageURL, connect.url, connect.port, name));
            ImageView temp = new ImageView(image);
            temp.setFitHeight(280);
            temp.setPreserveRatio(true);
            button.setGraphic(temp);
            button.setStyle("-fx-background-color: transparent");

            ImageView tempClone = new ImageView(image);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setGraphic(tempClone);
                    alert.setTitle(name);
                    alert.setContentText("");
                    alert.setHeaderText("");

                    alert.show();
                }
            });

            tilePane.getChildren().add(button);

        }
        mainStage.show();
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

    public void savePractice(File file) throws IOException, InterruptedException {
        connect.sendPractice(file);
    }

    /**
     * Card catalog FXML changer
     * @throws IOException
     */
    public void showCardCatalog() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(cardCatalog_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);
        mainStage.setTitle("Essence Card Catalog");
        mainStage.setScene(scene);
        loadCardCatalog();
    }

    public void loadCardCatalog() throws IOException, InterruptedException {
        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());

        for (Alpha alpha : alphaList){
            cardFXLoader(alpha);
        }

    }

    public void cardFXLoader(Alpha alpha){
        Scene scene = mainStage.getScene();
        TilePane tilePane = (TilePane) scene.lookup("#cardCatalogTilePane");

        Button button = new Button();
        button.setMaxWidth(300);
        button.setMaxHeight(280);
        button.setStyle("-fx-background-color: transparent");

        StackPane pane = new StackPane();
        pane.setPadding(new Insets(0, 0, 0, 0));
        pane.maxWidth(300);
        pane.maxHeight(280);
        pane.setAlignment(Pos.TOP_LEFT);

        SVGPath back = new SVGPath();
        back.setContent("M6.615.684H319.621c3.298 0 5.953 2.655 5.953 5.953V216.023c0 3.298-2.655 5.953-5.953 5.953H6.615c-3.298 0-5.953-2.655-5.953-5.953V6.637c0-3.298 2.655-5.953 5.953-5.953z");
        back.setFill(Paint.valueOf("white"));
        pane.getChildren().add(back);

        SVGPath banner = new SVGPath();
        banner.setContent("M 6.625 0.665 H 319.614 c 3.298 0 5.953 2.655 5.953 5.953 v 35.382 c 0 3.298 -2.655 5.953 -5.953 5.953 H 6.625 c -3.298 0 -5.953 -2.655 -5.953 -5.953 V 6.618 c 0 -3.298 2.655 -5.953 5.953 -5.953 z");
        banner.setFill(Paint.valueOf(String.valueOf(colors.get(alpha.getColor()).get(1))));
        pane.getChildren().add(banner);

        int topMargin = 52;
        List<SVGPath> paths = new ArrayList<>();
        for (State state : alpha.getStates()){
            //creates and positions svg for state border
            SVGPath stateBorder = new SVGPath();
            stateBorder.setContent("m15.875 38.612c-3.653 0-6.614 2.962-6.614 6.615v9.178c0 3.653 2.961 6.614 6.614 6.614h126.173c3.653 0 6.615-2.961 6.615-6.614V45.228c0-3.653-2.962-6.615-6.615-6.615zm0 1.323h126.173c2.943 0 5.292 2.349 5.292 5.292v9.178c0 2.943-2.349 5.291-5.292 5.291H15.875c-2.943 0-5.292-2.348-5.292-5.291V45.228c0-2.943 2.349-5.292 5.292-5.292z");
            stateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(alpha.getColor()).get(0))));
            pane.getChildren().add(stateBorder);
            StackPane.setMargin(stateBorder, new Insets(topMargin, 0, 0, 10));

            //creates and positions label with state name
            Label label = new Label();
            label.setText(state.getName());
            label.setMinWidth(125);
            label.setAlignment(Pos.CENTER);
            label.setStyle("-fx-font-weight: Bold");
            pane.getChildren().add(label);
            StackPane.setMargin(label, new Insets(topMargin + 3, 0, 0, 15));

            topMargin = topMargin + 28;
        }
        topMargin = 25;

        SVGPath border = new SVGPath();
        border.setContent("m6.618.001c-3.653 0-6.614 2.961-6.614 6.614V216.029c0 3.653 2.961 6.614 6.614 6.614H319.615c3.653 0 6.614-2.961 6.614-6.614V6.615c0-3.653-2.961-6.614-6.614-6.614zm0 1.322H319.615c2.943 0 5.291 2.349 5.291 5.292V216.029c0 2.943-2.348 5.292-5.291 5.292H6.618c-2.943 0-5.291-2.349-5.291-5.292V6.615c0-2.943 2.348-5.292 5.291-5.292z");
        border.setFill(Paint.valueOf(String.valueOf(colors.get(alpha.getColor()).get(0))));
        pane.getChildren().add(border);

        SVGPath symbol = new SVGPath();
        if(!alpha.isCompetency()){
            symbol.setContent("m27.095 7.012c-1.776-.009-2.94.029-4.454.369-1.515.341-3.427.964-4.787 2.197-1.36 1.234-1.971 2.926-2.329 4.214-.358 1.288-.473 2.344-.314 4.288.158 1.944.527 4.907 1.97 6.866 1.443 1.96 3.806 2.557 6.246 2.865 2.44.308 5.105.342 7.836.264 2.731-.078 5.858-.328 8.274-3.471.974-1.266 1.812-3.02 2.602-4.952.72 1.942 1.412 3.821 2.206 5.936l1.238-.465c-.979-2.607-1.878-5.028-2.715-7.304.882-2.424 1.701-5.083 2.521-7.773l-1.265-.387c-.653 2.14-1.33 4.156-2.011 6.138-.903-2.505-1.577-4.516-2.944-5.931-1.409-1.457-3.408-2.104-5.618-2.45-2.21-.346-4.68-.396-6.456-.404zm-.006 1.323c1.756.009 4.178.063 6.257.389 2.079.326 3.766.919 4.872 2.063 1.106 1.144 1.78 3.04 2.729 5.665.141 .391.353 .944.506 1.361-.93 2.488-1.906 4.607-2.966 5.985-2.113 2.748-4.567 2.878-7.263 2.955-2.695.077-5.301.041-7.633-.254-2.332-.295-4.24-.834-5.347-2.337-1.107-1.503-1.565-4.327-1.717-6.189-.152-1.863-.06-2.634.271-3.826.331-1.192.89-2.635 1.942-3.589 1.052-.954 2.792-1.572 4.188-1.886 1.397-.314 2.402-.345 4.158-.337z");
            symbol.setScaleX(1.3);
            symbol.setScaleY(1.3);
            symbol.setFill(Paint.valueOf(String.valueOf(colors.get(alpha.getColor()).get(0))));
            pane.getChildren().add(symbol);
            StackPane.setMargin(symbol, new Insets(15, 0, 0, 15));
        }else {
            symbol.setContent("m30.039 1.678-4.422 8.863-9.808 1.382 7.063 6.944-1.716 9.754 8.787-4.571 8.747 4.646-.232-1.385L37.057 18.928 44.179 12.045 34.383 10.579Zm-.014 3.133 3.432 7.031 7.738 1.158-5.626 5.437 1.289 7.717-6.909-3.67-6.941 3.611 1.356-7.705-5.579-5.485 7.747-1.092z");
            symbol.setScaleX(1.3);
            symbol.setScaleY(1.3);
            symbol.setFill(Paint.valueOf(String.valueOf(colors.get(alpha.getColor()).get(0))));
            pane.getChildren().add(symbol);
            StackPane.setMargin(symbol, new Insets(10, 0, 0, 20));
        }

        Label alphaName = new Label();
        alphaName.setText(alpha.getAlpha());
        alphaName.setStyle("-fx-font-style: Bold; -fx-font-size: 24");
        pane.getChildren().add(alphaName);
        StackPane.setMargin(alphaName, new Insets(5, 0, 0, 65));

        Label alphaBrief = new Label();
        alphaBrief.setText(alpha.getBriefDesc());
        alphaBrief.setMaxWidth(160);
        alphaBrief.setMaxHeight(60);
        alphaBrief.setWrapText(true);
        alphaBrief.setAlignment(Pos.TOP_LEFT);
        alphaBrief.setStyle("-fx-font-size: 10");
        pane.getChildren().add(alphaBrief);
        StackPane.setMargin(alphaBrief, new Insets(52, 0, 0, 160));

        Label alphaDetailed = new Label();
        alphaDetailed.setText(alpha.getDetailedDesc());
        alphaDetailed.setMaxWidth(160);
        alphaDetailed.setMaxHeight(110);
        alphaDetailed.setWrapText(true);
        alphaDetailed.setAlignment(Pos.TOP_LEFT);
        alphaDetailed.setStyle("-fx-font-size: 10");
        pane.getChildren().add(alphaDetailed);
        StackPane.setMargin(alphaDetailed, new Insets(100, 0, 0, 160));

        button.setGraphic(pane);
        tilePane.getChildren().add(button);

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

    public void showProgressPoker() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(progressPoker_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        Map<String, String> alphaMap = new HashMap<>();
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#pokerCardSelector");

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha.getAlpha());
            cardSelector.getItems().add(alpha.getAlpha() + " " + alpha.getId());
        }

        mainStage.setTitle("Essence Progress Poker");
        mainStage.setScene(scene);
    }

    public void stateCounter(int num){
        switch (num){
            case 1: stateCounterOne += 1;
                break;
            case 2: stateCounterTwo += 1;
                break;
            case 3: stateCounterThree += 1;
                break;
            case 4: stateCounterFour += 1;
                break;
            case 5: stateCounterFive += 1;
                break;
            case 6: stateCounterSix += 1;
                break;
        }
    }
    public void stateCounterReset(){
        stateCounterOne = 0;
        stateCounterTwo = 0;
        stateCounterThree = 0;
        stateCounterFour = 0;
        stateCounterFive = 0;
        stateCounterSix = 0;
    }

    public void startPokerDiscussion() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();

        stateCounterReset();

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#pokerCardSelector");
        Map<String, Alpha> alphaMap = new HashMap<>();

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha);
        }

        discussionAlpha = alphaMap.get(cardSelector.getValue());

        /**
         * Generation of alpha to be discussed
         */
        StackPane alphaPane = (StackPane) scene.lookup("#pokerAlpha");

        StackPane pane = new StackPane();
        pane.setPadding(new Insets(0, 0, 0, 0));
        pane.maxWidth(300);
        pane.maxHeight(280);
        pane.setAlignment(Pos.TOP_LEFT);

        SVGPath back = new SVGPath();
        back.setContent("M11.907 1.231H575.318c5.936 0 10.715 4.779 10.715 10.715V388.841c0 5.936-4.779 10.715-10.715 10.715H11.907c-5.936 0-10.715-4.779-10.715-10.715V11.947c0-5.936 4.779-10.715 10.715-10.715z");
        back.setFill(Paint.valueOf("white"));
        pane.getChildren().add(back);

        SVGPath banner = new SVGPath();
        banner.setContent("M11.925 1.197H575.305c5.936 0 10.715 4.779 10.715 10.715v63.688c0 5.936-4.779 10.715-10.715 10.715H11.925c-5.936 0-10.715-4.779-10.715-10.715V11.912c0-5.936 4.779-10.715 10.715-10.715z");
        banner.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(1))));
        pane.getChildren().add(banner);

        int topMargin = 104;
        for (State state : discussionAlpha.getStates()){
            //creates and positions svg for state border
            SVGPath stateBorder = new SVGPath();
            stateBorder.setContent("m28.575 69.502c-6.575 0-11.905 5.332-11.905 11.907v16.52c0 6.575 5.33 11.905 11.905 11.905h227.111c6.575 0 11.907-5.33 11.907-11.905V81.41c0-6.575-5.332-11.907-11.907-11.907zm0 2.381h227.111c5.297 0 9.526 4.228 9.526 9.526v16.52c0 5.297-4.228 9.524-9.526 9.524H28.575c-5.297 0-9.526-4.226-9.526-9.524V81.41c0-5.297 4.228-9.526 9.526-9.526z");
            stateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
            pane.getChildren().add(stateBorder);
            StackPane.setMargin(stateBorder, new Insets(topMargin, 0, 0, 20));

            //creates and positions label with state name
            Label label = new Label();
            label.setText(state.getName());
            label.setMinWidth(125);
            label.setAlignment(Pos.CENTER);
            label.setStyle("-fx-font-size: 20; -fx-font-weight: Bold");
            pane.getChildren().add(label);
            StackPane.setMargin(label, new Insets(topMargin + 6, 0, 0, 30));

            topMargin = topMargin + 50;
        }
        topMargin = 104;

        SVGPath border = new SVGPath();
        border.setContent("m11.912.002c-6.575 0-11.905 5.33-11.905 11.905V388.852c0 6.575 5.33 11.905 11.905 11.905H575.307c6.575 0 11.905-5.33 11.905-11.905V11.907c0-6.575-5.33-11.905-11.905-11.905zm0 2.38H575.307c5.297 0 9.524 4.228 9.524 9.526V388.852c0 5.297-4.226 9.526-9.524 9.526H11.912c-5.297 0-9.524-4.228-9.524-9.526V11.907c0-5.297 4.226-9.526 9.524-9.526z");
        border.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
        pane.getChildren().add(border);

        SVGPath symbol = new SVGPath();
        if(!discussionAlpha.isCompetency()){
            symbol.setContent("m48.771 12.622c-3.197-.016-5.292.052-8.017.664-2.727.614-6.169 1.735-8.617 3.955-2.448 2.221-3.548 5.267-4.192 7.585-.644 2.318-.851 4.219-.565 7.718.284 3.499.949 8.833 3.546 12.359 2.597 3.528 6.851 4.603 11.243 5.157 4.392.554 9.189.616 14.105.475 4.916-.14 10.544-.59 14.893-6.248 1.753-2.279 3.262-5.436 4.684-8.914 1.296 3.496 2.542 6.878 3.971 10.685l2.228-.837c-1.762-4.693-3.38-9.05-4.887-13.147 1.588-4.363 3.062-9.149 4.538-13.991l-2.277-.697c-1.175 3.852-2.394 7.481-3.62 11.048-1.625-4.509-2.839-8.129-5.299-10.676-2.536-2.623-6.134-3.787-10.112-4.41-3.978-.623-8.424-.713-11.621-.727zm-.011 2.381c3.161.016 7.52.113 11.263.7 3.742.587 6.779 1.654 8.77 3.713 1.991 2.059 3.204 5.472 4.912 10.197.254 .704.635 1.699.911 2.45-1.674 4.478-3.431 8.293-5.339 10.773-3.803 4.946-8.221 5.18-13.073 5.319-4.851.139-9.542.074-13.739-.457-4.198-.531-7.632-1.501-9.625-4.207-1.993-2.705-2.817-7.789-3.091-11.14-.274-3.353-.108-4.741.488-6.887.596-2.146 1.602-4.743 3.496-6.46 1.894-1.717 5.026-2.83 7.538-3.395 2.515-.565 4.324-.621 7.484-.607z");
            symbol.setScaleX(1.3);
            symbol.setScaleY(1.3);
            symbol.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
            pane.getChildren().add(symbol);
            StackPane.setMargin(symbol, new Insets(30, 0, 0, 30));
        }else {
            symbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
            symbol.setScaleX(1.3);
            symbol.setScaleY(1.3);
            symbol.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
            pane.getChildren().add(symbol);
            StackPane.setMargin(symbol, new Insets(10, 0, 0, 40));
        }

        Label alphaName = new Label();
        alphaName.setText(discussionAlpha.getAlpha());
        alphaName.setStyle("-fx-font-style: Bold; -fx-font-size: 36");
        pane.getChildren().add(alphaName);
        StackPane.setMargin(alphaName, new Insets(20, 0, 0, 130));

        Label alphaBrief = new Label();
        alphaBrief.setText(discussionAlpha.getBriefDesc());
        alphaBrief.setMaxWidth(275);
        alphaBrief.setMaxHeight(80);
        alphaBrief.setWrapText(true);
        alphaBrief.setAlignment(Pos.TOP_LEFT);
        alphaBrief.setStyle("-fx-font-size: 16");
        pane.getChildren().add(alphaBrief);
        StackPane.setMargin(alphaBrief, new Insets(104, 0, 0, 300));

        Label alphaDetailed = new Label();
        alphaDetailed.setText(discussionAlpha.getDetailedDesc());
        alphaDetailed.setMaxWidth(275);
        alphaDetailed.setMaxHeight(150);
        alphaDetailed.setWrapText(true);
        alphaDetailed.setAlignment(Pos.TOP_LEFT);
        alphaDetailed.setStyle("-fx-font-size: 16");
        pane.getChildren().add(alphaDetailed);
        StackPane.setMargin(alphaDetailed, new Insets(200, 0, 0, 300));

        alphaPane.getChildren().add(pane);
        alphaPane.setPadding(new Insets(5, 0, 0, 125));

        /**
         * Generation of the hand
         */
        GridPane hand = (GridPane) scene.lookup("#pokerHand");
        int handPos = 0;

        int checklistTopMargin = 68;
        for (State state : discussionAlpha.getStates()){
            Button button = new Button();
            button.setMaxWidth(80);
            button.setMaxHeight(100);
            button.setStyle("-fx-background-color: transparent");

            StackPane statePane = new StackPane();
            statePane.setPadding(new Insets(0, 0, 0, 0));
            statePane.maxWidth(80);
            statePane.maxHeight(100);
            statePane.setAlignment(Pos.TOP_LEFT);

            SVGPath stateBack = new SVGPath();
            stateBack.setContent("M10.856.606H142.201c5.343 0 9.644 4.301 9.644 9.644V196.756c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644V10.25c0-5.343 4.301-9.644 9.644-9.644z");
            stateBack.setFill(Paint.valueOf("white"));
            statePane.getChildren().add(stateBack);

            SVGPath stateBanner = new SVGPath();
            stateBanner.setContent("M10.856.606H141.595c5.343 0 9.644 4.301 9.644 9.644v20.416c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644v-20.416c0-5.343 4.301-9.644 9.644-9.644z");
            stateBanner.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(1))));
            statePane.getChildren().add(stateBanner);

            SVGPath stateBorder = new SVGPath();
            stateBorder.setContent("m142.177.041c4.859 0 8.791 3.93 8.791 8.788v188.286c0 4.859-3.931 8.788-8.791 8.788H8.834c-4.859 0-8.791-3.93-8.791-8.788V8.83c0-4.859 3.931-8.788 8.791-8.788zm0 1.185H8.834c-4.223 0-7.606 3.381-7.606 7.604v188.286c0 4.223 3.382 7.604 7.606 7.604H142.177c4.223 0 7.606-3.381 7.606-7.604V8.83c0-4.223-3.382-7.604-7.606-7.604z");
            stateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateBorder);

            SVGPath stateNameBorder = new SVGPath();
            stateNameBorder.setContent("m20.555 51.595c-5.63 0-10.18 4.55-10.18 10.18v1.321c0 5.63 4.55 10.18 10.18 10.18H132.199c5.63 0 10.18-4.55 10.18-10.18v-1.321c0-5.63-4.55-10.18-10.18-10.18zm0 1.071H132.199c5.055 0 9.108 4.054 9.108 9.109v1.321c0 5.055-4.053 9.108-9.108 9.108H20.555c-5.055 0-9.108-4.053-9.108-9.108v-1.321c0-5.055 4.053-9.109 9.108-9.109z");
            stateNameBorder.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateNameBorder);
            StackPane.setMargin(stateNameBorder, new Insets(45, 0, 0, 10));

            SVGPath stateSymbol = new SVGPath();
            if(!discussionAlpha.isCompetency()){
                stateSymbol.setContent("m39.505 10.224c-2.59-.013-4.287.042-6.494.538-2.209.497-4.997 1.405-6.98 3.204-1.983 1.799-2.874 4.266-3.396 6.144-.522 1.878-.689 3.417-.458 6.252.23 2.834.769 7.155 2.872 10.011 2.104 2.858 5.549 3.728 9.107 4.177 3.558.449 7.443.499 11.425.385 3.982-.113 8.541-.478 12.063-5.061 1.42-1.846 2.642-4.403 3.794-7.22 1.05 2.832 2.059 5.571 3.217 8.655l1.805-.678c-1.427-3.801-2.738-7.33-3.958-10.649 1.286-3.534 2.48-7.411 3.676-11.333l-1.844-.565c-.952 3.12-1.939 6.06-2.932 8.949-1.316-3.652-2.3-6.584-4.292-8.648-2.054-2.125-4.969-3.067-8.191-3.572-3.222-.505-6.823-.578-9.413-.589zm-.009 1.929c2.56.013 6.091.092 9.123.567 3.031.475 5.491 1.34 7.104 3.008 1.613 1.668 2.595 4.432 3.979 8.26.206 .57.514 1.376.738 1.985-1.356 3.627-2.779 6.717-4.325 8.726-3.08 4.006-6.659 4.196-10.589 4.308-3.929.113-7.729.06-11.129-.37-3.4-.43-6.182-1.216-7.796-3.408-1.614-2.191-2.282-6.309-2.504-9.023-.222-2.716-.087-3.84.395-5.578.483-1.738 1.298-3.842 2.832-5.233 1.534-1.391 4.071-2.292 6.106-2.75 2.037-.458 3.502-.503 6.062-.492z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 5));
            }else {
                stateSymbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(discussionAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 8));
            }

            for (CheckListItem checkListItem: state.getChecklist()){
                Label item = new Label();
                item.setText(checkListItem.getChecklistitem());
                item.setStyle("-fx-font-style: Bold; -fx-font-size: 10");
                statePane.getChildren().add(item);
                StackPane.setMargin(item, new Insets(checklistTopMargin, 0, 0, 15));
                checklistTopMargin += 12;
            }
            checklistTopMargin = 68;

            Label stateAlpha = new Label();
            stateAlpha.setText(discussionAlpha.getAlpha());
            stateAlpha.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateAlpha);
            StackPane.setMargin(stateAlpha, new Insets(7, 0, 0, 50));

            Label stateName = new Label();
            stateName.setText(state.getName());
            stateName.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateName);
            StackPane.setMargin(stateName, new Insets(42, 0, 0, 50));

            GridPane.setConstraints(button, handPos, 0);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stateCounter(state.getStateOrder());
                    System.out.println(state.getStateOrder());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Next Participant");
                    alert.setHeaderText("Next player");

                    alert.show();
                }
            });

            button.setGraphic(statePane);
            button.setPadding( new Insets( 0, 0, 0, 0));

            hand.getChildren().add(button);
            handPos += 1;
        }
        handPos = 0;
    }

    public void endPokerDiscussion() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Results");
        alert.setHeaderText("Results of discussion:");

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        if (discussionAlpha.getStates().get(0) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(0).getName(), stateCounterOne));
        }
        if (discussionAlpha.getStates().get(1) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(1).getName(), stateCounterTwo));
        }
        if (discussionAlpha.getStates().get(2) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(2).getName(), stateCounterThree));
        }
        if (discussionAlpha.getStates().get(3) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(3).getName(), stateCounterFour));
        }
        if (discussionAlpha.getStates().get(4) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(4).getName(), stateCounterFive));
        }
        if (discussionAlpha.getStates().get(5) != null){
            pieChartData.add(new PieChart.Data(discussionAlpha.getStates().get(5).getName(), stateCounterSix));
        }

        PieChart pieChart = new PieChart(pieChartData);

        alert.setGraphic(pieChart);
        alert.showAndWait();
    }


    public void showChaseTheState() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(chaseTheState_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        Map<String, String> alphaMap = new HashMap<>();
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#chaseSelector");

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha.getAlpha());
            cardSelector.getItems().add(alpha.getAlpha() + " " + alpha.getId());
        }

        gridxPos = 0;
        gridyPos = 0;

        mainStage.setTitle("Essence Chase the State");
        mainStage.setScene(scene);
    }

    public void chaseTheStateAddAlpha() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#chaseSelector");
        Map<String, Alpha> alphaMap = new HashMap<>();

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha);
        }

        Alpha chaseAlpha = alphaMap.get(cardSelector.getValue());

        GridPane gridPane = (GridPane) scene.lookup("#chaseTheStateGrid");

        /**
         * make small alpha
         */
        Button alphaButton = new Button();
        alphaButton.setMaxWidth(80);
        alphaButton.setMaxHeight(100);
        alphaButton.setStyle("-fx-background-color: transparent");

        StackPane alphaPane = new StackPane();
        alphaPane.setPadding(new Insets(0, 0, 0, 0));
        alphaPane.maxWidth(80);
        alphaPane.maxHeight(100);
        alphaPane.setAlignment(Pos.TOP_LEFT);

        SVGPath alphaBack = new SVGPath();
        alphaBack.setContent("M10.856.606H142.201c5.343 0 9.644 4.301 9.644 9.644V196.756c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644V10.25c0-5.343 4.301-9.644 9.644-9.644z");
        alphaBack.setFill(Paint.valueOf("white"));
        alphaPane.getChildren().add(alphaBack);

        SVGPath alphaBanner = new SVGPath();
        alphaBanner.setContent("M10.856.606H141.595c5.343 0 9.644 4.301 9.644 9.644v20.416c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644v-20.416c0-5.343 4.301-9.644 9.644-9.644z");
        alphaBanner.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(1))));
        alphaPane.getChildren().add(alphaBanner);

        SVGPath alphaBorder = new SVGPath();
        alphaBorder.setContent("m142.177.041c4.859 0 8.791 3.93 8.791 8.788v188.286c0 4.859-3.931 8.788-8.791 8.788H8.834c-4.859 0-8.791-3.93-8.791-8.788V8.83c0-4.859 3.931-8.788 8.791-8.788zm0 1.185H8.834c-4.223 0-7.606 3.381-7.606 7.604v188.286c0 4.223 3.382 7.604 7.606 7.604H142.177c4.223 0 7.606-3.381 7.606-7.604V8.83c0-4.223-3.382-7.604-7.606-7.604z");
        alphaBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
        alphaPane.getChildren().add(alphaBorder);

        int stateBorderMargin = 45;
        for (State state : chaseAlpha.getStates()){
            SVGPath alphaStateBorder = new SVGPath();
            alphaStateBorder.setContent("m20.555 51.595c-5.63 0-10.18 4.55-10.18 10.18v1.321c0 5.63 4.55 10.18 10.18 10.18H132.199c5.63 0 10.18-4.55 10.18-10.18v-1.321c0-5.63-4.55-10.18-10.18-10.18zm0 1.071H132.199c5.055 0 9.108 4.054 9.108 9.109v1.321c0 5.055-4.053 9.108-9.108 9.108H20.555c-5.055 0-9.108-4.053-9.108-9.108v-1.321c0-5.055 4.053-9.109 9.108-9.109z");
            alphaStateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaStateBorder);
            StackPane.setMargin(alphaStateBorder, new Insets(stateBorderMargin, 0, 0, 10));

            Label alphaState = new Label();
            alphaState.setText(state.getName());
            alphaState.setStyle("-fx-font-style: Bold; -fx-font-size: 10");
            alphaPane.getChildren().add(alphaState);
            StackPane.setMargin(alphaState, new Insets(stateBorderMargin+5, 0, 0, 50));

            stateBorderMargin += 23;
        }

        SVGPath alphaSymbol = new SVGPath();
        if(!chaseAlpha.isCompetency()){
            alphaSymbol.setContent("m39.505 10.224c-2.59-.013-4.287.042-6.494.538-2.209.497-4.997 1.405-6.98 3.204-1.983 1.799-2.874 4.266-3.396 6.144-.522 1.878-.689 3.417-.458 6.252.23 2.834.769 7.155 2.872 10.011 2.104 2.858 5.549 3.728 9.107 4.177 3.558.449 7.443.499 11.425.385 3.982-.113 8.541-.478 12.063-5.061 1.42-1.846 2.642-4.403 3.794-7.22 1.05 2.832 2.059 5.571 3.217 8.655l1.805-.678c-1.427-3.801-2.738-7.33-3.958-10.649 1.286-3.534 2.48-7.411 3.676-11.333l-1.844-.565c-.952 3.12-1.939 6.06-2.932 8.949-1.316-3.652-2.3-6.584-4.292-8.648-2.054-2.125-4.969-3.067-8.191-3.572-3.222-.505-6.823-.578-9.413-.589zm-.009 1.929c2.56.013 6.091.092 9.123.567 3.031.475 5.491 1.34 7.104 3.008 1.613 1.668 2.595 4.432 3.979 8.26.206 .57.514 1.376.738 1.985-1.356 3.627-2.779 6.717-4.325 8.726-3.08 4.006-6.659 4.196-10.589 4.308-3.929.113-7.729.06-11.129-.37-3.4-.43-6.182-1.216-7.796-3.408-1.614-2.191-2.282-6.309-2.504-9.023-.222-2.716-.087-3.84.395-5.578.483-1.738 1.298-3.842 2.832-5.233 1.534-1.391 4.071-2.292 6.106-2.75 2.037-.458 3.502-.503 6.062-.492z");
            alphaSymbol.setScaleX(.7);
            alphaSymbol.setScaleY(.7);
            alphaSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaSymbol);
            StackPane.setMargin(alphaSymbol, new Insets(5, 0, 0, 5));
        }else {
            alphaSymbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
            alphaSymbol.setScaleX(.7);
            alphaSymbol.setScaleY(.7);
            alphaSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaSymbol);
            StackPane.setMargin(alphaSymbol, new Insets(5, 0, 0, 8));
        }

        Label alphaAlpha = new Label();
        alphaAlpha.setText(chaseAlpha.getAlpha());
        alphaAlpha.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
        alphaPane.getChildren().add(alphaAlpha);
        StackPane.setMargin(alphaAlpha, new Insets(7, 0, 0, 50));

        GridPane.setConstraints(alphaButton, gridxPos, gridyPos);
        GridPane.setRowIndex(alphaButton, gridyPos);

        alphaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        alphaButton.setGraphic(alphaPane);
        alphaButton.setPadding( new Insets( 0, 0, 0, 0));

        gridPane.getChildren().add(alphaButton);
        gridxPos += 3;

        /**
         * make states
         */

        for (State state : chaseAlpha.getStates()){
            Button button = new Button();
            button.setMaxWidth(80);
            button.setMaxHeight(100);
            button.setStyle("-fx-background-color: transparent");

            StackPane statePane = new StackPane();
            statePane.setPadding(new Insets(0, 0, 0, 0));
            statePane.maxWidth(80);
            statePane.maxHeight(100);
            statePane.setAlignment(Pos.TOP_LEFT);

            SVGPath stateBack = new SVGPath();
            stateBack.setContent("M10.856.606H142.201c5.343 0 9.644 4.301 9.644 9.644V196.756c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644V10.25c0-5.343 4.301-9.644 9.644-9.644z");
            stateBack.setFill(Paint.valueOf("white"));
            statePane.getChildren().add(stateBack);

            SVGPath stateBanner = new SVGPath();
            stateBanner.setContent("M10.856.606H141.595c5.343 0 9.644 4.301 9.644 9.644v20.416c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644v-20.416c0-5.343 4.301-9.644 9.644-9.644z");
            stateBanner.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(1))));
            statePane.getChildren().add(stateBanner);

            SVGPath stateBorder = new SVGPath();
            stateBorder.setContent("m142.177.041c4.859 0 8.791 3.93 8.791 8.788v188.286c0 4.859-3.931 8.788-8.791 8.788H8.834c-4.859 0-8.791-3.93-8.791-8.788V8.83c0-4.859 3.931-8.788 8.791-8.788zm0 1.185H8.834c-4.223 0-7.606 3.381-7.606 7.604v188.286c0 4.223 3.382 7.604 7.606 7.604H142.177c4.223 0 7.606-3.381 7.606-7.604V8.83c0-4.223-3.382-7.604-7.606-7.604z");
            stateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateBorder);

            SVGPath stateNameBorder = new SVGPath();
            stateNameBorder.setContent("m20.555 51.595c-5.63 0-10.18 4.55-10.18 10.18v1.321c0 5.63 4.55 10.18 10.18 10.18H132.199c5.63 0 10.18-4.55 10.18-10.18v-1.321c0-5.63-4.55-10.18-10.18-10.18zm0 1.071H132.199c5.055 0 9.108 4.054 9.108 9.109v1.321c0 5.055-4.053 9.108-9.108 9.108H20.555c-5.055 0-9.108-4.053-9.108-9.108v-1.321c0-5.055 4.053-9.109 9.108-9.109z");
            stateNameBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateNameBorder);
            StackPane.setMargin(stateNameBorder, new Insets(45, 0, 0, 10));

            SVGPath stateSymbol = new SVGPath();
            if(!chaseAlpha.isCompetency()){
                stateSymbol.setContent("m39.505 10.224c-2.59-.013-4.287.042-6.494.538-2.209.497-4.997 1.405-6.98 3.204-1.983 1.799-2.874 4.266-3.396 6.144-.522 1.878-.689 3.417-.458 6.252.23 2.834.769 7.155 2.872 10.011 2.104 2.858 5.549 3.728 9.107 4.177 3.558.449 7.443.499 11.425.385 3.982-.113 8.541-.478 12.063-5.061 1.42-1.846 2.642-4.403 3.794-7.22 1.05 2.832 2.059 5.571 3.217 8.655l1.805-.678c-1.427-3.801-2.738-7.33-3.958-10.649 1.286-3.534 2.48-7.411 3.676-11.333l-1.844-.565c-.952 3.12-1.939 6.06-2.932 8.949-1.316-3.652-2.3-6.584-4.292-8.648-2.054-2.125-4.969-3.067-8.191-3.572-3.222-.505-6.823-.578-9.413-.589zm-.009 1.929c2.56.013 6.091.092 9.123.567 3.031.475 5.491 1.34 7.104 3.008 1.613 1.668 2.595 4.432 3.979 8.26.206 .57.514 1.376.738 1.985-1.356 3.627-2.779 6.717-4.325 8.726-3.08 4.006-6.659 4.196-10.589 4.308-3.929.113-7.729.06-11.129-.37-3.4-.43-6.182-1.216-7.796-3.408-1.614-2.191-2.282-6.309-2.504-9.023-.222-2.716-.087-3.84.395-5.578.483-1.738 1.298-3.842 2.832-5.233 1.534-1.391 4.071-2.292 6.106-2.75 2.037-.458 3.502-.503 6.062-.492z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 5));
            }else {
                stateSymbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 8));
            }

            int checklistTopMargin = 68;
            for (CheckListItem checkListItem: state.getChecklist()){
                Label item = new Label();
                item.setText(checkListItem.getChecklistitem());
                item.setStyle("-fx-font-style: Bold; -fx-font-size: 10");
                statePane.getChildren().add(item);
                StackPane.setMargin(item, new Insets(checklistTopMargin, 0, 0, 15));
                checklistTopMargin += 12;
            }
            checklistTopMargin = 68;

            Label stateAlpha = new Label();
            stateAlpha.setText(chaseAlpha.getAlpha());
            stateAlpha.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateAlpha);
            StackPane.setMargin(stateAlpha, new Insets(7, 0, 0, 50));

            Label stateName = new Label();
            stateName.setText(state.getName());
            stateName.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateName);
            StackPane.setMargin(stateName, new Insets(42, 0, 0, 50));

            GridPane.setConstraints(button, gridxPos, gridyPos);
            GridPane.setRowIndex(button, gridyPos);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(GridPane.getColumnIndex(button) > state.getStateOrder()+1){
                        GridPane.setColumnIndex(button, GridPane.getColumnIndex(button)-2);
                    }
                }
            });

            button.setGraphic(statePane);
            button.setPadding( new Insets( 0, 0, 0, 0));

            gridPane.getChildren().add(button);
            gridxPos += 1;
        }
        gridxPos = 0;
        gridyPos += 1;

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
    public void showObjectiveGo() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new uiController(this));
        loader.setLocation(getClass().getResource(objectiveGo_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 680);

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        Map<String, String> alphaMap = new HashMap<>();
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#objectiveSelector");

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha.getAlpha());
            cardSelector.getItems().add(alpha.getAlpha() + " " + alpha.getId());
        }

        gridxPos = 0;
        gridyPos = 0;

        mainStage.setTitle("Essence Objective Go");
        mainStage.setScene(scene);
    }

    public void objectiveGoAddAlpha() throws IOException, InterruptedException {
        Scene scene = mainStage.getScene();

        List<Alpha> alphaList = new Gson().fromJson(connect.getAlphas(), new TypeToken<List<Alpha>>(){}.getType());
        ChoiceBox cardSelector = (ChoiceBox) scene.lookup("#objectiveSelector");
        Map<String, Alpha> alphaMap = new HashMap<>();

        for (Alpha alpha : alphaList){
            alphaMap.put(alpha.getAlpha() + " " + alpha.getId(), alpha);
        }

        Alpha chaseAlpha = alphaMap.get(cardSelector.getValue());

        GridPane gridPane = (GridPane) scene.lookup("#objectiveGrid");

        /**
         * make small alpha
         */
        Button alphaButton = new Button();
        alphaButton.setMaxWidth(80);
        alphaButton.setMaxHeight(100);
        alphaButton.setStyle("-fx-background-color: transparent");

        StackPane alphaPane = new StackPane();
        alphaPane.setPadding(new Insets(0, 0, 0, 0));
        alphaPane.maxWidth(80);
        alphaPane.maxHeight(100);
        alphaPane.setAlignment(Pos.TOP_LEFT);

        SVGPath alphaBack = new SVGPath();
        alphaBack.setContent("M10.856.606H142.201c5.343 0 9.644 4.301 9.644 9.644V196.756c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644V10.25c0-5.343 4.301-9.644 9.644-9.644z");
        alphaBack.setFill(Paint.valueOf("white"));
        alphaPane.getChildren().add(alphaBack);

        SVGPath alphaBanner = new SVGPath();
        alphaBanner.setContent("M10.856.606H141.595c5.343 0 9.644 4.301 9.644 9.644v20.416c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644v-20.416c0-5.343 4.301-9.644 9.644-9.644z");
        alphaBanner.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(1))));
        alphaPane.getChildren().add(alphaBanner);

        SVGPath alphaBorder = new SVGPath();
        alphaBorder.setContent("m142.177.041c4.859 0 8.791 3.93 8.791 8.788v188.286c0 4.859-3.931 8.788-8.791 8.788H8.834c-4.859 0-8.791-3.93-8.791-8.788V8.83c0-4.859 3.931-8.788 8.791-8.788zm0 1.185H8.834c-4.223 0-7.606 3.381-7.606 7.604v188.286c0 4.223 3.382 7.604 7.606 7.604H142.177c4.223 0 7.606-3.381 7.606-7.604V8.83c0-4.223-3.382-7.604-7.606-7.604z");
        alphaBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
        alphaPane.getChildren().add(alphaBorder);

        int stateBorderMargin = 45;
        for (State state : chaseAlpha.getStates()){
            SVGPath alphaStateBorder = new SVGPath();
            alphaStateBorder.setContent("m20.555 51.595c-5.63 0-10.18 4.55-10.18 10.18v1.321c0 5.63 4.55 10.18 10.18 10.18H132.199c5.63 0 10.18-4.55 10.18-10.18v-1.321c0-5.63-4.55-10.18-10.18-10.18zm0 1.071H132.199c5.055 0 9.108 4.054 9.108 9.109v1.321c0 5.055-4.053 9.108-9.108 9.108H20.555c-5.055 0-9.108-4.053-9.108-9.108v-1.321c0-5.055 4.053-9.109 9.108-9.109z");
            alphaStateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaStateBorder);
            StackPane.setMargin(alphaStateBorder, new Insets(stateBorderMargin, 0, 0, 10));

            Label alphaState = new Label();
            alphaState.setText(state.getName());
            alphaState.setStyle("-fx-font-style: Bold; -fx-font-size: 10");
            alphaPane.getChildren().add(alphaState);
            StackPane.setMargin(alphaState, new Insets(stateBorderMargin+5, 0, 0, 50));

            stateBorderMargin += 23;
        }

        SVGPath alphaSymbol = new SVGPath();
        if(!chaseAlpha.isCompetency()){
            alphaSymbol.setContent("m39.505 10.224c-2.59-.013-4.287.042-6.494.538-2.209.497-4.997 1.405-6.98 3.204-1.983 1.799-2.874 4.266-3.396 6.144-.522 1.878-.689 3.417-.458 6.252.23 2.834.769 7.155 2.872 10.011 2.104 2.858 5.549 3.728 9.107 4.177 3.558.449 7.443.499 11.425.385 3.982-.113 8.541-.478 12.063-5.061 1.42-1.846 2.642-4.403 3.794-7.22 1.05 2.832 2.059 5.571 3.217 8.655l1.805-.678c-1.427-3.801-2.738-7.33-3.958-10.649 1.286-3.534 2.48-7.411 3.676-11.333l-1.844-.565c-.952 3.12-1.939 6.06-2.932 8.949-1.316-3.652-2.3-6.584-4.292-8.648-2.054-2.125-4.969-3.067-8.191-3.572-3.222-.505-6.823-.578-9.413-.589zm-.009 1.929c2.56.013 6.091.092 9.123.567 3.031.475 5.491 1.34 7.104 3.008 1.613 1.668 2.595 4.432 3.979 8.26.206 .57.514 1.376.738 1.985-1.356 3.627-2.779 6.717-4.325 8.726-3.08 4.006-6.659 4.196-10.589 4.308-3.929.113-7.729.06-11.129-.37-3.4-.43-6.182-1.216-7.796-3.408-1.614-2.191-2.282-6.309-2.504-9.023-.222-2.716-.087-3.84.395-5.578.483-1.738 1.298-3.842 2.832-5.233 1.534-1.391 4.071-2.292 6.106-2.75 2.037-.458 3.502-.503 6.062-.492z");
            alphaSymbol.setScaleX(.7);
            alphaSymbol.setScaleY(.7);
            alphaSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaSymbol);
            StackPane.setMargin(alphaSymbol, new Insets(5, 0, 0, 5));
        }else {
            alphaSymbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
            alphaSymbol.setScaleX(.7);
            alphaSymbol.setScaleY(.7);
            alphaSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            alphaPane.getChildren().add(alphaSymbol);
            StackPane.setMargin(alphaSymbol, new Insets(5, 0, 0, 8));
        }

        Label alphaAlpha = new Label();
        alphaAlpha.setText(chaseAlpha.getAlpha());
        alphaAlpha.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
        alphaPane.getChildren().add(alphaAlpha);
        StackPane.setMargin(alphaAlpha, new Insets(7, 0, 0, 50));

        GridPane.setConstraints(alphaButton, gridxPos, gridyPos);
        GridPane.setRowIndex(alphaButton, gridyPos);

        alphaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        alphaButton.setGraphic(alphaPane);
        alphaButton.setPadding( new Insets( 0, 0, 0, 0));

        gridPane.getChildren().add(alphaButton);
        gridxPos += 3;

        /**
         * make states
         */

        for (State state : chaseAlpha.getStates()){
            Button button = new Button();
            button.setMaxWidth(80);
            button.setMaxHeight(100);
            button.setStyle("-fx-background-color: transparent");

            StackPane statePane = new StackPane();
            statePane.setPadding(new Insets(0, 0, 0, 0));
            statePane.maxWidth(80);
            statePane.maxHeight(100);
            statePane.setAlignment(Pos.TOP_LEFT);

            SVGPath stateBack = new SVGPath();
            stateBack.setContent("M10.856.606H142.201c5.343 0 9.644 4.301 9.644 9.644V196.756c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644V10.25c0-5.343 4.301-9.644 9.644-9.644z");
            stateBack.setFill(Paint.valueOf("white"));
            statePane.getChildren().add(stateBack);

            SVGPath stateBanner = new SVGPath();
            stateBanner.setContent("M10.856.606H141.595c5.343 0 9.644 4.301 9.644 9.644v20.416c0 5.343-4.301 9.644-9.644 9.644H10.856c-5.343 0-9.644-4.301-9.644-9.644v-20.416c0-5.343 4.301-9.644 9.644-9.644z");
            stateBanner.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(1))));
            statePane.getChildren().add(stateBanner);

            SVGPath stateBorder = new SVGPath();
            stateBorder.setContent("m142.177.041c4.859 0 8.791 3.93 8.791 8.788v188.286c0 4.859-3.931 8.788-8.791 8.788H8.834c-4.859 0-8.791-3.93-8.791-8.788V8.83c0-4.859 3.931-8.788 8.791-8.788zm0 1.185H8.834c-4.223 0-7.606 3.381-7.606 7.604v188.286c0 4.223 3.382 7.604 7.606 7.604H142.177c4.223 0 7.606-3.381 7.606-7.604V8.83c0-4.223-3.382-7.604-7.606-7.604z");
            stateBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateBorder);

            SVGPath stateNameBorder = new SVGPath();
            stateNameBorder.setContent("m20.555 51.595c-5.63 0-10.18 4.55-10.18 10.18v1.321c0 5.63 4.55 10.18 10.18 10.18H132.199c5.63 0 10.18-4.55 10.18-10.18v-1.321c0-5.63-4.55-10.18-10.18-10.18zm0 1.071H132.199c5.055 0 9.108 4.054 9.108 9.109v1.321c0 5.055-4.053 9.108-9.108 9.108H20.555c-5.055 0-9.108-4.053-9.108-9.108v-1.321c0-5.055 4.053-9.109 9.108-9.109z");
            stateNameBorder.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
            statePane.getChildren().add(stateNameBorder);
            StackPane.setMargin(stateNameBorder, new Insets(45, 0, 0, 10));

            SVGPath stateSymbol = new SVGPath();
            if(!chaseAlpha.isCompetency()){
                stateSymbol.setContent("m39.505 10.224c-2.59-.013-4.287.042-6.494.538-2.209.497-4.997 1.405-6.98 3.204-1.983 1.799-2.874 4.266-3.396 6.144-.522 1.878-.689 3.417-.458 6.252.23 2.834.769 7.155 2.872 10.011 2.104 2.858 5.549 3.728 9.107 4.177 3.558.449 7.443.499 11.425.385 3.982-.113 8.541-.478 12.063-5.061 1.42-1.846 2.642-4.403 3.794-7.22 1.05 2.832 2.059 5.571 3.217 8.655l1.805-.678c-1.427-3.801-2.738-7.33-3.958-10.649 1.286-3.534 2.48-7.411 3.676-11.333l-1.844-.565c-.952 3.12-1.939 6.06-2.932 8.949-1.316-3.652-2.3-6.584-4.292-8.648-2.054-2.125-4.969-3.067-8.191-3.572-3.222-.505-6.823-.578-9.413-.589zm-.009 1.929c2.56.013 6.091.092 9.123.567 3.031.475 5.491 1.34 7.104 3.008 1.613 1.668 2.595 4.432 3.979 8.26.206 .57.514 1.376.738 1.985-1.356 3.627-2.779 6.717-4.325 8.726-3.08 4.006-6.659 4.196-10.589 4.308-3.929.113-7.729.06-11.129-.37-3.4-.43-6.182-1.216-7.796-3.408-1.614-2.191-2.282-6.309-2.504-9.023-.222-2.716-.087-3.84.395-5.578.483-1.738 1.298-3.842 2.832-5.233 1.534-1.391 4.071-2.292 6.106-2.75 2.037-.458 3.502-.503 6.062-.492z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 5));
            }else {
                stateSymbol.setContent("m54.07 3.02-7.96 15.953-17.654 2.488 12.713 12.499-3.089 17.557 15.817-8.228 15.745 8.363-.418-2.493L66.703 34.07 79.522 21.681 61.889 19.042Zm-.025 5.639 6.178 12.656 13.928 2.084-10.127 9.787 2.32 13.891-12.436-6.606-12.494 6.5 2.441-13.869-10.042-9.873 13.945-1.966z");
                stateSymbol.setScaleX(.7);
                stateSymbol.setScaleY(.7);
                stateSymbol.setFill(Paint.valueOf(String.valueOf(colors.get(chaseAlpha.getColor()).get(0))));
                statePane.getChildren().add(stateSymbol);
                StackPane.setMargin(stateSymbol, new Insets(5, 0, 0, 8));
            }

            int checklistTopMargin = 68;
            for (CheckListItem checkListItem: state.getChecklist()){
                Label item = new Label();
                item.setText(checkListItem.getChecklistitem());
                item.setStyle("-fx-font-style: Bold; -fx-font-size: 10");
                statePane.getChildren().add(item);
                StackPane.setMargin(item, new Insets(checklistTopMargin, 0, 0, 15));
                checklistTopMargin += 12;
            }
            checklistTopMargin = 68;

            Label stateAlpha = new Label();
            stateAlpha.setText(chaseAlpha.getAlpha());
            stateAlpha.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateAlpha);
            StackPane.setMargin(stateAlpha, new Insets(7, 0, 0, 50));

            Label stateName = new Label();
            stateName.setText(state.getName());
            stateName.setStyle("-fx-font-style: Bold; -fx-font-size: 16");
            statePane.getChildren().add(stateName);
            StackPane.setMargin(stateName, new Insets(42, 0, 0, 50));

            GridPane.setConstraints(button, gridxPos, gridyPos);
            GridPane.setRowIndex(button, gridyPos);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(GridPane.getColumnIndex(button) > state.getStateOrder()){
                        GridPane.setColumnIndex(button, GridPane.getColumnIndex(button)-1);
                    }
                }
            });

            button.setGraphic(statePane);
            button.setPadding( new Insets( 0, 0, 0, 0));

            gridPane.getChildren().add(button);
            gridxPos += 1;
        }
        gridxPos = 0;
        gridyPos += 1;

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

    public void showNameInvalid(String reason) throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Name invalid");
        alert.setContentText(reason);

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


    //Alpha Svg
    //m 13.236328,0.00195313 c -7.306067,0 -13.2285155,5.92244817 -13.2285155,13.22851587 V 432.05859 c 0,7.30607 5.9224482,13.22852 13.2285155,13.22852 H 639.23047 c 7.30606,0 13.22851,-5.92245 13.22851,-13.22852 V 13.230469 c 0,-7.306068 -5.92245,-13.22851587 -13.22851,-13.22851587 z m 0,2.64453127 H 639.23047 c 5.88604,0 10.58203,4.6979401 10.58203,10.5839846 V 432.05859 c 0,5.88605 -4.69599,10.58399 -10.58203,10.58399 H 13.236328 c -5.8860438,0 -10.5820311,-4.69794 -10.5820311,-10.58399 V 13.230469 c 0,-5.8860449 4.695987,-10.5839846 10.5820311,-10.5839846 z
    //Alpha stat border
    //m 31.75,77.224609 c -7.306068,0 -13.228516,5.924401 -13.228516,13.230469 v 18.355472 c 0,7.30606 5.922448,13.22851 13.228516,13.22851 h 252.3457 c 7.30608,0 13.23047,-5.92245 13.23047,-13.22851 V 90.455078 c 0,-7.306067 -5.92439,-13.230469 -13.23047,-13.230469 z m 0,2.646485 h 252.3457 c 5.88606,0 10.58399,4.697938 10.58399,10.583984 v 18.355472 c 0,5.88604 -4.69793,10.58203 -10.58399,10.58203 H 31.75 c -5.886045,0 -10.583984,-4.69599 -10.583984,-10.58203 V 90.455078 c 0,-5.886045 4.697939,-10.583984 10.583984,-10.583984 z
    //Alpha Banner
    //M 13.249837,1.3306681 H 639.22835 c 6.59607,0 11.90625,5.3101875 11.90625,11.9062499 v 38.205967 c 0,6.596063 -5.31018,11.90625 -11.90625,11.90625 H 13.249837 c -6.5960622,0 -11.9062497,-5.310187 -11.9062497,-11.90625 V 13.236918 c 0,-6.5960624 5.3101875,-11.9062499 11.9062497,-11.9062499 z
    //Alpha back
    //M 12.446792,0.64408761 H 640.02104 c 6.55135,0 11.82554,5.27419489 11.82554,11.82554939 V 432.69513 c 0,6.55135 -5.27419,11.82554 -11.82554,11.82554 H 12.446792 c -6.5513543,0 -11.82554918,-5.27419 -11.82554918,-11.82554 V 12.469637 c 0,-6.5513545 5.27419488,-11.82554939 11.82554918,-11.82554939 z

    //SVG for wide card
    // M 13.353516,0.125 C 6.0474485,0.125 0.125,6.0474484 0.125,13.353516 V 432.07031 c 0,7.30607 5.9224482,13.22852 13.228516,13.22852 H 639.24219 c 7.30607,0 13.22851,-5.92245 13.22851,-13.22852 V 13.353516 C 652.4707,6.0474494 646.54826,0.125 639.24219,0.125 Z m 0,2.6445313 H 639.24219 c 5.88605,0 10.58398,4.6979389 10.58398,10.5839847 V 432.07031 c 0,5.88605 -4.69793,10.58399 -10.58398,10.58399 H 13.353516 c -5.8860443,0 -10.5839847,-4.69795 -10.5839847,-10.58399 V 13.353516 c 0,-5.8860448 4.6979401,-10.5839847 10.5839847,-10.5839847 z
    //SVG for small card
    //m 18.197511,-0.85351563 c -10.5315547,0 -19.05102662,8.51652803 -19.05102663,19.04625363 V 426.24804 c 10e-9,10.52973 8.51947193,19.04625 19.05102663,19.04625 H 307.18036 c 10.53155,0 19.05103,-8.51652 19.05103,-19.04625 V 18.192738 c 0,-10.5297263 -8.51948,-19.04625363 -19.05103,-19.04625363 z m 0,2.56763903 H 307.18036 c 9.15317,0 16.48294,7.3270255 16.48294,16.4786146 V 426.24804 c 0,9.15159 -7.32977,16.47861 -16.48294,16.47861 H 18.197511 c -9.1531796,0 -16.4829417,-7.32702 -16.4829417,-16.47861 V 18.192738 c 0,-9.1515898 7.3297621,-16.4786146 16.4829417,-16.4786146 z

}