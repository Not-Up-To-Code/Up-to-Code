package edu.isu.cs3321.Up_to_Code.app;

import org.checkerframework.checker.units.qual.C;

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

public class AlphaExport {
    static int y=110;
    static int yline=200;
    static int yline1=100;
    static int h = 550;
    static int w = 750;
    static Color color;
    static BufferedImage bufferedImage;
    static Graphics2D graphics2D;
    static RenderingHints rh;
    static File file;
    public static void cardTemplate(Alpha alpha,Integer id) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        try {
            Field field = Class.forName("java.awt.Color").getField(alpha.getColor());
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }

        bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRoundRect(0, 0, w, h,30,30);

        rh=new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHints(rh);

        //graphics2D.setColor(new Color(0xFFEFE58B, true));

        graphics2D.setColor(color);
        graphics2D.fillRoundRect(0, 0, w, 80,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(0, 0, w-1, h-2,30,30);

        //States rectangle and their description
        // passed in id number to look for
        List<Alpha> a1 = clientAlphaList(getAlphas());
        for (Alpha test : a1){
            System.out.println("=======");
            System.out.println(test.getStates().get(0).getChecklist().size());
            // if (a.getId() == alpha.getId()){
            if(test.getId()==id)
                for(int i=0;i<test.getStates().size();i++){
                    //for(String s: test.){
                    if(test.getStates().get(i).getName() != null){
                        graphics2D.setColor(Color.red);
                        graphics2D.drawRoundRect(50,y,330,50,20,20);
                        graphics2D.setColor(Color.black);
                        graphics2D.drawString(test.getStates().get(i).getName(),150,y+30);
                        y=y+70;}}
        }

        //brief description
        graphics2D.setColor(Color.black);
        for (String line : alpha.getBriefDesc().split("\n"))
            graphics2D.drawString( line, 420, yline1 += 4+graphics2D.getFontMetrics().getHeight());
        graphics2D.drawLine(420,yline1+6,700,yline1+6);
        //graphics2D.drawString(briefD,420,100);

        //detailed description
        graphics2D.setColor(Color.black);
        for (String line : alpha.getDetailedDesc().split("\n"))
            graphics2D.drawString( " * "+line, 420, yline += 4+graphics2D.getFontMetrics().getHeight());
        //graphics2D.drawString(detailedD,420,245);


        //cardname
        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 35));
        graphics2D.drawString(alpha.getAlpha(),130,55);

        //Alpha
        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 68));

        //alpha
        graphics2D.drawString("\u03B1",40,60);
        //competency
        //graphics2D.drawString("☆",40,60);

        graphics2D.dispose();
        file=new File("tempCards/" + alpha.getAlpha()+"widecard.png");
        ImageIO.write(bufferedImage,"png",file);
    }
}
