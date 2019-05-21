package at.htl.tennisclubadministration.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
@NamedQueries( {
    @NamedQuery(name = "Singles.findAll", query = "select s from Singles s"),
    @NamedQuery(name = "Singles.findById", query = "select s from Singles s where s.id = ?1"),
    @NamedQuery(name = "Singles.getWinner", query = "select s.winner from Singles s")
})
public class Singles extends Tennismatch {
    @OneToOne
    private Tennisplayer player1 = new Tennisplayer();
    @OneToOne
    private Tennisplayer player2 = new Tennisplayer();
    @OneToOne
    private Tennisplayer winner = new Tennisplayer();

    // region Constructor
    public Singles(){}
    public Singles(LocalDate localDate, int duration, String score, Tennisplayer player1, Tennisplayer player2, Tennisplayer winner){
        super(localDate, duration, score);
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }
    // endregion

    // region Getter & Setter
    public Tennisplayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(Tennisplayer player1) {
        this.player1 = player1;
    }

    public Tennisplayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(Tennisplayer player2) {
        this.player2 = player2;
    }

    public Tennisplayer getWinner() {
        return winner;
    }

    public void setWinner(Tennisplayer winner) {
        this.winner = winner;
    }

    // endregion
}
