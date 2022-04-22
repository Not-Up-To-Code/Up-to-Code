package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class AlphaTableControllerTest {
    private static AlphaTableController a = new AlphaTableController();
    @Test
    public void testGetterSetterAlpha(){
        String t = "test";
        a.setAlpha(t);
        Assertions.assertEquals(t, a.getAlpha());
    }
    @Test
    public void testGetterSetterBriefDesc(){
        String t = "test";
        a.setBriefDescription(t);
        Assertions.assertEquals(t, a.getBriefDescription());
    }
    @Test
    public void testGetterSetterDetailedDesc(){
        String t = "test";
        a.setDetailedDescription(t);
        Assertions.assertEquals(t, a.getDetailedDescription());
    }
    @Test
    public void testGetterSetterColor(){
        String t = "blue";
        a.setCardColor(t);
        Assertions.assertEquals(t, a.getCardColor());
    }
    @Test
    public void testGetterSetterID(){
        int id = 1;
        a.setId(id);
        Assertions.assertEquals(id, a.getId());
    }
    @Test
    public void testGetterSetterCompetency(){
        boolean b = false;
        a.setCompetency(b);
        Assertions.assertEquals(b, a.isCompetency());
    }
    @Test
    public void testGetterSetterStates(){
        StateTableController s = new StateTableController();
        List<StateTableController> sList = new ArrayList<StateTableController>();
        sList.add(s);
        a.setStates(sList);
        a.addState(s);
        sList.add(s);
        Assertions.assertEquals(sList, a.getStates());
    }

}
