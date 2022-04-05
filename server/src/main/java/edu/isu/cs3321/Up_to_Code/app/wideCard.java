package edu.isu.cs3321.Up_to_Code.app;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wideCard {

    //default card Params
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String state1;
    private String state2;
    private String state3;
    private String state4;
    private String state5;
    private String state6;

    public  wideCard(String alpha, String briefDesc, String detailedDesc, String state1, String state2, String state3, String state4, String state5, String state6){
        this.alpha = alpha;
        this.briefDesc = briefDesc;
        this.detailedDesc = detailedDesc;
        this.state1 = state1;
        this.state2 = state2;
        this.state3 = state3;
        this.state4 = state4;
        this.state5 = state5;
        this.state6 = state6;
    }
}
