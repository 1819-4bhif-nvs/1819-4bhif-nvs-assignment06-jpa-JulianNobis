package at.htl.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "Tennismatch.findAll", query = "select m from Tennismatch m join fetch m.tennisplayers")
})
public class Tennismatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private LocalDate localDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @XmlTransient
    @JoinTable(
            name="TENNISPLAYER_TENNISMATCH",
            joinColumns = @JoinColumn(name = "TENNISMATCH_ID"),
            inverseJoinColumns = @JoinColumn(name = "TENNISPLAYER_ID")
    )
    private List<Tennisplayer> tennisplayers;

    // region Constructor
    public Tennismatch(){}
    public Tennismatch(LocalDate localDate, List<Tennisplayer> players){
        this.localDate = localDate;
        this.tennisplayers = players;
    }
    // endregion

    // region Getter & Setter
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<Tennisplayer> getPlayers() {
        return tennisplayers;
    }

    public void setPlayers(List<Tennisplayer> players) {
        this.tennisplayers = players;
    }

    // endregion

    public void addPlayer(Tennisplayer tennisplayer) {
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
    }
}
