import com.ucab.cmcapp.implementation.NotificationService;
import com.ucab.cmcapp.implementation.OperationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class OperationServiceTest {

    private OperationService operationService;

    @BeforeEach
    public void setUp(){
        operationService = new OperationService();

    }

    @Test
    public void getSeparationDistanceByIncidentIdTest(){

        long incidentId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = operationService.getSeparationDistanceByIncidentId(incidentId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



    @Test
    public void getAttackerVictimLastPositionsByIncidentIdTest(){

        long incidentId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = operationService.getAttackerVictimLastPositionsByIncidentId(incidentId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getAttackerLastPositionsByIncidentIdTest(){

        long incidentId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = operationService.getAttackerLastPositionsByIncidentId(incidentId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



    @Test
    public void getVictimLastPositionsByIncidentIdTest(){

        long incidentId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = operationService.getVictimLastPositionsByIncidentId(incidentId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



    @Test
    public void getVerifyAttackerInSafeZoneTest(){

        long incidentId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = operationService.getVerifyAttackerInSafeZone(incidentId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



}
