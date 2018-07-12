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
 * Web services for every action in connection with Rooms
 */

@Path("/RoomServicesV1")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="Room Service")
public class RoomServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/rooms")
    @ApiOperation(value = "getRoomList", notes = "Returns list of rooms")
    public List<RoomPO> getRoomList(){

        return databaseAccess.getRoomList();
    }

    @GET
    @Path("/rooms/{id}")
    @ApiOperation(value = "getRoomById", notes = "Returns room with given ID")
    public RoomPO getRoomById(@PathParam("id") Integer id){
        return databaseAccess.getRoomById(id);
    }

}
