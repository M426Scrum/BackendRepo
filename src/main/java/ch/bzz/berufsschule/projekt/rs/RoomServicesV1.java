package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.RoomPO;
import ch.bzz.berufsschule.projekt.database.DatabaseAccess;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by lucienzimmermann on 31.05.18.
 */
@Path("/RoomServicesV1")
public class RoomServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoomPO> getRoomList(){

        return databaseAccess.getRoomList();
    }

    @GET
    @Path("/rooms/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RoomPO getRoomById(@PathParam("id") int id){
        return databaseAccess.getRoomById(id);
    }

}
