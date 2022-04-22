package edu.isu.cs3321.Up_to_Code.app;



import org.junit.jupiter.api.*;

import static edu.isu.cs3321.Up_to_Code.app.DatabaseManagement.*;
import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.serialize;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseManagementTest {
    private static AlphaTableController a = new AlphaTableController("Junit","Test", "Junit Test", false, "yellow");
    private static StateTableController s = new StateTableController("State", 1);
    private static ChecklistTableController c = new ChecklistTableController( "Testing");
    private static int id;

    @BeforeAll
    public static void setup(){
        s.addItems(c);
        a.addState(s);
    }

    @Test
    @Order(1)
    void testAddAlpha(){
        addAlpha(serialize(a));
        id = getAlphas().get(getAlphas().size() - 1).getId();
        Assertions.assertNotNull(id);
    }

    @Test
    @Order(2)
    void testGetAlpha(){
        Assertions.assertFalse(getAlphas().isEmpty());
    }

    @Test
    @Order(3)
    void testUpdateAlpha(){
        a.setAlpha("Update");
        updateAlpha(serialize(a), id);
        System.out.println("test");
        String string = getAlphas().get(getAlphas().size() - 1).getAlpha();
        Assertions.assertEquals(string, a.getAlpha());

    }

    @Test
    @Order(4)
    void testDeleteAlphaTest(){
        int size = getAlphas().size();
        System.out.println(id);


        deleteAlpha(id);


        Assertions.assertNotEquals(getAlphas().size(), size);
    }
}
