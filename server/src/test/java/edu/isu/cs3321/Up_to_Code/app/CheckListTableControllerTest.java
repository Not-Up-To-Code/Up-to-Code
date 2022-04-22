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
}
