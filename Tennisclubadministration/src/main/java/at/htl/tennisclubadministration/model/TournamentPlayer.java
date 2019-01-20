package at.htl.tennisclubadministration.model;

import javax.persistence.Entity;

@Entity
public class TournamentPlayer extends Tennisplayer {
    private Integer licenseNumber; //wrapper class needed, otherwise an error occuredd

    // region Constructor
    public TournamentPlayer(){}
    public TournamentPlayer(String name, double itn, int year_born, char sex, Integer licenseNumber){
        super(name, itn, year_born, sex);
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
