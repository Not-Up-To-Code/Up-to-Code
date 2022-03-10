package edu.isu.cs3321.Up_to_Code.app;

import java.util.Arrays;
import java.util.List;

public class CardCreation {

    String title;
    String state1;
    String state2;
    String state3;
    String state4;
    String state5;
    String state6;
    String description;
    String specification;
    List<String> states = Arrays.asList(state1, state2, state3, state4, state5, state6);

    Integer stateCount;

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    private void count(){
        for(int i = 0; i < 6; i++){
            if(states.get(i) != null){
                stateCount++;
            }
        }
    }


    private Integer getCount(){
        return stateCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String alpha) {
        this.title = alpha;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getState3() {
        return state3;
    }

    public void setState3(String state3) {
        this.state3 = state3;
    }

    public String getState4() {
        return state4;
    }

    public void setState4(String state4) {
        this.state4 = state4;
    }

    public String getState5() {
        return state5;
    }

    public void setState5(String state5) {
        this.state5 = state5;
    }

    public String getState6() {
        return state6;
    }

    public void setState6(String state6) {
        this.state6 = state6;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  void setCard(String ti,String s1,String s2,String s3,String s4,String s5,String s6,String d,String s){
        if (!stateCount.equals(0)){
            setTitle(ti);
            setDescription(d);
            setSpecification(s);
            if(getCount().equals(1)){
            setState1(s1);
            states.set(0,state1);

        }
            if(getCount().equals(2)){
                setState1(s1);
                setState2(s2);
                states.set(0,state1);
                states.set(1,state2);
        }
            if(getCount().equals(3)){
                setState1(s1);
                setState2(s2);
                setState3(s3);
                states.set(0,state1);
                states.set(1,state2);
                states.set(2,state3);
        }
            if(getCount().equals(4)){
                setState1(s1);
                setState2(s2);
                setState3(s3);
                setState4(s4);
                states.set(0,state1);
                states.set(1,state2);
                states.set(2,state3);
                states.set(3,state4);
        }
            if(getCount().equals(5)){
                setState1(s1);
                setState2(s2);
                setState3(s3);
                setState4(s4);
                setState5(s5);
                states.set(0,state1);
                states.set(1,state2);
                states.set(2,state3);
                states.set(3,state4);
                states.set(4,state5);
        }
            if(getCount().equals(6)){
                setState1(s1);
                setState2(s2);
                setState3(s3);
                setState4(s4);
                setState5(s5);
                setState6(s6);
                setState1(s1);
                setState2(s2);
                setState3(s3);
                setState4(s4);
                setState5(s5);
                states.set(0,state1);
                states.set(1,state2);
                states.set(2,state3);
                states.set(3,state4);
                states.set(4,state5);
                states.set(5,state6);
            }
        }
        }




    public static void main(String[] args) {
        CardCreation c=new CardCreation();
        c.setCard(null,"hello","hi",null,null,null,null,null,null);
        System.out.println(c.states);
    }




}
