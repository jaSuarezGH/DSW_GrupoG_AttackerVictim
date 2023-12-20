package entities;

import com.ucab.cmcapp.common.entities.Administrator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AdministratorTest {

    @Test
    public void testGettersAndSetters() {
        Administrator admin = new Administrator();
        admin.set_id(1);
        admin.set_username("testUser");
        admin.set_email("test@example.com");
        admin.set_password("testPassword");

        assertEquals(1, admin.get_id());
        assertEquals("testUser", admin.get_username());
        assertEquals("test@example.com", admin.get_email());
        assertEquals("testPassword", admin.get_password());
    }

    @Test
    public void testConstructorWithAdministratorParam() {
        Administrator originalAdmin = new Administrator();
        originalAdmin.set_id(1);
        originalAdmin.set_username("testUser");
        originalAdmin.set_email("test@example.com");
        originalAdmin.set_password("testPassword");
        Administrator newAdmin = new Administrator(originalAdmin);

        assertEquals(originalAdmin.get_username(), newAdmin.get_username());
        assertEquals(originalAdmin.get_email(), newAdmin.get_email());
        assertEquals(originalAdmin.get_password(), newAdmin.get_password());
    }

    @Test
    public void testConstructorWithIdParam() {
        Administrator admin = new Administrator(1);

        assertEquals(1, admin.get_id());
        assertNull(admin.get_username());
        assertNull(admin.get_email());
        assertNull(admin.get_password());
    }

}
