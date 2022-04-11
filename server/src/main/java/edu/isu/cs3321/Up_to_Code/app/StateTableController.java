package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "states")
public class StateTableController {

    @Column(name = "state")
    private String state;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stateID")
    private int stateID;


    @Column(name = "stateOrder")
    private int stateOrder;

    @OneToMany(targetEntity = ChecklistTableController.class, fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stateID", nullable = false)
    private List<ChecklistTableController> items = new ArrayList<>();


    public StateTableController(){
    }



    public StateTableController(String state, int stateOrder) {
        this.state = state;

        this.stateOrder = stateOrder;
    }
    public void addItems(ChecklistTableController item){
        this.items.add(item);
    }


    public List<ChecklistTableController> getItems() {
        return items;
    }

    public void setItems(List<ChecklistTableController> items) {
        this.items = items;
    }

    public int getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(int stateOrder) {
        this.stateOrder = stateOrder;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public String toString() {
        return "StateTableController{" +
                "state='" + state + '\'' +
                ", stateID=" + stateID +
                ", stateOrder=" + stateOrder +
                '}';
    }
}
