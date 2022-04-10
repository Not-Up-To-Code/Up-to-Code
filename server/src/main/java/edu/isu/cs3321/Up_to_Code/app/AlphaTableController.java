package edu.isu.cs3321.Up_to_Code.app;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "alphas")
public class AlphaTableController {
    @Column(name = "alpha")
    private String alpha;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "briefDescription")
    private String briefDescription;

    @Column(name = "detailedDescription")
    private String detailedDescription;


    @Column(name = "isCompetency")
    private boolean isCompetency;

    @Column(name = "cardColor")
    private String cardColor;

    @OneToMany(mappedBy="alph",cascade = CascadeType.ALL)
    private List<StateTableController> states = new ArrayList<>();



    public AlphaTableController(String alpha, String briefDescription, String detailedDescription, boolean isCompetency, String cardColor) {
        this.alpha = alpha;
        this.id = id;
        this.briefDescription = briefDescription;
        this.detailedDescription = detailedDescription;
        this.isCompetency = isCompetency;
        this.cardColor = cardColor;
    }


    public void addState(StateTableController state){
        this.states.add(state);
    }
    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
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

    public List<StateTableController> getStates() {
        return states;
    }

    public void setStates(List<StateTableController> states) {
        this.states = states;
    }

    public boolean isCompetency() {
        return isCompetency;
    }

    public void setCompetency(boolean competency) {
        isCompetency = competency;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    @Override
    public String toString() {
        return "AlphaTableController{" +
                "alpha='" + alpha + '\'' +
                ", id=" + id +
                ", briefDescription='" + briefDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", isCompetency=" + isCompetency +
                ", cardColor='" + cardColor + '\'' +
                '}';
    }
}
