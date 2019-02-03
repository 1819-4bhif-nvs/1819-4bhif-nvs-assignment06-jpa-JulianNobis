package at.htl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hellocar")
public class HelloCar { // unser CarEndpoint
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCar(){
        return "Volvo XC60";
    }
}
