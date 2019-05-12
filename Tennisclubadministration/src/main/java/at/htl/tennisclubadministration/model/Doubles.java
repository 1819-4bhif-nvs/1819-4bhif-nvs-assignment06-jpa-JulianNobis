package at.htl.tennisclubadministration.model;

import javafx.util.Pair;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Doubles extends Tennismatch {

    private Pair<Tennisplayer, Tennisplayer> players1 = new Pair<>(new Tennisplayer(), new Tennisplayer());
    private Pair<Tennisplayer, Tennisplayer> players2 = new Pair<>(new Tennisplayer(), new Tennisplayer());
    private Pair<Tennisplayer, Tennisplayer> winner = new Pair<>(new Tennisplayer(), new Tennisplayer());

    // region Constructor
    public Doubles() { }

    public Doubles(LocalDate localDate, int duration, String score, Pair<Tennisplayer, Tennisplayer> players1, Pair<Tennisplayer, Tennisplayer> players2, Pair<Tennisplayer, Tennisplayer> winner) {
        super(localDate, duration, score);
        this.players1 = players1;
        this.players2 = players2;
        this.winner = winner;
    }
    // endregion

    // region Getter & Setter
    public Pair<Tennisplayer, Tennisplayer> getPlayers1() {
        return players1;
    }

    public void setPlayers1(Pair<Tennisplayer, Tennisplayer> players1) {
        this.players1 = players1;
    }

    public Pair<Tennisplayer, Tennisplayer> getPlayers2() {
        return players2;
    }

    public void setPlayers2(Pair<Tennisplayer, Tennisplayer> players2) {
        this.players2 = players2;
    }

    public Pair<Tennisplayer, Tennisplayer> getWinner() {
        return winner;
    }

    public void setWinner(Pair<Tennisplayer, Tennisplayer> winner) {
        this.winner = winner;
    }
    // endregion

}
