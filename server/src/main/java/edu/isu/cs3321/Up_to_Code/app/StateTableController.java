package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class StateTableController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state")
    private String state;

    @Column(name = "stateID")
    private int stateID;

    public StateTableController(){
    }

    public StateTableController(String state, int stateID) {
        this.state = state;
        this.stateID = stateID;
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
                '}';
    }
}
