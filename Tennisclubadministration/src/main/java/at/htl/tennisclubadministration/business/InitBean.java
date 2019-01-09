package at.htl.tennisclubadministration.business;

import at.htl.tennisclubadministration.model.HobbyPlayer;
import at.htl.tennisclubadministration.model.Tennismatch;
import at.htl.tennisclubadministration.model.Tennisplayer;
import at.htl.tennisclubadministration.model.TournamentPlayer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Startup
@Singleton
public class InitBean {
    @PersistenceContext
    EntityManager em;
    public InitBean(){} // default konstruktor absichtlich leer

    @PostConstruct
    private void init(){
        Tennisplayer julianNobis = new TournamentPlayer("Julian Nobis", 5.0, 2001, 'm', 000001);
        em.persist(julianNobis);
        Tennisplayer yannikLeitner = new TournamentPlayer("Yannik Leitner", 3.5, 1992, 'm', 000002);
        em.persist(yannikLeitner);
        Tennisplayer danGroza = new TournamentPlayer("Dan Groza", 2.4, 1973, 'm', 000003);
        em.persist(danGroza);
        Tennisplayer philippBräuer = new TournamentPlayer("Philipp Bräuer", 4.4, 1991, 'm', 000004);
        em.persist(philippBräuer);
        Tennisplayer soranaGroza = new HobbyPlayer("Sorana Groza", 9.5, 2004, 'f', true);
        em.persist(soranaGroza);
        Tennisplayer sofiaGroza = new HobbyPlayer("Sofia Groza", 8.8, 2002, 'f', true);
        em.persist(sofiaGroza);
        Tennisplayer lukasStransky = new HobbyPlayer("Lukas Stransky", 8.0, 2000, 'm', false);
        em.persist(lukasStransky);

        List<Tennisplayer> playersFirstMatch = new LinkedList<>(); // doppel
        playersFirstMatch.add(julianNobis);
        playersFirstMatch.add(yannikLeitner);
        playersFirstMatch.add(danGroza);
        playersFirstMatch.add(philippBräuer);
        em.persist(new Tennismatch(LocalDate.of(2018, 12, 7), playersFirstMatch));

        List<Tennisplayer> playersSecondMatch = new LinkedList<>(); // einzel
        playersFirstMatch.add(sofiaGroza);
        playersFirstMatch.add(soranaGroza);
        em.persist(new Tennismatch(LocalDate.of(2018, 12, 8), playersSecondMatch));

    }
}
