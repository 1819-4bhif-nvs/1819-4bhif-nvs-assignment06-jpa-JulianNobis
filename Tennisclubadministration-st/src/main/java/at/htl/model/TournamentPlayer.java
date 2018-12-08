package at.htl.model;

import javax.persistence.Entity;

@Entity
public class TournamentPlayer extends Tennisplayer {
    private int licenseNumber;

    // region Constructor
    public TournamentPlayer(){}
    public TournamentPlayer(String name, double itn, int year_born, char sex, int licenseNumber){
        super(name, itn, year_born, sex);
        this.licenseNumber = licenseNumber;
    }
    // endregion

    // region Getter & Setter
    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    // endregion
}
