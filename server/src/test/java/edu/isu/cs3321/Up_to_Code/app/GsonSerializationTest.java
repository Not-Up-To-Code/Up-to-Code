package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.ServerToClientConverter;
import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.clientToServerConverter;

public class GsonSerializationTest {

    @Test
    public void testClienttoServerConverter(){
        Alpha a = new Alpha("test","test","test","blue", false);
        State s = new State();
        CheckListItem c = new CheckListItem();
        s.addCheckListItem(c);
        a.addState(s);
        StateTableController s1 = new StateTableController();
        ChecklistTableController c1 = new ChecklistTableController();
        s1.addItems(c1);
        AlphaTableController a1 = new AlphaTableController("test","test", "test", false, "blue");
        a1.addState(s1);
        AlphaTableController a2 = clientToServerConverter(a);
        Assertions.assertEquals(a1.toString(),a2.toString());
    }
    @Test
    public void testServerToClientConverter(){
        Alpha a = new Alpha("test","test","test","blue", false);
        State s = new State();
        CheckListItem c = new CheckListItem();
        s.addCheckListItem(c);
        a.addState(s);
        StateTableController s1 = new StateTableController();
        ChecklistTableController c1 = new ChecklistTableController();
        s1.addItems(c1);
        AlphaTableController a1 = new AlphaTableController("test","test", "test", false, "blue");
        a1.addState(s1);
        Alpha a2 = ServerToClientConverter(a1);
        Assertions.assertEquals(a.toString(), a2.toString());
    }
}
