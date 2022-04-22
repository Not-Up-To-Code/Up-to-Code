package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckListItemTest {
    private static CheckListItem c = new CheckListItem();
    @Test
    public void testGetterSetterName(){
        String t = "test";
        c.setChecklistitem(t);
        Assertions.assertEquals(t, c.getChecklistitem());
    }
    @Test
    public void testConstructor(){
        CheckListItem c1 = new CheckListItem("item");
        CheckListItem c2 = new CheckListItem();
        c2.setChecklistitem("item");
        Assertions.assertEquals(c2.toString(),c1.toString());
    }
}
