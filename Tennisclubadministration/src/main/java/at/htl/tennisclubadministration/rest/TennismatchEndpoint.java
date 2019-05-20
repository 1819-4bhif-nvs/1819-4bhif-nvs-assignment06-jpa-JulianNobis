package at.htl.tennisclubadministration.rest;

import at.htl.tennisclubadministration.model.Doubles;
import at.htl.tennisclubadministration.model.Singles;
import at.htl.tennisclubadministration.model.Tennismatch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("tennismatch")
public class TennismatchEndpoint {

    @PersistenceContext
    EntityManager em;

    @Path("find/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tennismatch> findAll(){
        return em.createNamedQuery("Tennismatch.findAll", Tennismatch.class).getResultList();
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tennismatch find(@PathParam("id") Long id){
        return em.find(Tennismatch.class, id);
    }

    @Path("find/singles/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Singles> findAllSingles(){
        return em.createNamedQuery("Singles.findAll", Singles.class).getResultList();
    }

    @Path("find/doubles/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doubles> findAllDoubles(){
        return em.createNamedQuery("Doubles.findAll", Doubles.class).getResultList();
    }

    @Path("find/singles/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Singles findSingles(@PathParam("id") Long id){
        return em.find(Singles.class, id);
    }

    @Path("find/doubles/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Doubles findDoubles(@PathParam("id") Long id){
        return em.find(Doubles.class, id);
    }

}
