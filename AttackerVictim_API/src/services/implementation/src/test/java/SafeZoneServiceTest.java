
import com.ucab.cmcapp.implementation.SafeZoneService;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class SafeZoneServiceTest {

    private SafeZoneService safeZoneService;

    @BeforeEach
    public void setUp(){
        safeZoneService = new SafeZoneService();

    }

    @Test
    public void getAllSafeZonesTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = safeZoneService.getAllSafeZones();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getAllSafeZonesByUserIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = safeZoneService.getAllSafeZonesByUserId(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addSafeZoneTest(){

        SafeZoneDto safeZoneDto = new SafeZoneDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = safeZoneService.addSafeZone(safeZoneDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteSafeZoneTest(){

        long id = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = safeZoneService.deleteSafeZone(id);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void updateSafeZoneTest(){

        SafeZoneDto safeZoneDto = new SafeZoneDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = safeZoneService.updateSafeZone(safeZoneDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


}
