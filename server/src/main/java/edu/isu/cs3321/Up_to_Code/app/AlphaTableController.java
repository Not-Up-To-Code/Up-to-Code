package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alphas")
public class AlphaTableController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alpha")
    private String alpha;

    @Column(name = "id")
    private int id;

    @Column(name = "jsonString")
    private String jsonString;

    @Column(name = "isCompetency")
    private boolean isCompetency;


    public AlphaTableController(String alpha, int id, String jsonString, boolean isCompetency) {
        this.alpha = alpha;
        this.id = id;
        this.jsonString = jsonString;
        this.isCompetency = isCompetency;
    }

    public AlphaTableController() {

    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
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

    public boolean isCompetency() {
        return isCompetency;
    }

    public void setCompetency(boolean competency) {
        isCompetency = competency;
    }

    @Override
    public String toString() {
        return "AlphaTableController{" +
                "alpha='" + alpha + '\'' +
                ", id=" + id +
                ", jsonString='" + jsonString + '\'' +
                ", isCompetency=" + isCompetency +
                '}';
    }
}
