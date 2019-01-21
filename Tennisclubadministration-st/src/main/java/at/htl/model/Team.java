package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jdk.jfr.Name;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "TENNISTEAM")
@NamedQuery(name = "Team.findAll", query = "select t from Team t")
public class Team {
    // um die aufgabe "1:n bidirektional" zu lösen, kann
    // ein spieler in nur 1 mannschaft spielen
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teamName;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @XmlTransient
    @JsonIgnore
    private List<Tennisplayer> teamPlayers;// = new ArrayList<>();

    // region Constructors
    public Team(){}
    public Team(String teamName){
        this.teamName = teamName;
    }
    // endregion

    // region Getter & Setter
    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Tennisplayer> getTeamPlayerss() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Tennisplayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }
    // endregion

    public void removeTeamMember(Tennisplayer tennisplayer){
        if (teamPlayers!= null && teamPlayers.contains(tennisplayer)){
            tennisplayer.setTeam(null); //Team in Tennisplayer aktualisieren
            teamPlayers.remove(tennisplayer);
        }
    }

    public void addTeamMember(Tennisplayer tennisplayer){
        if (teamPlayers == null){ //liste existiert noch nicht
            teamPlayers = new ArrayList<>();
        }
        tennisplayer.setTeam(this); // Team in Tennisplayer aktualisieren
        teamPlayers.add(tennisplayer);
    }

}
