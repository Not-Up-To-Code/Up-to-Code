package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.deSerializeClientAlpha;
import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.serialize;

public class GsonSerializationTest {
    @Test
    public void testSerialize(){
        Alpha a = new Alpha("test", "test", "test", "red", false);
        String json = serialize(a);
        Alpha a1 = deSerializeClientAlpha(json);
        Assertions.assertEquals(a1.toString(), a.toString());

    }
}
