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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.checkerframework.checker.units.qual.A;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class uiController {
    private ui app;

    DraggableMaker draggableMaker = new DraggableMaker();

    ArrayList<Node> components = new ArrayList<>();

    @FXML
    private AnchorPane practiceAnchor;


    public uiController(ui app){
        this.app = app;
    }


    //Menu buttons ============================================
    @FXML
    public void homeButton(ActionEvent event) throws IOException{
        app.showHome();
    }

    @FXML
    public void practiceCatalogButton(ActionEvent event) throws IOException, InterruptedException {
        app.showPracticeCatalog();
    }

    @FXML
    public void createPracticesButton(ActionEvent event) throws IOException{
        app.showPracticeCreator();
    }

    @FXML
    public void cardCatalogButton(ActionEvent event) throws IOException, InterruptedException {
        app.showCardCatalog();
    }

    @FXML
    public void createCardsButton(ActionEvent event) throws IOException{
        app.showCardCreator();
    }

    @FXML
    public void playProgressPokerButton(ActionEvent event) throws IOException, InterruptedException {
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

    /**
     * buttons used in the card creator
     * @param event
     * @throws IOException
     */
    @FXML
    public void updateCardButton(ActionEvent event) throws IOException{
        app.updateCard();
    }
    @FXML
    public void showWideCardButton(ActionEvent event) throws IOException{
        app.hideStateCard();
        app.showAlphaCard();
    }
    @FXML
    public void hideWideCardButton(ActionEvent event) throws IOException{
        app.hideAlphaCard();
        app.updateCard();
        app.showStateCard();

    }
    @FXML
    public void saveCardButton(ActionEvent event) throws IOException, InterruptedException{
        app.updateCard();
        app.cardToJson();
    }

    /**
     * Buttons used for Progress Poker
     */
    @FXML
    public void pokerStartButton(ActionEvent event) throws IOException, InterruptedException {
        app.startPokerDiscussion();
    }
    @FXML
    public void pokerEndButton(ActionEvent event) throws IOException, InterruptedException {
        app.endPokerDiscussion();
    }

    /**
     * Controlls for practice maker
     */
    public void addAlpha() throws IOException {
        AnchorPane alpha = new AnchorPane();
        alpha = FXMLLoader.load(getClass().getResource("/alpha.fxml"));
        practiceAnchor.getChildren().add(alpha);
        draggableMaker.makeDraggable(alpha);
        components.add(alpha);
    }

    public void addActivity() throws IOException {
        AnchorPane activity = new AnchorPane();
        activity = FXMLLoader.load(getClass().getResource("/activity.fxml"));
        practiceAnchor.getChildren().add(activity);
        draggableMaker.makeDraggable(activity);
        components.add(activity);
    }

    public void addCompetency() throws IOException {
        AnchorPane competency = new AnchorPane();
        competency = FXMLLoader.load(getClass().getResource("/competency.fxml"));
        practiceAnchor.getChildren().add(competency);
        draggableMaker.makeDraggable(competency);
        components.add(competency);
    }

    public void addWork() throws IOException {
        AnchorPane product = new AnchorPane();
        product = FXMLLoader.load(getClass().getResource("/product.fxml"));
        practiceAnchor.getChildren().add(product);
        draggableMaker.makeDraggable(product);
        components.add(product);
    }

    public void addLineLeft() throws IOException {
        AnchorPane lineLeftDiagonal = new AnchorPane();
        lineLeftDiagonal = FXMLLoader.load(getClass().getResource("/lineLeftDiagonal.fxml"));
        practiceAnchor.getChildren().add(lineLeftDiagonal);
        draggableMaker.makeDraggable(lineLeftDiagonal);
        components.add(lineLeftDiagonal);
    }

    public void addLineRight() throws IOException {
        AnchorPane lineRightDiagonal = new AnchorPane();
        lineRightDiagonal = FXMLLoader.load(getClass().getResource("/lineRightDiagonal.fxml"));
        practiceAnchor.getChildren().add(lineRightDiagonal);
        draggableMaker.makeDraggable(lineRightDiagonal);
        components.add(lineRightDiagonal);
    }

    public void addLineHorizontal() throws IOException {
        AnchorPane lineHorizontal = new AnchorPane();
        lineHorizontal = FXMLLoader.load(getClass().getResource("/lineHorizontal.fxml"));
        practiceAnchor.getChildren().add(lineHorizontal);
        draggableMaker.makeDraggable(lineHorizontal);
        components.add(lineHorizontal);
    }

    public void addLineVertical() throws IOException {
        AnchorPane lineVertical = new AnchorPane();
        lineVertical = FXMLLoader.load(getClass().getResource("/lineVertical.fxml"));
        practiceAnchor.getChildren().add(lineVertical);
        draggableMaker.makeDraggable(lineVertical);
        components.add(lineVertical);
    }

    public void newDiagram() throws IOException{
        for(Node node: components){
            practiceAnchor.getChildren().remove(node);
        }
        components.removeAll(components);
    }

    public double getY(){
        double max = 0;
        for(Node node: components){
            if((node.getLayoutY() + node.getBoundsInParent().getHeight()) > max){
                max = node.getLayoutY() + node.getBoundsInParent().getHeight();
            }
        }
        return max;
    }

    public double getX(){
        double max = 0;
        for(Node node: components){
            if((node.getLayoutX() + node.getBoundsInParent().getWidth()) > max){
                max = node.getLayoutX() + node.getBoundsInParent().getWidth();
            }
        }
        return max;
    }

    public void exportDiagram() throws IOException, InterruptedException {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.getDialogPane().setContentText("Save image as:");
        Optional<String> result = inputDialog.showAndWait();

        List<String> imgNames = new Gson().fromJson(app.getConnect().getPractices(), new TypeToken<List<String>>(){}.getType());
        Boolean isMatch = false;

        if (result.isPresent() && !result.get().trim().isEmpty()) {
            for(String name : imgNames){
                System.out.println(result.get()+ ".png");
                System.out.println(name);
                if ((result.get() + ".png").equals(name)){
                    isMatch = true;
                }
                System.out.println(isMatch);
            }
            if (isMatch == true){
                app.showNameInvalid("A practice with that name already exists.");
            }
            else if(isMatch == false){
                TextField userInput = inputDialog.getEditor();
                Group root = new Group();
                for (Node node : components) {
                    root.getChildren().add(node);
                }
                Scene scene = new Scene(root, getX() + 10, getY() + 10);
                WritableImage imgReturn = scene.snapshot(null);
                File file = new File("tempPractices/" + userInput.getText() + ".png");
                ImageIO.write(SwingFXUtils.fromFXImage(imgReturn, null), "png", file);
                for (Node node : components) {
                    practiceAnchor.getChildren().add(node);
                }
                app.savePractice(file);
                file.delete();
            }
        }else {
            app.showNameInvalid("Name can not be empty.");
        }
        isMatch = false;
    }
}