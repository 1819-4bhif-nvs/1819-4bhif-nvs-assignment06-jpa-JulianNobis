package at.htl.model;

import jdk.jfr.Name;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NamedQueries({
        @NamedQuery(name = "Tennisplayer.findAll", query = "select t from Tennisplayer t"),
        @NamedQuery(name = "Tennisplayer.findByName", query = "select t from Tennisplayer t where t.name like ?1"),
        @NamedQuery(name = "Tennisplayer.findById", query = "select t from Tennisplayer t where t.id = ?1"),
        @NamedQuery(name = "Tennisplayer.getBestPlayer", query = "select t from Tennisplayer t where t.itn = (select min(t2.itn) from Tennisplayer t2)")
})
public class Tennisplayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;
    protected String name; // firstName <blank> lastName
    protected double itn; //ITN = international tennis number(Indikator für die ungefähre Spielstärke des jew. Spielers)
    protected int year_born;
    protected char sex; // könnte auch ein enum erstellen
    //protected Long club_id; // unwichtig

    // region Constructor
    public Tennisplayer(){}
    public Tennisplayer(String name, double itn, int year_born, char sex){
        this.name = name;
        this.itn = itn;
        this.year_born = year_born;
        this.sex = sex;
    }
    // endregion

    //region Getter & Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getItn() {
        return itn;
    }

    public void setItn(double itn) {
        this.itn = itn;
    }

    public int getYear_born() {
        return year_born;
    }

    public void setYear_born(int year_born) {
        this.year_born = year_born;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    //endregion

}
