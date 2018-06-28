package ch.bzz.berufsschule.projekt.rs;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucienzimmermann on 29.05.18.
 */

@ApplicationPath("/v1")
public class ApplicationV1 extends Application{

    public ApplicationV1(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setTitle("Scrum Projekt - Backend API v1");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/v1");
        beanConfig.setResourcePackage("ch.bzz.berufsschule.projekt.rs");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();

        set.add(RoomServicesV1.class);
        set.add(ReservationServicesV1.class);

        set.add(ApiListingResource.class);
        set.add(SwaggerSerializers.class);

        return set;
    }
}
