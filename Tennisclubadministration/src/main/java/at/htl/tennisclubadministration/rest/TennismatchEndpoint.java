package at.htl.tennisclubadministration.rest;

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

}
