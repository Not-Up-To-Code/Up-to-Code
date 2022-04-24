package edu.isu.cs3321.Up_to_Code.app;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class smallCardTest {
    private static final smallCard smallCard=new smallCard("System software","retired", Color.getColor("red"),"list",3,10);
    @Test
    public void smallCardAlphaTest(){
        Assertions.assertEquals(smallCard.alpha,"System software");
    }
    @Test
    public void smallCardChecklistTest(){
        //Assertions.assertEquals(smallCard.checklist,checklist);
    }
    @Test
    public void smallCardColorTest(){
        Assertions.assertEquals(smallCard.color,Color.getColor("red"));
    }
    @Test
    public void smallCardStateTest(){
        Assertions.assertEquals(smallCard.state,"retired");
    }
    @Test
    public void smallCardTotalStateTest(){
        Assertions.assertEquals(smallCard.totalStates,10);
    }
    @Test
    public void smallCardCurrentStateTest(){
        Assertions.assertEquals(smallCard.currentState,3);
    }

}


