package at.htl.model;

import javax.persistence.Entity;

@Entity
public class HobbyPlayer extends Tennisplayer{
    private boolean playsHobbycup;

    // region Constructor
    public HobbyPlayer(){}
    public HobbyPlayer(String name, double itn, int year_born, char sex, boolean playsHobbycup){
        super(name, itn, year_born, sex);
        this.playsHobbycup = playsHobbycup;
    }
    // endregion

    // region Getter & Setter
    public boolean isPlaysHobbycup() {
        return playsHobbycup;
    }

    public void setPlaysHobbycup(boolean playsHobbycup) {
        this.playsHobbycup = playsHobbycup;
    }
    // endregion
}
