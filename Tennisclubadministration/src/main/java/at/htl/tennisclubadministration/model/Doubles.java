package at.htl.tennisclubadministration.model;

import javafx.util.Pair;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@XmlRootElement
@NamedQueries( {
        @NamedQuery(name = "Doubles.findAll", query = "select d from Doubles d"),
        @NamedQuery(name = "Doubles.findById", query = "select d from Doubles d where d.id = ?1"),
        @NamedQuery(name = "Doubles.getWinner", query = "select d.winner from Doubles d")
})
public class Doubles extends Tennismatch {

    @OneToMany
    private Map<Tennisplayer, Tennisplayer> players1 = new LinkedHashMap();
    @OneToMany
    private Map<Tennisplayer, Tennisplayer> players2 = new LinkedHashMap<>();
    @OneToMany
    private Map<Tennisplayer, Tennisplayer> winner = new LinkedHashMap<>();

    // region Constructor
    public Doubles() { }

    public Doubles(LocalDate localDate, int duration, String score, Map<Tennisplayer, Tennisplayer> players1, Map<Tennisplayer, Tennisplayer> players2, Map<Tennisplayer, Tennisplayer> winner) {
        super(localDate, duration, score);
        this.players1 = players1;
        this.players2 = players2;
        this.winner = winner;
    }
    // endregion

    // region Getter & Setter
    public Map<Tennisplayer, Tennisplayer> getPlayers1() {
        return players1;
    }

    public void setPlayers1(Map<Tennisplayer, Tennisplayer> players1) {
        this.players1 = players1;
    }

    public Map<Tennisplayer, Tennisplayer> getPlayers2() {
        return players2;
    }

    public void setPlayers2(Map<Tennisplayer, Tennisplayer> players2) {
        this.players2 = players2;
    }

    public Map<Tennisplayer, Tennisplayer> getWinner() {
        return winner;
    }

    public void setWinner(Map<Tennisplayer, Tennisplayer> winner) {
        this.winner = winner;
    }
    // endregion

}
