package edu.isu.cs3321.Up_to_Code.app;

import java.util.List;

public class State {
    private String name;
    private List<CheckListItem> checklist;

    public String getName() {
        return name;
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

    public State(String name){
        setName(name);
    }
}
