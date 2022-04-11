package edu.isu.cs3321.Up_to_Code.app;

import java.util.*;

public class Alpha {
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String color;
    private boolean isCompetency;
    private List<State> states = new ArrayList<>();

    public String getAlpha() {
        return alpha;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public String getDetailedDesc() {
        return detailedDesc;
    }

    public String getColor() {
        return color;
    }

    public List<State> getStates() {
        return states;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public boolean isCompetency() {
        return isCompetency;
    }

    public void setCompetency(boolean competency) {
        isCompetency = competency;
    }

    public Alpha(String alpha, String briefDesc, String detailedDesc, String color,boolean isCompetency){
        setAlpha(alpha);
        setBriefDesc(briefDesc);
        setDetailedDesc(detailedDesc);
        setColor(color);
        this.states = states;
        this.isCompetency = isCompetency;


    }

    public void addState(State state){
        this.states.add(state);
    }
}
