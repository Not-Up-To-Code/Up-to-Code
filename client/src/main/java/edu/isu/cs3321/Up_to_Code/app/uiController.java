package edu.isu.cs3321.Up_to_Code.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;

public class uiController {
    private ui app;

    public uiController(ui app){
        this.app = app;
    }

    @FXML
    public void homeButton(ActionEvent event) throws IOException{
        app.showHome();
    }

    @FXML
    public void practiceCatalogButton(ActionEvent event) throws IOException{
        app.showPracticeCatalog();
    }

    @FXML
    public void createPracticesButton(ActionEvent event) throws IOException{
        app.showPracticeCreator();
    }

    @FXML
    public void cardCatalogButton(ActionEvent event) throws IOException{
        app.showCardCatalog();
    }

    @FXML
    public void createCardsButton(ActionEvent event) throws IOException{
        app.showCardCreator();
    }

    @FXML
    public void playProgressPokerButton(ActionEvent event) throws IOException{
        app.showProgressPoker();
    }

    @FXML
    public void playChaseTheStateButton(ActionEvent event) throws IOException{
        app.showChaseTheState();
    }

    @FXML
    public void playObjectiveGoButton(ActionEvent event) throws IOException{
        app.showObjectiveGo();
    }

    @FXML
    public void playCheckpointConstruction(ActionEvent event) throws IOException{
        app.showCheckpointConstruction();
    }

    @FXML
    public void updateCardButton(ActionEvent event) throws IOException{
        app.updateCard();
    }
}
