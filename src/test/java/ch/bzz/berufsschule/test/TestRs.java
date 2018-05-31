package ch.bzz.berufsschule.test;

import ch.bzz.berufsschule.projekt.data.RoomPO;

import org.junit.Test;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static com.sun.tools.corba.se.idl.toJavaPortable.Arguments.Client;

/**
 * Created by lucienzimmermann on 24.05.18.
 */
public class TestRs {

    @Test
    public void testRegisterDude() throws IOException{

        /*javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/v1/RoomServicesV1/room/1");
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        RoomPO room = response.readEntity(RoomPO.class);
        response.close();*/

    }

}
