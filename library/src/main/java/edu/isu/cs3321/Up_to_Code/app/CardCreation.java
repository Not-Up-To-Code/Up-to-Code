package edu.isu.cs3321.Up_to_Code.app;

import java.util.Arrays;
import java.util.List;

public class CardCreation {

    String alpha;
    String state1;
    String state2;
    String state3;
    String state4;
    String state5;
    String state6;
    String description;
    List states = Arrays.asList(state1, state2, state3, state4, state5, state6);

    Integer stateCount;

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









}
