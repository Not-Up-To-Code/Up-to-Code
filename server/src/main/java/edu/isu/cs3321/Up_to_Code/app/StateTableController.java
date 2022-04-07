package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.*;

@Entity
@Table(name = "states")
public class StateTableController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state")
    private String state;

    @Column(name = "stateID")
    private int stateID;


    @Column(name = "id")
    private int id;

    @Column(name = "jsonString")
    private String jsonString;

    public StateTableController(){
    }

    public StateTableController(String state, int stateID, int id, String jsonString) {
        this.state = state;
        this.stateID = stateID;
        this.id = id;
        this.jsonString = jsonString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
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


}
