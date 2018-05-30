package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.database.DatabaseAccess;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by lucienzimmermann on 24.05.18.
 */
@Path("/RegisterServicesV1")
public class RegisterServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/registerDude")
    public Response registerDude(){

        databaseAccess.getEntities();
        return Response.ok().build();
    }


}
