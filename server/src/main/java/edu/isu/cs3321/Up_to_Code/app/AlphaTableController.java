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

    @Column(name = "ID")
    private int id;

    public AlphaTableController(String alpha, int id) {
        this.alpha = alpha;
        this.id = id;
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

    @Override
    public String toString() {
        return "AlphaTableController{" +
                "alpha='" + alpha + '\'' +
                ", id=" + id +
                '}';
    }
}
