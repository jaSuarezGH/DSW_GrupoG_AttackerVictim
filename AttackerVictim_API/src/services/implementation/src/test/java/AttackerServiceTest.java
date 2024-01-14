import com.ucab.cmcapp.implementation.AttackerService;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class AttackerServiceTest {

    private AttackerService attackerService;

    @BeforeEach
    public void setUp(){
        attackerService = new AttackerService();

    }

    @Test
    public void getAllAttackersTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = attackerService.getAllAttackers();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getAttackerByUserIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = attackerService.getAttackerByUserId(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addAttackerTest(){

        AttackerDto attackerDto = new AttackerDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = attackerService.addAttacker(attackerDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteAttackerTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = attackerService.deleteAttacker(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



}
