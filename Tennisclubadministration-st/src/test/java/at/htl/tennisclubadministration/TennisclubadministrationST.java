package at.htl.tennisclubadministration;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // von einem klassenkameraden empfohlen (vermutlich nicht notwendig)
public class TennisclubadministrationST {
    private static EntityManager em;
    private static WebTarget target;
    private static Client client;

    @BeforeClass
    public static void init(){
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8181/tennisclubadministration/api");
        em = Persistence.createEntityManagerFactory("dbPU").createEntityManager();
    }

    @Test
    public void test_FindAllTennisplayers(){
        Response response = (Response) target.path("tennisplayer/find/all").request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(response.getStatus(), is(200));
        JsonArray jArray = response.readEntity(JsonArray.class);
        assertThat(jArray.size(), greaterThanOrEqualTo(1));
    }

    @Test
    public void test_findTennisplayerWithId_1(){
        JsonObject response = target.path("tennisplayer/find/1").request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(response.getString("name"), startsWith("Julian"));
        assertThat(response.getInt("year_born"), is(2001));
    }

    @Test
    public void test_updateTennisplayerWithId_1(){
        JsonObject tennisplayer =  Json
                .createObjectBuilder()
                .add("name", "Julian Novy") // war vorher "Julian Nobis"
                .add("itn", 5.0)
                .add("year_born", 2001)
                .add("sex", 'm')
                .build();
        target.path("tennisplayer/put/1").request().put(Entity.json(tennisplayer));
        JsonObject response = target.path("tennisplayer/find/1").request(MediaType.APPLICATION_JSON).get().readEntity(JsonObject.class);
        assertThat(response.getString("name"), is("Julian Novy"));
        assertThat(response.getInt("year_born"), is(2001));
    }

    @Test
    public void test_createTennisplayer(){
        JsonObject tennisplayer =  Json
                .createObjectBuilder()
                .add("name", "Alex Bräuer")
                .add("itn", 3.7)
                .add("year_born", 1989)
                .add("sex", 'm')
                .build();
        Response response = target.path("tennisplayer/post").request().post(Entity.json(tennisplayer));
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void test_deleteTennisplayer(){
        Response response = target.path("tennisplayer/delete/1").request().delete();
        assertThat(response.getStatus(), is(Response.Status.NO_CONTENT.getStatusCode()));
    }
}
