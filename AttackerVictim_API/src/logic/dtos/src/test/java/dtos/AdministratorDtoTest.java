package dtos;

import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministratorDtoTest {

    @Test
    public void testConstructorWithoutId() {
        AdministratorDto administratorDto = new AdministratorDto();
        assertNull(administratorDto.get_username());
        assertNull(administratorDto.get_email());
        assertNull(administratorDto.get_password());
    }

    @Test
    public void testConstructorWithId() {
        AdministratorDto administratorDto = new AdministratorDto(1);
        assertEquals(1, administratorDto.getId());
        assertNull(administratorDto.get_username());
        assertNull(administratorDto.get_email());
        assertNull(administratorDto.get_password());
    }

    @Test
    public void testGetSetUsername() {
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.set_username("test");
        assertEquals("test", administratorDto.get_username());
    }

    @Test
    public void testGetSetEmail() {
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.set_email("test");
        assertEquals("test", administratorDto.get_email());
    }

    @Test
    public void testGetSetPassword() {
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.set_password("test");
        assertEquals("test", administratorDto.get_password());
    }
}
