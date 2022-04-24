package edu.isu.cs3321.Up_to_Code.app;

import java.awt.*;
import java.util.Arrays;

public class smallCard {

    public String alpha;
    public String state;
    public Color color;
    public String[] checklist;

    //used for numerating cards
    public int currentState;
    public int totalStates;

    public smallCard(String alpha, String state, Color color, String checklist, int currentState, int totalStates) {
        this.alpha = alpha;
        this.state = state;
        this.color = color;

        //separate checklist input string at "."s
        String[] checklistOut = checklist.split("\\.");
        this.checklist = checklistOut;

        this.currentState = currentState;
        this.totalStates = totalStates;

        //System.out.println(Arrays.toString(this.checklist));
    }
}

