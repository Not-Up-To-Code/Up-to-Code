package edu.isu.cs3321.Up_to_Code.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class CardView extends Application {
    Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView Experiment 1");

        ListView<String> listView = new ListView<String>();

        listView.getItems().add("card.png");
        listView.getItems().add("New.png");
        listView.getItems().add("alpha.png");


        Button button = new Button("Read Selected Value");
        ImageView imageView = new ImageView();
        imageView.setX(10000);
        imageView.setY(50);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        button.setOnAction(event -> {
            ObservableList<String> selectedIndices = listView.getSelectionModel().getSelectedItems();

            for (Object o : selectedIndices) {
                System.out.println(o);
                //creating the image object
                InputStream stream = null;
                try {
                    stream = new FileInputStream((String) o);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image image = new Image(stream);
                //Creating the image view

                //Setting image to the image view
                imageView.setImage(image);
                //Setting the image view parameters

                //Setting the Scene object
                //Group root = new Group(imageView);
                primaryStage.setTitle("Displaying Image");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });


        VBox vBox = new VBox(listView, button,imageView);

        scene = new Scene(vBox, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}