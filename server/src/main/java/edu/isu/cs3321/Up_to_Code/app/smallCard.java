package edu.isu.cs3321.Up_to_Code.app;

import java.lang.reflect.Array;
import java.util.Arrays;

public class smallCard {

    private String alpha;
    private String state;
    private String[] checklist;

    //used for numerating cards
    private int currentState;
    private int totalStates;

    public smallCard(String alpha, String state, String checklist, int currentState, int totalStates){
        this.alpha = alpha;
        this.state = state;

        //separate checklist input string at "."
        String[] checklistOut = checklist.split("\\.");
        this.checklist = checklistOut;

        this.currentState = currentState;
        this.totalStates = totalStates;

        System.out.println(Arrays.toString(this.checklist));
    }
}
