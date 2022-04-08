package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.*;

@Entity
@Table(name = "states")
public class StateTableController {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state")
    private String state;
    @Id
    @Column(name = "stateID")
    private int stateID;


    @Column(name = "id")
    private int id;

    @Column(name = "stateOrder")
    private int stateOrder;

    public StateTableController(){
    }

    public StateTableController(String state, int stateID, int id, int stateOrder) {
        this.state = state;
        this.stateID = stateID;
        this.id = id;
        this.stateOrder = stateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", id=" + id +
                ", stateOrder=" + stateOrder +
                '}';
    }
}
