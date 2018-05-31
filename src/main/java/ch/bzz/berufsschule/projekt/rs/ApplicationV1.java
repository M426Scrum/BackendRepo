package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.ReservationPO;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucienzimmermann on 29.05.18.
 */

@ApplicationPath("/v1")
public class ApplicationV1 extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();

        set.add(RoomServicesV1.class);
        set.add(ReservationServicesV1.class);
        return set;
    }
}
