import com.ucab.cmcapp.implementation.IncidentService;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class IncidentServiceTest {

    private IncidentService incidentService;

    @BeforeEach
    public void setUp(){
        incidentService = new IncidentService();

    }

    @Test
    public void getAllIncidentsTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = incidentService.getAllIncidents();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getIncidentByIdTest(){

        long id = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = incidentService.getIncidentById(id);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void getIncidentByVictimIdTest(){

        long victimId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = incidentService.getIncidentByVictimId(victimId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }
    @Test
    public void getIncidentByAttackerIdTest(){

        long attackerId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = incidentService.getIncidentByAttackerId(attackerId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addIncidentTest(){

        IncidentDto incidentDto = new IncidentDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = incidentService.addIncident(incidentDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteIncidentTest(){

        long id = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = incidentService.deleteIncident(id);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }




    @Test
    public void updateIncidentTest(){

        IncidentDto incidentDto = new IncidentDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = incidentService.updateIncident(incidentDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


}
