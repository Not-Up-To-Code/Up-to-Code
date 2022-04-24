package edu.isu.cs3321.Up_to_Code.app;

import java.util.*;

/**
 * This is the class we use to convert from the client into the JPA version of State
 */
public class State {
    private String name;
    private int stateOrder;
    private List<CheckListItem> checklist = new ArrayList<>();

    public State() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", stateOrder=" + stateOrder +
                ", checklist=" + checklist +
                '}';
    }

    public int getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(int stateOrder) {
        this.stateOrder = stateOrder;
    }

    public List<CheckListItem> getChecklist() {
        return checklist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecklist(List<CheckListItem> checklist) {
        this.checklist = checklist;
    }

    public State(String name, int stateOrder){
        setName(name);
        this.stateOrder = stateOrder;
    }

    public void addCheckListItem(CheckListItem item){
        checklist.add(item);
    }
}
