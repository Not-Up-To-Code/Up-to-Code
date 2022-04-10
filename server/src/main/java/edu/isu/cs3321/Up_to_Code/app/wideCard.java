package edu.isu.cs3321.Up_to_Code.app;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wideCard {

    //default card Params
    public  String cardName;
    public  String briefDesc;
    public  String detailedDesc;
    public String state1;
    public  String state2;
    public  String state3;
    public  String state4;
    public  String state5;
    public  String state6;
    public Color color;

    public  wideCard(String alpha, String briefDesc, String detailedDesc, String state1, String state2, String state3, String state4, String state5, String state6,Color color){
        this.cardName = alpha;
        this.briefDesc = briefDesc;
        this.detailedDesc = detailedDesc;
        this.state1 = state1;
        this.state2 = state2;
        this.state3 = state3;
        this.state4 = state4;
        this.state5 = state5;
        this.state6 = state6;
        this.color=color;
    }
}
