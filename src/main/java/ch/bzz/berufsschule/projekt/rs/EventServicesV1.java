package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.EventPO;
import ch.bzz.berufsschule.projekt.data.ReservationPO;
import ch.bzz.berufsschule.projekt.database.DatabaseAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by lucienzimmermann on 05.07.18.
 * Web services for every action in connection with Events
 */

@Path("/EventServicesV1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value="Event Service")
public class EventServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/events")
    @ApiOperation(value = "getEventLost", notes = "Returns list of events")
    public List<EventPO> getEventList(){

        return databaseAccess.getEventList();
    }

    @GET
    @Path("/events/{id}")
    @ApiOperation(value = "getEventById", notes = "Returns event with given ID")
    public EventPO getEventById(@PathParam("id") int id){

        return databaseAccess.getEventById(id);
    }


}
