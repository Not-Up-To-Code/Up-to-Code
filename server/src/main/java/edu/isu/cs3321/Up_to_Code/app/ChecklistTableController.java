package edu.isu.cs3321.Up_to_Code.app;

import javax.persistence.*;

@Entity
@Table(name = "checklist")
public class ChecklistTableController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklistID")
    private int checklistID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "stateID")
    private StateTableController stateName;

    @Column(name = "checklistItem")
    private String checklistItem;

    public ChecklistTableController(String checklistItem, StateTableController s) {


        this.checklistItem = checklistItem;
        this.stateName = s;
    }

    public ChecklistTableController() {
    }

    public StateTableController getStateName() {
        return stateName;
    }

    public void setStateName(StateTableController stateName) {
        this.stateName = stateName;
    }

    public int getChecklistID() {
        return checklistID;
    }

    public void setChecklistID(int checklistID) {
        this.checklistID = checklistID;
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

                ", checklistItem='" + checklistItem + '\'' +
                '}';
    }
}
