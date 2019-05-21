package at.htl.tennisclubadministration.model;

import javax.persistence.Entity;

@Entity
public class TournamentPlayer extends Tennisplayer {
    private Integer licenseNumber; // wrapper klasse wird benoetigt, ansonsten wird ein error geworfen

    // region Constructor
    public TournamentPlayer(){}
    public TournamentPlayer(String name, double itn, int year_born, GenderPlayers.Gender sex, int wins, int losses, Integer licenseNumber){
        super(name, itn, year_born, sex, wins, losses);
        this.licenseNumber = licenseNumber;
    }
    // endregion

    // region Getter & Setter
    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Integer licenseNumber) {
        if (licenseNumber != null){
            this.licenseNumber = licenseNumber;
        } else{
            this.licenseNumber = 0;
        }
    }
    // endregion
}
