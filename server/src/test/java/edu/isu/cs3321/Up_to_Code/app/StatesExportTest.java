package edu.isu.cs3321.Up_to_Code.app;

import com.ibm.icu.impl.Row;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.parser.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.io.IOException;
import java.sql.Statement;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StatesExportTest {
    private StatesExport statesExport;
    @BeforeEach
    void setUp(){
        statesExport= Mockito.mock(StatesExport.class);

    }
    @Test
    public void smallcardTemplateTest() throws IOException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Alpha alpha=new Alpha("alpha","briefDesc","detailedDesc","red",false,3);
        Integer id = 3;


        //Mockito.doCallRealMethod().when(statesExport).smallCardTemplate(Mockito.any(Alpha.class),anyInt());
        Mockito.doCallRealMethod().doNothing().when(statesExport).smallCardTemplate(Mockito.any(Alpha.class),anyInt());

        doCallRealMethod().when(statesExport).smallCardTemplate(any(Alpha.class),anyInt());



        statesExport.smallCardTemplate(alpha,id);
        verify(statesExport,times(1)).smallCardTemplate(alpha,3);



    }
}
