package edu.isu.cs3321.Up_to_Code.app;

/**
 * We use this class to convert to the JPA Checklist Item class.
 */
public class CheckListItem {
    private String checklistitem;

    public CheckListItem() {

    }


    public String getChecklistitem() {
        return checklistitem;
    }

    public void setChecklistitem(String checklistitem) {
        this.checklistitem = checklistitem;
    }

    @Override
    public String toString() {
        return "CheckListItem{" +
                "checklistitem='" + checklistitem + '\'' +
                '}';
    }

    public CheckListItem(String item){
        setChecklistitem(item);

    }
}
