package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.RoomPO;
import ch.bzz.berufsschule.projekt.database.DatabaseAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by lucienzimmermann on 31.05.18.
 */
@Path("/RoomServicesV1")
@Api(value="Reservation Service")
public class RoomServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/rooms")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET", value = "/rooms", notes = "Returns list of rooms", response = RoomPO.class, responseContainer = "List", produces = MediaType.APPLICATION_JSON)
    public List<RoomPO> getRoomList(){

        return databaseAccess.getRoomList();
    }

    @GET
    @Path("/rooms/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET", value = "/rooms/id", notes = "Returns room with given ID", response = RoomPO.class, produces = MediaType.APPLICATION_JSON)
    public RoomPO getRoomById(@PathParam("id") int id){
        return databaseAccess.getRoomById(id);
    }

}
