package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.EventPO;
import ch.bzz.berufsschule.projekt.data.ReservationDTO;
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
 * Web services for every action in connection with Reservations
 */

@Path("/ReservationServicesV1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value="Reservation Service")
public class ReservationServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/reservations")
    @ApiOperation(value = "getReservationList", notes = "Returns list of reservations")
    public List<ReservationPO> getReservationList(){

        return databaseAccess.getReservationList();
    }

    @GET
    @Path("/reservations/{id}")
    @ApiOperation(value = "getReservationById", notes = "Returns reservation with given ID")
    public ReservationPO getReservationById(@PathParam("id") int id){

        return databaseAccess.getReservationById(id);
    }

    @GET
    @Path("/reservation/room/{id}")
    @ApiOperation(value = "getReservationListForRoom", notes = "Returns list reservations with given roomId")
    public List<ReservationPO> getReservationListForRoom(@PathParam("id") int roomId){

        return databaseAccess.getReservationListForRoom(roomId);

    }

    @PUT
    @Path("/reservation")
    @ApiOperation(value = "addReservation", notes = "Adds a new reservation")
    public Response addReservation(ReservationDTO aReservation) {

        RoomPO roomPO = databaseAccess.getRoomById(aReservation.getRoomId());
        EventPO eventPO = databaseAccess.getEventById(aReservation.getEventId());

        ReservationPO reservationPO = new ReservationPO(aReservation.getStart(), aReservation.getEnd(), new RoomPO(roomPO.getRoomId(), roomPO.getName(), roomPO.getDescription()), new EventPO(eventPO.getEventId(), eventPO.getTitle(), eventPO.getDescription(),eventPO.getOrganiser()));

        try {
            databaseAccess.addReservation(reservationPO);
        } catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Reservation konnte nicht hinzugefügt werden.").build();
        }

        return Response.ok().build();
    }

}
