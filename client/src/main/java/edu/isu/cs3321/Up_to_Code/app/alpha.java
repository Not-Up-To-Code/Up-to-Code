package edu.isu.cs3321.Up_to_Code.app;

import java.util.List;

public class alpha {
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String color;
    private List<state> states;

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

    public List<state> getStates() {
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

    public void setStates(List<state> states) {
        this.states = states;
    }

    public alpha(String alpha, String briefDesc, String detailedDesc, String color){
        setAlpha(alpha);
        setBriefDesc(briefDesc);
        setDetailedDesc(detailedDesc);
        setColor(color);

    }

    public void addState(state state){
        this.states.add(state);
    }
}
