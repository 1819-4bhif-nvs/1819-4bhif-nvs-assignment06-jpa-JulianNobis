package at.htl.tennisclubadministration.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "Tennismatch.findAll", query = "select m from Tennismatch m")
})
public class Tennismatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private LocalDate localDate;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tennisplayer> players;

    // region Constructor
    public Tennismatch(){}
    public Tennismatch(LocalDate localDate, List<Tennisplayer> players){
        this.localDate = localDate;
        this.players = players;
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
        return players;
    }

    public void setPlayers(List<Tennisplayer> players) {
        this.players = players;
    }
    // endregion
}
