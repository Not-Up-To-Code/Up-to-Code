package edu.isu.cs3321.Up_to_Code.app;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class Example {

    public void cardTemplate(Graphics2D g2d){
        int h = 1000;
        int w = 1000;
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, w, h);

        RenderingHints rh=new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);



        graphics2D.setColor(new Color(0xFFEFE58B, true));
        graphics2D.fillRoundRect(100, 200, 750, 80,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(100, 200, 750, 530,30,30);
    }

    public static final HashMap<String,String> cardSymbols = new HashMap<>(){{
        put("Alpha", "m 54.189453,14.023438 c -3.551127,-0.01733 -5.87912,0.05722 -8.908203,0.738281 -3.029104,0.681061 -6.854586,1.927454 -9.574219,4.394531 -2.719637,2.467081 -3.942639,5.851619 -4.658203,8.427734 -0.71556,2.576101 -0.945638,4.687766 -0.628906,8.576172 0.316731,3.888394 1.053524,9.813293 3.939453,13.732422 2.885894,3.919081 7.612935,5.113988 12.492187,5.730469 4.879242,0.616479 10.21018,0.683401 15.671875,0.527344 5.461693,-0.156057 11.715279,-0.655919 16.548829,-6.941407 1.947326,-2.532279 3.623602,-6.040319 5.203125,-9.904297 1.439404,3.884529 2.823201,7.64147 4.412109,11.871094 l 2.476562,-0.929687 c -1.95835,-5.21307 -3.756769,-10.055487 -5.429687,-14.607422 1.763436,-4.848647 3.401317,-10.166807 5.042969,-15.546875 l -2.529297,-0.773438 c -1.305941,4.279865 -2.660786,8.312388 -4.021485,12.275391 -1.80555,-5.009618 -3.153121,-9.031834 -5.888671,-11.861328 -2.817787,-2.914554 -6.81571,-4.20795 -11.236329,-4.900391 -4.42064,-0.692444 -9.360985,-0.791263 -12.912109,-0.808593 z m -0.01172,2.646484 c 3.511426,0.01714 8.355915,0.126077 12.513672,0.777344 4.157779,0.65127 7.532274,1.837173 9.744141,4.125 2.211923,2.287884 3.559593,6.080872 5.458984,11.330078 0.282987,0.782069 0.706237,1.888645 1.011719,2.722656 -1.85966,4.975319 -3.812146,9.214539 -5.931641,11.970703 -4.226856,5.496551 -9.134961,5.756136 -14.52539,5.910156 -5.390427,0.154021 -10.60192,0.08143 -15.265625,-0.507812 -4.663694,-0.589246 -8.480231,-1.668371 -10.69336,-4.673828 -2.213093,-3.00541 -3.130143,-8.653546 -3.433593,-12.378907 -0.30345,-3.725347 -0.119505,-5.267361 0.542968,-7.652343 0.662469,-2.384968 1.780992,-5.269325 3.884766,-7.177735 2.103779,-1.908413 5.583709,-3.143453 8.376953,-3.771484 2.793266,-0.628036 4.804985,-0.690965 8.316406,-0.673828 z");
        put("Competency", "m 60.077127,3.356555 -8.843143,17.725284 -19.61502,2.763922 14.125631,13.887857 -3.432832,19.508861 17.573086,-9.142122 17.493467,9.292695 -0.46309,-2.770965 L 74.113388,37.855484 88.357637,24.089493 68.766991,21.157125 Z m -0.02709,6.2655406 6.864581,14.0617184 15.475366,2.316539 -11.251759,10.874244 2.578686,15.433119 -13.818517,-7.34067 -13.881358,7.222052 2.711385,-15.41091 -11.158599,-10.970654 15.494864,-2.183299 z");
    }};

    public static void main(String[] args) throws IOException {



        int h = 1000;
        int w = 1000;
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, w, h);

        RenderingHints rh=new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);



        graphics2D.setColor(new Color(0xFFEFE58B, true));
        graphics2D.fillRoundRect(100, 200, 750, 80,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(100, 200, 750, 530,30,30);
//==================================================================
        //States rectangle

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,300,330,50,20,20);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,370,330,50,20,20);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,440,330,50,20,20);


        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,510,330,50,20,20);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,580,330,50,20,20);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(120,650,330,50,20,20);
//======================================================================
        // states string

        //System.out.println(cardSymbols));


        graphics2D.setColor(Color.black);
        graphics2D.drawString("State1",260,330);

        graphics2D.setColor(Color.black);
        graphics2D.drawString("State2",260,400);

        graphics2D.setColor(Color.black);
        graphics2D.drawString("State3",260,470);

        graphics2D.setColor(Color.black);
        graphics2D.drawString("State4",260,540);

        graphics2D.setColor(Color.black);
        graphics2D.drawString("State5",260,610);

        graphics2D.setColor(Color.black);
        graphics2D.drawString("State6",260,680);

        //=========================================================
        //brief description

        graphics2D.setColor(Color.black);
        graphics2D.drawString("Add a brief description",500,310);

        //=========================================================
        //detail

        graphics2D.setColor(Color.black);
        String te="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        graphics2D.drawString("Add a detailed description",500,435);

        //=============================================================
        //alpha
        graphics2D.setColor(Color.black);
        //String te="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        //=============================================================
        //cardname
        graphics2D.setColor(Color.black);
        graphics2D.drawString("Card Name",250,240);




        graphics2D.setColor(Color.black);





        graphics2D.dispose();
        File file=new File("card.png");
        ImageIO.write(bufferedImage,"png",file);
    }
}
