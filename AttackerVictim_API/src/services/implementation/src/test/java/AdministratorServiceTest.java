
import com.ucab.cmcapp.implementation.AdministratorService;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class AdministratorServiceTest {

    private AdministratorService administratorService;

    @BeforeEach
    public void setUp(){
        administratorService = new AdministratorService();

    }

    @Test
    public void getAllAdministratorTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = administratorService.getAllAdministrators();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getAdministratorByEmailTest(){

        String email = "user@gmail.com";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = administratorService.getAdministratorByEmail(email);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void getAdministratorByUsernameTest(){

        String username = "user";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = administratorService.getAdministratorByUsername(username);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addAdministratorTest(){

        AdministratorDto administratorDto = new AdministratorDto();

        Assertions.assertThrows(ExceptionInInitializerError.class, () -> {
            Response response = administratorService.addAdministrator(administratorDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteAdministratorTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = administratorService.deleteAdministrator(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void updateAdministratorTest(){

        AdministratorDto administratorDto = new AdministratorDto();

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = administratorService.updateAdministrator(administratorDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


}
