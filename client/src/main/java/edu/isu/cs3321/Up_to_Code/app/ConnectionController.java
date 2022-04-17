package edu.isu.cs3321.Up_to_Code.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ConnectionController {
    private ui app;

    @FXML
    TextField uri;
    @FXML
    TextField port;

    public ConnectionController(ui app){
        this.app = app;
    }

    @FXML
    protected void connectButton(ActionEvent event) throws IOException {
        if (uri.getText().isEmpty()){
            app.showRequired();
            return;
        }

        Connection connect = Connection.instance();
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