package ch.bzz.berufsschule.projekt.rs;

import ch.bzz.berufsschule.projekt.data.ReservationPO;
import ch.bzz.berufsschule.projekt.data.RoomPO;
import ch.bzz.berufsschule.projekt.database.DatabaseAccess;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by lucienzimmermann on 31.05.18.
 */
@Path("/ReservationServicesV1")
public class ReservationServicesV1 {

    @Inject
    private DatabaseAccess databaseAccess;

    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReservationPO> getReservationList(){

        return databaseAccess.getReservationList();
    }

    @GET
    @Path("/reservations/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReservationPO getReservationList(@PathParam("id") int id){

        return databaseAccess.getReservationById(id);
    }

}
