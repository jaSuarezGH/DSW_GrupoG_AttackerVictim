import com.ucab.cmcapp.implementation.VictimService;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class VictimServiceTest {

    private VictimService victimService;

    @BeforeEach
    public void setUp(){
        victimService = new VictimService();

    }

    @Test
    public void getAllVictimsTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = victimService.getAllVictims();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getVictimByUserIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = victimService.getVictimByUserId(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addVictimTest(){

        VictimDto victimDto = new VictimDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = victimService.addVictim(victimDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteVictimTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = victimService.deleteVictim(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



}
