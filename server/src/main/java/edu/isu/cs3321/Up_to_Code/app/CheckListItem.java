package edu.isu.cs3321.Up_to_Code.app;

public class CheckListItem {
    private String checklistitem;
    private int stateID;

    public String getChecklistitem() {
        return checklistitem;
    }

    public void setChecklistitem(String checklistitem) {
        this.checklistitem = checklistitem;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public CheckListItem(String item, int stateID){
        setChecklistitem(item);
        this.stateID = stateID;
    }
}
