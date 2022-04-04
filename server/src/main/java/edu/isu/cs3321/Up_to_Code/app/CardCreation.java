package edu.isu.cs3321.Up_to_Code.app;

import java.util.Arrays;
import java.util.List;
// card cretiion conscrtuctor
// move to card export

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


    public CardCreation(String title, String state1, String state2, String state3, String state4, String state5, String state6, String description, String specification, List<String> states, Integer stateCount) {
        this.title = title;
        this.state1 = state1;
        this.state2 = state2;
        this.state3 = state3;
        this.state4 = state4;
        this.state5 = state5;
        this.state6 = state6;
        this.description = description;
        this.specification = specification;
        this.states = states;
        this.stateCount = stateCount;
    }

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




    public void cardCreation(String ti, String s1, String s2, String s3, String s4, String s5, String s6, String d, String s){
        title=ti;
        description=d;
        specification=s;
        state1=s1;
        state2=s2;
        state3=s3;
        state4=s4;
        state5=s5;
        state6=s6;

    }





}
