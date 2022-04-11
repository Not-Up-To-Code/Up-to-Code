package edu.isu.cs3321.Up_to_Code.app;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.awt.image.renderable.RenderableImage;
import java.io.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Testing {
    public void cardTemplate() throws IOException {
        //canvas
        int h = 1000;
        int w = 1000;
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, w, h);
        //==============================================================================================================
        //png smothing
        RenderingHints rh=new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);
        //==============================================================================================================


        //Card Color
        graphics2D.setColor(new Color(0xFFEFE58B, true));
        graphics2D.setColor(new Color(0xFF97FA97, true));
        graphics2D.setColor(new Color(0xFFAFDFE5, true));

        graphics2D.fillRoundRect(100, 200, 750, 80,30,30);
        //==============================================================================================================

        //Border Color
        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(100, 200, 750, 530,30,30);
        //==============================================================================================================

        graphics2D.dispose();
        File file=new File("card.png");
        ImageIO.write(bufferedImage,"png",file);
    }

    public static void main(String[] args) throws IOException {
        Testing t=new Testing();
        t.cardTemplate();
    }

}