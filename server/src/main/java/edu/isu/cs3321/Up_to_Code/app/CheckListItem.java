package edu.isu.cs3321.Up_to_Code.app;

public class CheckListItem {
    private String checklistitem;

    public String getChecklistitem() {
        return checklistitem;
    }

    public void setChecklistitem(String checklistitem) {
        this.checklistitem = checklistitem;
    }

    public CheckListItem(String item){
        setChecklistitem(item);
    }
}
