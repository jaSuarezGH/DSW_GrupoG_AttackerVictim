package dtos;

import com.ucab.cmcapp.common.exceptions.BadIdException;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import com.ucab.cmcapp.logic.dtos.BaseDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseDtoTest {

    // Al ser una clase abstracta, se instancia una clase hija para trabajar con ella.
    @Test
    public void testConstructorWithoutId() {
        BaseDto baseDto = new AdministratorDto();
        assertEquals(0, baseDto.getId());
    }

    @Test
    public void testConstructorWithValidId() {
        long id = 1L;
        BaseDto baseDto = new AdministratorDto(id);
        assertEquals(id, baseDto.getId());
    }

    @Test
    public void testSetIdWithValidId() {
        BaseDto baseDto = new AdministratorDto();
        long id = 2L;
        baseDto.setId(id);
        assertEquals(id, baseDto.getId());
    }

    @Test
    public void testSetIdWithInvalidId() {
        BaseDto baseDto = new AdministratorDto();
        long invalidId = -1L;
        assertThrows(BadIdException.class, () -> baseDto.setId(invalidId));
    }
}
