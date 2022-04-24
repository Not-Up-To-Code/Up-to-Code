package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class wideCardTest {
    private static final wideCard wideCard=new wideCard("System software","brief description test","detailed description test","state1","state2","state3","state4","state5","state6",Color.getColor("red"));

    @Test
    public void widecardAlphaTest(){
        Assertions.assertEquals(wideCard.cardName,"System software");
    }

    @Test
    public void widecardBriefDescriptionTest(){
        Assertions.assertEquals(wideCard.briefDesc,"brief description test");
    }
    @Test
    public void widecardDetailedDescriptionTest(){
        Assertions.assertEquals(wideCard.detailedDesc,"detailed description test");
    }
    @Test
    public void widecardState1Test(){
        Assertions.assertEquals(wideCard.state1,"state1");
    }
    @Test
    public void widecardState2Test(){
        Assertions.assertEquals(wideCard.state2,"state2");
    }
    @Test
    public void widecardState3Test(){
        Assertions.assertEquals(wideCard.state3,"state3");
    }
    @Test
    public void widecardState4Test(){
        Assertions.assertEquals(wideCard.state4,"state4");
    }
    @Test
    public void widecardState5Test(){
        Assertions.assertEquals(wideCard.state5,"state5");
    }
    @Test
    public void widecardState6Test(){
        Assertions.assertEquals(wideCard.state6,"state6");
    }
    @Test
    public void widecardColorTest(){
        Assertions.assertEquals(wideCard.color,Color.getColor("red"));
    }

}
