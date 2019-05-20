package at.htl.tennisclubadministration.model;

import javafx.util.Pair;
import sun.util.resources.en.TimeZoneNames_en_IE;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Tennismatch.findAll", query = "select m from Tennismatch m")
})
public abstract class Tennismatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDate localDate; // anfangszeit
    protected int duration; // zeit gespielt (in minuten)
    protected String score;

    /*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @XmlTransient
    @JoinTable(
            name="TENNISPLAYER_TENNISMATCH",
            joinColumns = @JoinColumn(name = "TENNISMATCH_ID"),
            inverseJoinColumns = @JoinColumn(name = "TENNISPLAYER_ID")
    )
    private List<Tennisplayer> tennisplayers;*/

    // region Constructor
    public Tennismatch(){}
    public Tennismatch(LocalDate localDate, int duration, String score){
        this.localDate = localDate;
        this.duration = duration;
        this.score = score;
    }
    // endregion

    // region Getter & Setter
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getDuration() { return duration; }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setScore(String score) { this.score = score; }

    public String getScore(){ return this.score; }

    // endregion

    /*public void addPlayer(Tennisplayer tennisplayer) {
        if (tennisplayers == null){
            tennisplayers = new ArrayList<>();
        }
        if (!tennisplayers.contains(tennisplayer)){
            tennisplayers.add(tennisplayer);
        }
        if (!tennisplayer.getTennismatches().contains(this)){
            tennisplayer.addTennismatch(this);
        }
    }

    public void removePlayer(Tennisplayer tennisplayer){
        if (tennisplayers.contains(tennisplayer)){
            tennisplayers.remove(tennisplayer);
        }
        if (tennisplayer.getTennismatches().contains(this)){
            tennisplayer.getTennismatches().remove(this);
        }
    }*/
}
