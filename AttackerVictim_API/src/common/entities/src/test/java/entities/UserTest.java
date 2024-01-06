package entities;

import com.ucab.cmcapp.common.entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {

    @Test
    public void testGettersAndSetters(){
        User user = new User();
        user.set_id(1);
        user.set_email("test");
        user.set_password("test");
        user.set_username("test");
        user.set_active(true);
        user.set_firstname("test");
        user.set_lastname("test");
        user.set_mac_address("test");
        user.set_personal_id("1");

        assertEquals(1, user.get_id());
        assertEquals("test", user.get_email());
        assertEquals("test", user.get_password());
        assertEquals("test", user.get_username());
        assertEquals(true, user.get_active());
        assertEquals("test", user.get_firstname());
        assertEquals("test", user.get_lastname());
        assertEquals("test", user.get_mac_address());
        assertEquals("1", user.get_personal_id());

    }

    @Test
    public void testUserWithIdParam(){
        User user = new User(1);

        assertEquals(1, user.get_id());
    }

    @Test
    public void testUserWithUserParam(){
        User user1 = new User(1);
        user1.set_username("test");

        User user = new User(user1);
        assertEquals(1, user.get_id());
        assertNull(user.get_email());
        assertNull(user.get_password());
        assertEquals("test", user.get_username());
        assertNull(user.get_active());
        assertNull(user.get_firstname());
        assertNull(user.get_lastname());
        assertNull(user.get_mac_address());
        assertNull(user.get_personal_id());
    }
}
