// MIT License

// Copyright (c) 2022 Thomas Evans, Benjamin Keninger, Sina Khajeh Pour, Braxton Soto

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

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
