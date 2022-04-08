package edu.isu.cs3321.Up_to_Code.app;

import java.util.List;

public class state {
    private String name;
    private List<checklistitem> checklist;

    public String getName() {
        return name;
    }

    public List<checklistitem> getChecklist() {
        return checklist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecklist(List<checklistitem> checklist) {
        this.checklist = checklist;
    }

    public state(String name){
        setName(name);
    }
}
