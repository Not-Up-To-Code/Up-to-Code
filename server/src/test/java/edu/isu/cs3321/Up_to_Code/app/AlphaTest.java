package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class AlphaTest {
    private static Alpha a = new Alpha();
    @Test
    public void testGetterSetterAlphaName(){
        String t = "test";
        a.setAlpha(t);
        Assertions.assertEquals(t, a.getAlpha());
    }
    @Test
    public void testGetterSetterAlphaBriefDesc(){
        String t = "test";
        a.setBriefDesc(t);
        Assertions.assertEquals(t, a.getBriefDesc());
    }
    @Test
    public void testGetterSetterAlphaDetailedDesc(){
        String t = "test";
        a.setDetailedDesc(t);
        Assertions.assertEquals(t, a.getDetailedDesc());
    }
    @Test
    public void testGetterSetterCardColor(){
        String t = "blue";
        a.setColor(t);
        Assertions.assertEquals(t, a.getColor());
    }
    @Test
    public void testGetterSetterAlphaID(){
        int id = 1;
        a.setId(id);
        Assertions.assertEquals(id, a.getId());
    }
    @Test
    public void testGetterSetterAlphaCompetency(){
        boolean b = false;
        a.setCompetency(b);
        Assertions.assertEquals(b, a.isCompetency());
    }
    @Test
    public void testGetterSetterAlphaStates(){
        State s = new State();
        List<State> sList = new ArrayList<State>();
        sList.add(s);
        a.setStates(sList);
        a.addState(s);
        sList.add(s);
        Assertions.assertEquals(sList, a.getStates());
    }
    @Test
    public void testConstructor(){
        Alpha a1 = new Alpha("test","test","test", "blue", false, 1);
        Alpha a2 = new Alpha();
        a2.setAlpha("test");
        a2.setBriefDesc("test");
        a2.setColor("blue");
        a2.setDetailedDesc("test");
        a2.setId(1);
        a2.setCompetency(false);
        String s1 = a1.toString();
        String s2 = a2.toString();
        Assertions.assertEquals(s1, s2);
    }
}
