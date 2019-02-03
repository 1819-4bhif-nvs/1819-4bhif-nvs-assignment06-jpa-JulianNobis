package at.htl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rs")
public class MyApplication extends Application {
    // unser RestConfig
    @Override
    public Set<Class<?>> getClasses(){
        HashSet h = new HashSet<Class<?>>();
        h.add(HelloCar.class);
        return h;
    }
}
