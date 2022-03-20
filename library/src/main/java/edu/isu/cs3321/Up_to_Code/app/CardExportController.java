package edu.isu.cs3321.Up_to_Code.app;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardExportController implements Initializable {

    @FXML
    private ImageView display;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void doTakeScreenShot(ActionEvent event) throws AWTException, IOException {
        Robot robot=new Robot();
        Rectangle rectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image=robot.createScreenCapture(rectangle);
        Image myImage= SwingFXUtils.toFXImage(image,null);
        ImageIO.write(image,"png",new File("out.png"));

        display.setImage(myImage);
    }
}
