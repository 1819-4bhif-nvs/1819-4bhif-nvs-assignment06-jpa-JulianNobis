package at.htl.tennisclubadministration.model;

import javafx.util.Pair;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@XmlRootElement
@NamedQueries( {
        @NamedQuery(name = "Doubles.findAll", query = "select d from Doubles d"),
        @NamedQuery(name = "Doubles.findById", query = "select d from Doubles d where d.id = ?1"),
        @NamedQuery(name = "Doubles.getWinners", query = "select d.winner1, d.winner2 from Doubles d")
})
public class Doubles extends Tennismatch {

    @OneToOne
    private Tennisplayer firstTeamPlayer1 = new Tennisplayer();
    @OneToOne
    private Tennisplayer firstTeamPlayer2 = new Tennisplayer();
    @OneToOne
    private Tennisplayer secondTeamPlayer1 = new Tennisplayer();
    @OneToOne
    private Tennisplayer secondTeamPlayer2 = new Tennisplayer();
    @OneToOne
    private Tennisplayer winner1 = new Tennisplayer();
    @OneToOne
    private Tennisplayer winner2 = new Tennisplayer();

    // region Constructor
    public Doubles() { }

    public Doubles(LocalDate localDate, int duration, String score, Tennisplayer firstTeamPlayer1, Tennisplayer firstTeamPlayer2, Tennisplayer secondTeamPlayer1, Tennisplayer secondTeamPlayer2, Tennisplayer winner1, Tennisplayer winner2) {
        super(localDate, duration, score);
        this.firstTeamPlayer1 = firstTeamPlayer1;
        this.firstTeamPlayer2 = firstTeamPlayer2;
        this.secondTeamPlayer1 = secondTeamPlayer1;
        this.secondTeamPlayer2 = secondTeamPlayer2;
        this.winner1 = winner1;
        this.winner2 = winner2;
    }
    // endregion

    // region Getter & Setter
    public Tennisplayer getFirstTeamPlayer1() {
        return firstTeamPlayer1;
    }

    public void setFirstTeamPlayer1(Tennisplayer firstTeamPlayer1) {
        this.firstTeamPlayer1 = firstTeamPlayer1;
    }

    public Tennisplayer getFirstTeamPlayer2() {
        return firstTeamPlayer2;
    }

    public void setFirstTeamPlayer2(Tennisplayer firstTeamPlayer2) {
        this.firstTeamPlayer2 = firstTeamPlayer2;
    }

    public Tennisplayer getSecondTeamPlayer1() {
        return secondTeamPlayer1;
    }

    public void setSecondTeamPlayer1(Tennisplayer secondTeamPlayer1) {
        this.secondTeamPlayer1 = secondTeamPlayer1;
    }

    public Tennisplayer getSecondTeamPlayer2() {
        return secondTeamPlayer2;
    }

    public void setSecondTeamPlayer2(Tennisplayer secondTeamPlayer2) {
        this.secondTeamPlayer2 = secondTeamPlayer2;
    }

    public Tennisplayer getWinner1() {
        return winner1;
    }

    public void setWinner1(Tennisplayer winner1) {
        this.winner1 = winner1;
    }

    public Tennisplayer getWinner2() {
        return winner2;
    }

    public void setWinner2(Tennisplayer winner2) {
        this.winner2 = winner2;
    }
    // endregion

}
