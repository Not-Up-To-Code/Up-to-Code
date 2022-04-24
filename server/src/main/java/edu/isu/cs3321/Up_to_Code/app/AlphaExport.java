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

public class AlphaExport {
    int y=110;
    int yline=200;
    int yline1=100;
    int h = 550;
    int w = 750;
    Field field;
    Color color;
    BufferedImage bufferedImage;
    Graphics2D graphics2D;
    RenderingHints rh;
    File file;
    public void cardTemplate(Alpha alpha,Integer id) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {


        field = Class.forName("java.awt.Color").getField(alpha.getColor());
        color = (Color) field.get(null);

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

        // }
        // }



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
        file=new File("Wide Cards Saving\\"+alpha.getAlpha()+"widecard.png");
        ImageIO.write(bufferedImage,"png",file);


    }


/*
    public void cardTemplate(String s1,String s2,String s3,String s4,String s5,String s6,String detailedD,String briefD,String cardName,Integer colorBoreder,Integer cardColor) throws IOException {
        String[] states={s1,s2,s3,s4,s5,s6};
        int y=110;
        int yline=200;
        int yline1=100;
        int h = 550;
        int w = 750;
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
        graphics2D.fillRoundRect(0, 0, w, 80,30,30);

        graphics2D.setColor(Color.red);
        graphics2D.drawRoundRect(0, 0, w-1, h-2,30,30);

        //States rectangle and their description
        for(String s:states){
            if(s != null){
                graphics2D.setColor(new Color(colorBoreder));
                graphics2D.drawRoundRect(50,y,330,50,20,20);
                graphics2D.setColor(Color.black);
                graphics2D.drawString(s,150,y+30);
                y=y+70;}
        }
        //brief description
        graphics2D.setColor(Color.black);
        for (String line : briefD.split("\n"))
            graphics2D.drawString( line, 420, yline1 += 4+graphics2D.getFontMetrics().getHeight());
        graphics2D.drawLine(420,yline1+6,700,yline1+6);
        //graphics2D.drawString(briefD,420,100);

        //detailed description
        graphics2D.setColor(Color.black);
        for (String line : detailedD.split("\n"))
            graphics2D.drawString( " * "+line, 420, yline += 4+graphics2D.getFontMetrics().getHeight());
        //graphics2D.drawString(detailedD,420,245);


        //cardname
        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 35));
        graphics2D.drawString(cardName,130,55);

        //Alpha
        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("Zapping", Font.PLAIN, 68));

        //alpha
        graphics2D.drawString("\u03B1",40,60);
        //competency
        //graphics2D.drawString("☆",40,60);

        graphics2D.dispose();
        File file=new File(cardName+" widecard.png");
        ImageIO.write(bufferedImage,"png",file);


    }


    public static void main(String[] args) throws IOException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException {

    new CardTemplate().cardTemplate("Architecture Selected","Demonstrable","Usable","Ready","Operational","Retired","The Software system:\nIs the primary product of any\n software engineering endeavor\nIs structured, designed and\nimplemented to fulfil the requirements\nIs architecture to maintainable,\nextensible and testable\nProvides value to its users and other\n stakeholders\nShould be kept bug fee and easy to\nuse\ncan be part of a larger software,\nhardware or business solution ","A system made up of software,\nhardware, and data that provides its\nprimary value by the execution of the\n software","Software System",Color.red.getRGB(),Color.orange.getRGB());
    System.out.println(new Color(0xFFEFE58B, true));

        Alpha a=new Alpha("hello","1","1","orange",false, 1);
        State s1 = new State("test State", 1);
        a.addState(s1);
        //System.out.println(a.getStates().get(0).getName());
        new CardTemplate().cardTemplate(a,3);




    }

 */
}
