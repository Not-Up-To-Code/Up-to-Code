package edu.isu.cs3321.Up_to_Code.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs3321.Up_to_Code.app.DatabaseManagement.getAlphas;
import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.clientAlphaList;

public class StatesExport {
    static int y = 180;
    static int h = 600;
    static int w = 450;
    static Color color;
    static BufferedImage bufferedImage;
    static Graphics2D graphics2D;
    static RenderingHints rh;
    static File file;
    public static void smallCardTemplate(Alpha alpha, Integer id) throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException{
        try {
            Field field = Class.forName("java.awt.Color").getField(alpha.getColor());
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }

        List<Alpha> a1 = clientAlphaList(getAlphas());
        //===========================================================================================================
        for(Alpha eachalpha:a1){
            if(eachalpha.getId()==id){
                //if(eachalpha.getId()==alpha.getId()){

                for(State state : eachalpha.getStates()){
                    bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                    graphics2D = bufferedImage.createGraphics();
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.fillRoundRect(0, 0, w, h, 30, 30);

                    rh = new RenderingHints(
                            RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    graphics2D.setRenderingHints(rh);

                    graphics2D.setColor(color);
                    graphics2D.fillRoundRect(0, 0, w, 100, 30, 30);

                    graphics2D.setColor(Color.red);
                    graphics2D.drawRoundRect(0, 0, w - 1, h - 2, 30, 30);

                    graphics2D.setColor(Color.red);
                    graphics2D.drawRoundRect(25, 110, 400, 70, 30, 30);

                    graphics2D.setColor(color);
                    graphics2D.fillRoundRect(25, 510, 400, 30, 30, 30);

                    graphics2D.setColor(Color.red);
                    graphics2D.drawRoundRect(25, 510, 400, 30, 30, 30);

                    graphics2D.setColor(Color.black);
                    graphics2D.setFont(new Font("Zapping", Font.PLAIN, 35));
                    graphics2D.drawString(alpha.getAlpha(), 100, 55);

                    graphics2D.setColor(Color.black);
                    graphics2D.setFont(new Font("Zapping", Font.PLAIN, 25));
                    graphics2D.drawString(state.getName(), 120, 155);

                    for (CheckListItem checkListItem :state.getChecklist()){
                        graphics2D.setColor(Color.black);
                        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 15));
                        graphics2D.drawString(" □ " + checkListItem, 30, y += 4 + graphics2D.getFontMetrics().getHeight());
                    }

                    graphics2D.setColor(Color.black);
                    graphics2D.setFont(new Font("Zapping", Font.PLAIN, 18));
                    graphics2D.drawString(state.getStateOrder() + " / " +eachalpha.getStates().size()+1, 200, 530);

                    graphics2D.dispose();
                    file = new File("tempCards/" + alpha.getAlpha() + state.getName() + ".png");
                    ImageIO.write(bufferedImage, "png", file);
                }
            }
        }
    }
}
