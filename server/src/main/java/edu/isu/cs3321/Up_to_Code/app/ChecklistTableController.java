package edu.isu.cs3321.Up_to_Code.app;

import javax.persistence.*;

@Entity
@Table(name = "checklist")
public class ChecklistTableController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklistID")
    private int checklistID;

    @Column(name = "stateID")
    private int stateID;

    @Column(name = "checklistItem")
    private String checklistItem;

    public ChecklistTableController(int stateID, String checklistItem) {

        this.stateID = stateID;
        this.checklistItem = checklistItem;
    }

    public ChecklistTableController() {
    }

    public int getChecklistID() {
        return checklistID;
    }

    public void setChecklistID(int checklistID) {
        this.checklistID = checklistID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getChecklistItem() {
        return checklistItem;
    }

    public void setChecklistItem(String checklistItem) {
        this.checklistItem = checklistItem;
    }

    @Override
    public String toString() {
        return "ChecklistTableController{" +
                "checklistID=" + checklistID +
                ", stateID=" + stateID +
                ", checklistItem='" + checklistItem + '\'' +
                '}';
    }
}
