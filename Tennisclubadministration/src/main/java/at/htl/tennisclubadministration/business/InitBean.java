package at.htl.tennisclubadministration.business;

import at.htl.tennisclubadministration.model.*;
import javafx.util.Pair;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Startup
@Singleton
public class InitBean {
    @PersistenceContext
    EntityManager em;
    public InitBean(){}

    @PostConstruct
    private void init(){
        System.out.println("reached first persist");

        Team team = new Team("Landesliga C");
        Tennisplayer julianNobis = new TournamentPlayer("Julian Nobis", 5.0, 2001, GenderPlayers.Gender.MALE,0,0,  000001);
        em.persist(julianNobis);
        Tennisplayer yannikLeitner = new TournamentPlayer("Yannik Leitner", 3.5, 1992, GenderPlayers.Gender.MALE, 0, 0, 000002);
        em.persist(yannikLeitner);
        Tennisplayer danGroza = new TournamentPlayer("Dan Groza", 2.4, 1973, GenderPlayers.Gender.MALE, 0, 0, 000003);
        em.persist(danGroza);
        Tennisplayer philippBräuer = new TournamentPlayer("Philipp Bräuer", 4.4, 1991, GenderPlayers.Gender.MALE, 0, 0, 000004);
        em.persist(philippBräuer);
        Tennisplayer soranaGroza = new HobbyPlayer("Sorana Groza", 9.5, 2004, GenderPlayers.Gender.FEMALE, 0, 0, true);
        em.persist(soranaGroza);
        Tennisplayer sofiaGroza = new HobbyPlayer("Sofia Groza", 8.8, 2002, GenderPlayers.Gender.FEMALE, 0, 0, true);
        em.persist(sofiaGroza);
        Tennisplayer lukasStransky = new HobbyPlayer("Lukas Stransky", 8.0, 2000, GenderPlayers.Gender.MALE, 0, 0, false);
        em.persist(lukasStransky);


        team.addTeamMember(julianNobis);
        team.addTeamMember(danGroza);
        team.addTeamMember(philippBräuer);
        team.addTeamMember(yannikLeitner);

        System.out.println("reached second persist");

        em.persist(team);

        Tennismatch firstSingle = new Singles(LocalDate.now(), 140, "6:4 6:7 6:0", julianNobis, philippBräuer, julianNobis);
        Tennismatch secondSingle = new Singles(LocalDate.now(), 70, "6:4 6:1", danGroza, yannikLeitner, danGroza);
        Tennismatch thirdSingle = new Singles(LocalDate.now(), 100, "6:2 6:4", soranaGroza, sofiaGroza, sofiaGroza);

        System.out.println("reached third persist");

        em.persist(firstSingle);
        em.persist(secondSingle);
        em.persist(thirdSingle);


        Map<Tennisplayer, Tennisplayer> firstPairDouble1 = new LinkedHashMap();
        firstPairDouble1.put(julianNobis, danGroza); // geht leider nur als Map, da 'Pair' nicht funktioniert ohne dass man java-openjfx installiert
        Map<Tennisplayer, Tennisplayer> secondPairDouble1 = new LinkedHashMap();
        secondPairDouble1.put(yannikLeitner, philippBräuer);
        Tennismatch firstDouble = new Doubles(LocalDate.now(), 80, "6:4 6:3", firstPairDouble1, secondPairDouble1, firstPairDouble1);

        Map<Tennisplayer, Tennisplayer> firstPairDouble2 = new LinkedHashMap();
        firstPairDouble2.put(sofiaGroza, philippBräuer);
        Map<Tennisplayer, Tennisplayer> secondPairDouble2 = new LinkedHashMap();
        secondPairDouble2.put(soranaGroza, danGroza);
        Tennismatch secondDouble = new Doubles(LocalDate.now(), 110, "7:5 6:7 10:8", firstPairDouble2, secondPairDouble2, secondPairDouble2);

        em.persist(firstDouble);
        em.persist(secondDouble);

    }
}
