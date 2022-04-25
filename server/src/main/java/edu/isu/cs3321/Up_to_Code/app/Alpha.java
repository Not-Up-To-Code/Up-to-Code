package edu.isu.cs3321.Up_to_Code.app;

import java.util.*;

/**
 * This class works as a duplicate of the Alpha class contained in the client portion of the project. We use this to convert into the JPA version of Alpha
 */
public class Alpha {
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String color;
    private boolean isCompetency;
    private int id;
    private List<State> states = new ArrayList<>();

    @Override
    public String toString() {
        return "Alpha{" +
                "alpha='" + alpha + '\'' +
                ", briefDesc='" + briefDesc + '\'' +
                ", detailedDesc='" + detailedDesc + '\'' +
                ", color='" + color + '\'' +
                ", isCompetency=" + isCompetency +
                ", id=" + id +
                ", states=" + states +
                '}';
    }

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

    public Alpha(String alpha, String briefDesc, String detailedDesc, String color, boolean isCompetency){
        setAlpha(alpha);
        setBriefDesc(briefDesc);
        setDetailedDesc(detailedDesc);
        setColor(color);
        this.states = states;
        this.isCompetency = isCompetency;


    }

    public Alpha(String alpha, String briefDesc, String detailedDesc, String color, boolean isCompetency, int id) {
        this.alpha = alpha;
        this.briefDesc = briefDesc;
        this.detailedDesc = detailedDesc;
        this.color = color;
        this.isCompetency = isCompetency;
        this.id = id;
    }

    public Alpha() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addState(State state){
        this.states.add(state);
    }
}
