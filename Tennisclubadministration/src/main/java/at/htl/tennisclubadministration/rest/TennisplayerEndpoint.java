package at.htl.tennisclubadministration.rest;

import at.htl.tennisclubadministration.model.Tennisplayer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("tennisplayer")
@Stateless //Transaktionen werden nun abgehandelt, ohne dass man selber eingreifen muss
public class TennisplayerEndpoint {
    @PersistenceContext
    EntityManager em;

    @Path("find/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tennisplayer> findAll(){
        return em.createNamedQuery("Tennisplayer.findAll", Tennisplayer.class).getResultList();
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tennisplayer find(@PathParam("id") Long id){
        return em.find(Tennisplayer.class, id);
        //return em.createNamedQuery("Tennisplayer.findById", Tennisplayer.class).setParameter(1, id).getSingleResult();
    }

    @Path("get/bestplayer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tennisplayer getBestPlayer(){
        return em.createNamedQuery("Tennisplayer.getBestPlayer", Tennisplayer.class).getSingleResult();
    }

    @Path("delete/{id}")
    @DELETE
    @Transactional
    public void delete(@PathParam("id") Long id){
        Tennisplayer t = em.find(Tennisplayer.class, id);
        em.remove(t);
    }

    @Path("put/{id}")
    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(@PathParam("id") Long id, Tennisplayer tennisplayer){
        Tennisplayer t = em.find(Tennisplayer.class, id);
        t.setItn(tennisplayer.getItn());
        t.setName(tennisplayer.getName());
        t.setSex(tennisplayer.getSex());
        t.setYear_born(tennisplayer.getYear_born());
        em.merge(t);
    }

    @Path("post")
    @POST
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Long post(Tennisplayer tennisplayer){
        em.persist(tennisplayer);
        em.flush(); // notwendig
        return tennisplayer.getId();
    }

}
