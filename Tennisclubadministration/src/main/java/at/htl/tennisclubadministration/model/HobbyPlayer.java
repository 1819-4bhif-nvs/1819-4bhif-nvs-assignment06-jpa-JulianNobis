package at.htl.tennisclubadministration.model;

import javax.persistence.Entity;

@Entity
public class HobbyPlayer extends Tennisplayer{
    private Boolean playsHobbycup;

    // region Constructor
    public HobbyPlayer(){}
    public HobbyPlayer(String name, double itn, int year_born, char sex, Boolean playsHobbycup){
        super(name, itn, year_born, sex);
        this.playsHobbycup = playsHobbycup;
    }
    // endregion

    // region Getter & Setter
    public Boolean isPlaysHobbycup() {
        return playsHobbycup;
    }

    public void setPlaysHobbycup(Boolean playsHobbycup) {
        if (this.playsHobbycup != null){
            this.playsHobbycup = playsHobbycup;
        } else{
            this.playsHobbycup = false;
        }
    }
    // endregion
}
