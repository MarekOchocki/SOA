
import pl.edu.agh.soa.AuthenticateProvider;
import pl.edu.agh.soa.Database;
import pl.edu.agh.soa.MainRestService;

import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(MainRestService.class);
        s.add(AuthenticateProvider.class);
        return s;
    }
}