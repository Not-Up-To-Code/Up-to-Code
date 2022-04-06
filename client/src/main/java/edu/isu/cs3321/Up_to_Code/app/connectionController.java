package edu.isu.cs3321.Up_to_Code.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;

public class connectionController {
    private ui app;

    @FXML
    TextField uri;
    @FXML
    TextField port;

    public connectionController(ui app){
        this.app = app;
    }

    @FXML
    protected void connectButton(ActionEvent event) throws IOException {
        if (uri.getText().isEmpty()){
            app.showRequired();
            return;
        }

        connection connect = connection.instance();
        connect.initialize(uri.getText(), port.getText());

        System.out.println(connect.initilized);
        System.out.println(connect.test());

        if (connect.initilized && connect.test()){
            try {
                app.showHome();
            } catch (IOException exception){
                app.showError();
            }
        }
        else {
            app.showFailedConnection();
        }
    }
}
