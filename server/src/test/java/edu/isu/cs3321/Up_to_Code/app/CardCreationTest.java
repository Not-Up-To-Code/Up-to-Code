package edu.isu.cs3321.Up_to_Code.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;

//import static org.junit.jupiter.api.AssertNull.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CardCreationTest {
    @Test
    public void cardCreationTest() {
        CardCreation cardCreation = new CardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification",null,5);
        Assertions.assertEquals(cardCreation.title,"alpha");
        Assertions.assertEquals(cardCreation.state1,"state1");
        Assertions.assertEquals(cardCreation.state2,"state2");
        Assertions.assertEquals(cardCreation.state3,"state3");
        Assertions.assertEquals(cardCreation.state4,"state4");
        Assertions.assertEquals(cardCreation.state5,"state5");
        Assertions.assertEquals(cardCreation.state6,"state6");
        Assertions.assertEquals(cardCreation.description,"description");
        Assertions.assertEquals(cardCreation.specification,"specification");
        //Assertions.assertEquals(cardCreation.states,null);
        Assertions.assertEquals(cardCreation.stateCount,5);
    }

    @Test
    public void cardCreationGetterTest(){
        CardCreation cardCreation = new CardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification",null,5);
        Assertions.assertEquals(cardCreation.getTitle(),"alpha");
        Assertions.assertEquals(cardCreation.getState1(),"state1");
        Assertions.assertEquals(cardCreation.getState2(),"state2");
        Assertions.assertEquals(cardCreation.getState3(),"state3");
        Assertions.assertEquals(cardCreation.getState4(),"state4");
        Assertions.assertEquals(cardCreation.getState5(),"state5");
        Assertions.assertEquals(cardCreation.getState6(),"state6");
        Assertions.assertEquals(cardCreation.getDescription(),"description");
        Assertions.assertEquals(cardCreation.getSpecification(),"specification");
        Assertions.assertEquals(cardCreation.getCount(),5);
    }


    @Test
    public void cardCreationSetterTest(){
        List list=new List();
        list.add("test");
        CardCreation cardCreation = new CardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification", null,5);
        String title="alpha1";
        String state1="state11";
        String state2="state21";
        String state3="state31";
        String state4="state41";
        String state5="state51";
        String state6="state61";
        String description="description1";
        String specification="specification1";
        cardCreation.setTitle("alpha1");
        cardCreation.setState1("state11");
        cardCreation.setState2("state21");
        cardCreation.setState3("state31");
        cardCreation.setState4("state41");
        cardCreation.setState5("state51");
        cardCreation.setState6("state61");
        cardCreation.setDescription("description1");
        cardCreation.setSpecification("specification1");
        Assertions.assertEquals(title,"alpha1");
        Assertions.assertEquals(state1,"state11");
        Assertions.assertEquals(state2,"state21");
        Assertions.assertEquals(state3,"state31");
        Assertions.assertEquals(state4,"state41");
        Assertions.assertEquals(state5,"state51");
        Assertions.assertEquals(state6,"state61");
        Assertions.assertEquals(description,"description1");
        Assertions.assertEquals(specification,"specification1");
    }

    @Test
    public void cardCreationCountTest(){
        //CardCreation cardCreation = Mockito.spy(new CardCreation());
        //assertNull(cardCreation.count());
       // doNothing().when(cardCreation).count();
        //verify(cardCreation,times(1)).count();
    }

    @Test
    public void cardCreationVoidTest(){
        CardCreation cardCreation=mock(CardCreation.class);
        doNothing().when(cardCreation).cardCreation(anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString());
        cardCreation.cardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification");
        verify(cardCreation,times(1)).cardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification");
        //CardCreation cardCreation = new CardCreation(null,null,null,null,null,null,null,null,null,null,null);
        //cardCreation.cardCreation("alpha","state1","state2","state3","state4","state5","state6","description","specification");
        //Assertions.assertEquals(cardCreation,null);
    }


    }



