package dtos;

import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDtoTest {

    @Test
    public void testDefaultConstructor() {
        UserDto userDto = new UserDto();
        assertEquals(0,userDto.getId());
        assertNull(userDto.get_firstname());
        assertNull(userDto.get_lastname());
        assertNull(userDto.get_email());
        assertNull(userDto.get_username());
        assertNull(userDto.get_mac_address());
        assertNull(userDto.get_personal_id());
        assertNull(userDto.get_active());
        assertNull(userDto.get_password());
    }

    @Test
    public void testConstructorWithId() {
        long id = 1L;
        UserDto userDto = new UserDto(id);
        assertEquals(id, userDto.getId());
        assertNull(userDto.get_firstname());
        assertNull(userDto.get_lastname());
        assertNull(userDto.get_email());
        assertNull(userDto.get_username());
        assertNull(userDto.get_mac_address());
        assertNull(userDto.get_personal_id());
        assertNull(userDto.get_active());
        assertNull(userDto.get_password());
    }

    @Test
    public void testGetSetFirstname() {
        UserDto userDto = new UserDto();
        String firstname = "John";
        userDto.set_firstname(firstname);
        assertEquals(firstname, userDto.get_firstname());
    }

    @Test
    public void testGetSetLastname() {
        UserDto userDto = new UserDto();
        String lastname = "Smith";
        userDto.set_lastname(lastname);
        assertEquals(lastname, userDto.get_lastname());
    }

    @Test
    public void testGetSetUsername() {
        UserDto userDto = new UserDto();
        String username = "admin";
        userDto.set_username(username);
        assertEquals(username, userDto.get_username());
    }

    @Test
    public void testGetSetPersonalId() {
        UserDto userDto = new UserDto();
        String personalId = "V-12345678";
        userDto.set_personal_id(personalId);
        assertEquals(personalId, userDto.get_personal_id());
    }

    @Test
    public void testGetSetEmail() {
        UserDto userDto = new UserDto();
        String email = "john.doe@example.com";
        userDto.set_email(email);
        assertEquals(email, userDto.get_email());
    }

    @Test
    public void testGetSetMacAddress() {
        UserDto userDto = new UserDto();
        String macAddress = "00:00:00:00:00:00";
        userDto.set_mac_address(macAddress);
        assertEquals(macAddress, userDto.get_mac_address());
    }

    @Test
    public void testGetSetActive() {
        UserDto userDto = new UserDto();
        Boolean active = true;
        userDto.set_active(active);
        assertEquals(active, userDto.get_active());
    }

    @Test
    public void testGetSetPassword() {
        UserDto userDto = new UserDto();
        String password = "123456";
        userDto.set_password(password);
        assertEquals(password, userDto.get_password());
    }
}
