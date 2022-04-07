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


    //Menu buttons ============================================
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

    //Card creator buttons ========================================
    @FXML
    public void updateCardButton(ActionEvent event) throws IOException{
        app.updateCard();
    }

    @FXML
    public void showWideCardButton(ActionEvent event) throws IOException{
        app.showWideCard();
        app.wideCardToJson();
    }
    @FXML
    public void hideWideCardButton(ActionEvent event) throws IOException{
        app.hideWideCard();
    }


}
