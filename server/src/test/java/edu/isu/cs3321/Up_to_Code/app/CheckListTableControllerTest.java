package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckListTableControllerTest {
    private static ChecklistTableController c = new ChecklistTableController();
    @Test
    public void testGetterSetterItem(){
        String t = "test";
        c.setChecklistItem(t);
        Assertions.assertEquals(t, c.getChecklistItem());
    }
    @Test
    public void testGetterSetterID(){
        int id = 1;
        c.setChecklistID(id);
        Assertions.assertEquals(id, c.getChecklistID());
    }
    @Test
    public void testToString(){
        ChecklistTableController c1 = new ChecklistTableController("item");
        String item = c1.toString();
        String name = c1.getChecklistItem();
        Assertions.assertTrue(item.contains("checklistItem=" + "'" + name + "'"));
    }
}
