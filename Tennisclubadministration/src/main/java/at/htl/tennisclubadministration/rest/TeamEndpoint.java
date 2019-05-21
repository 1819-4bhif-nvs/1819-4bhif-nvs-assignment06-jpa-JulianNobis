package at.htl.tennisclubadministration.rest;

import at.htl.tennisclubadministration.model.Team;
import at.htl.tennisclubadministration.model.Tennismatch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("team")
public class TeamEndpoint {

    @PersistenceContext
    EntityManager em;

    @Path("find/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Team> teams = em.createNamedQuery("Team.findAll", Team.class).getResultList();
        if (teams == null || teams.size() == 0){
            return Response.noContent().build();
        }
        return Response.ok(teams).build();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id){
        Team team = em.find(Team.class, id);
        if(team == null){
            return Response.noContent().build();
        }
        return Response.ok(team).build();
    }

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTeam(Team team){
        em.persist(team);
        em.flush();
        return Response.created(URI.create("http://localhost:8080/tennisclubadministration/api/team/find/" + team.getId())).build();
    }

}
