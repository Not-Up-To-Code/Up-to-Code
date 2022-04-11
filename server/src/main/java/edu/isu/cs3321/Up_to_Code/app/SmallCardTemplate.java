package edu.isu.cs3321.Up_to_Code.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SmallCardTemplate {
    public void smallCardTemplate(String state,String cardName,String[] checklist,int currentState,int totalState,int cardColor) throws IOException {
        int y=180;
        int h = 600;
        int w = 450;
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRoundRect(0, 0, w, h,30,30);

        RenderingHints rh=new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);

        //graphics2D.setColor(new Color(0xFFEFE58B, true));

        graphics2D.setColor(new Color(cardColor, true));
        graphics2D.fillRoundRect(0, 0, w, 100,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(0, 0, w-1, h-2,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(25, 110, 400, 70,30,30);

        graphics2D.setColor(Color.orange);
        graphics2D.fillRoundRect(25, 510, 400, 30,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(25, 510, 400, 30,30,30);

        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 35));
        graphics2D.drawString(cardName,100,55);

        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 25));
        graphics2D.drawString(state,120,155);

        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 15));
        //graphics2D.drawString(Arrays.toString(checklist),30,205);
        for (String line : Arrays.toString(checklist).split("\n"))
            graphics2D.drawString( " □ "+line, 30, y += 4+graphics2D.getFontMetrics().getHeight());


        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 18));
        graphics2D.drawString(String.valueOf(currentState)+" / "+String.valueOf(totalState),200,530);

        //Alpha
        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 68));
        graphics2D.drawString("\u03B1",40,60);

        //competency
        //graphics2D.drawString("☆",40,60);


        graphics2D.dispose();
        File file=new File(cardName+" smallcard.png");
        ImageIO.write(bufferedImage,"png",file);


    }
    /*
    public static void main(String[] args) throws IOException {
        String[] example={"Architecture selection criteria agreed\nHW platforms identified\nTechnologies selected\nSystem boundary known\nDecisions on system organization\nmade\nBuy,build,reuse decisions made\nKey technical risks agreed to"};
        new SmallCardTemplate().smallCardTemplate("Architecture Selected","Software System",example,1,6,Color.orange.getRGB());

    }

     */

}
