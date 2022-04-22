package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StateTest {
    private static State s = new State();
    @Test
    public void testGetterSetterStateName(){
        String t = "test";
        s.setName(t);
        Assertions.assertEquals(t, s.getName());
    }
    @Test
    public void testGetterSetterStateOrder(){
        int order = 1;
        s.setStateOrder(order);
        Assertions.assertEquals(order, s.getStateOrder());
    }
    @Test
    public void testGetterSetterItem(){
        CheckListItem c = new CheckListItem();
        List<CheckListItem> cList = new ArrayList<CheckListItem>();
        cList.add(c);
        s.setChecklist(cList);
        s.addCheckListItem(c);
        cList.add(c);
        Assertions.assertEquals(cList, s.getChecklist());
    }
    @Test
    public void testConstructor(){
        State s1 = new State("Name",2);
        State s2 = new State();
        s2.setName("Name");
        s2.setStateOrder(2);
        Assertions.assertEquals(s1.toString(), s2.toString());
    }
}
