package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AlphaExportTest {
    @Test
    public void cardTemplateTest() throws IOException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Alpha alpha=new Alpha("alpha","briefDesc","detailedDesc","red",false,3);
        Integer id = 3;
        AlphaExport alphaExport=new AlphaExport();
        alphaExport.cardTemplate(alpha,id);
        AlphaExport alphaExport1= Mockito.mock(AlphaExport.class);


        doNothing().when(alphaExport1).cardTemplate(any(),anyInt());
        alphaExport1.cardTemplate(alpha,id);
        verify(alphaExport1,times(1)).cardTemplate(alpha,3);



    }
    @Test
    private void compareRasterImages(BufferedImage expectedPngIo, BufferedImage actualPngIo) throws AssertionError {
        int minX = expectedPngIo.getMinX();
        int minY = expectedPngIo.getMinY();
        int maxX = expectedPngIo.getMinX() + expectedPngIo.getWidth();
        int maxY = expectedPngIo.getMinY()+ expectedPngIo.getHeight();

        assertEquals(minX, actualPngIo.getMinX());
        assertEquals(minY, actualPngIo.getMinY());
        assertEquals(expectedPngIo.getHeight(), actualPngIo.getHeight());
        assertEquals(expectedPngIo.getWidth(), actualPngIo.getWidth());
        for (int x_i = minX; x_i < maxX; x_i++){
            for (int y_i = minY; y_i < maxY; y_i++) {
                assertEquals(expectedPngIo.getRGB(x_i, y_i), actualPngIo.getRGB(x_i, y_i));
            }
        }
    }
}
