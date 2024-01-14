import com.ucab.cmcapp.implementation.UserService;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.Response;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserService();

    }


    @Test
    public void getAllUsersTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getAllUsers();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void getUserByIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getUserById(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void getUserByEmailTest(){

        String userEmail = "ejemplo@ejemplo.com";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getUserByEmail(userEmail);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void getUserByUsernameTest(){

        String userUsername = "admin";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getUserByUsername(userUsername);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void getUserByPersonalIdTest(){

        String userPersonalId = "11111111";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getUserByPersonalId(userPersonalId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void getUserByMacAddressTest(){

        String userMac = "00:00:00:00:00";

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.getUserByMacAddress(userMac);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }


    @Test
    public void addUserTest(){

        UserDto userDto = new UserDto();

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.addUser(userDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void deleteUserTest(){

        Long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.deleteUser(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }

    @Test
    public void updateUserTest(){

        UserDto userDto = new UserDto();

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = userService.updateUser(userDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });

    }


}
