package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StateTableControllerTest {
    private static StateTableController s = new StateTableController();
    @Test
    public void testGetterSetterName(){
        String t = "test";
        s.setState(t);
        Assertions.assertEquals(t, s.getState());
    }
    @Test
    public void testGetterSetterOrder(){
        int order = 1;
        s.setStateOrder(order);
        Assertions.assertEquals(order, s.getStateOrder());
    }
    @Test
    public void testGetterSetterID(){
        int id = 1;
        s.setStateID(id);
        Assertions.assertEquals(id, s.getStateID());
    }
    @Test
    public void testGetterSetterItems(){
        ChecklistTableController c = new ChecklistTableController();
        List<ChecklistTableController> cList = new ArrayList<ChecklistTableController>();
        cList.add(c);
        s.setItems(cList);
        s.addItems(c);
        cList.add(c);
        Assertions.assertEquals(cList, s.getItems());
    }
}
