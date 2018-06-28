package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.ReservationPO;
import ch.bzz.berufsschule.projekt.data.RoomPO;
import ch.bzz.berufsschule.projekt.database.DatabaseAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by lucienzimmermann on 31.05.18.
 */
@Path("/ReservationServicesV1")
@Api(value="Reservation Service")
public class ReservationServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET", value = "/reservations", notes = "Returns list of reservations", response = ReservationPO.class, responseContainer = "List", produces = MediaType.APPLICATION_JSON)
    public List<ReservationPO> getReservationList(){

        return databaseAccess.getReservationList();
    }

    @GET
    @Path("/reservations/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET", value = "/reservations/id", notes = "Returns reservation with given ID", response = ReservationPO.class, produces = MediaType.APPLICATION_JSON)
    public ReservationPO getReservationList(@PathParam("id") int id){

        return databaseAccess.getReservationById(id);
    }

    @GET
    @Path("/reservationsForRoom/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET", value = "/reservationsForRoom/id", notes = "Returns list reservations with given roomId", response = ReservationPO.class, produces = MediaType.APPLICATION_JSON)
    public List<ReservationPO> getReservationListForRoom(@PathParam("id") int roomId){

        return databaseAccess.getReservationListForRoom(roomId);

    }

    @PUT
    @Path("/addReservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "PUT",value = "/addReservation", notes = "Adds a new reservation", response = Response.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Response addReservation(ReservationPO aReservation) {

        ReservationPO reservationPO = new ReservationPO(aReservation.getStart(), aReservation.getEnd(), aReservation.getRoomId(), aReservation.getEventId());

        try {
            databaseAccess.addReservation(reservationPO);
        } catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Reservation konnte nicht hinzugefügt werden.").build();
        }

        return Response.ok().build();
    }

}
