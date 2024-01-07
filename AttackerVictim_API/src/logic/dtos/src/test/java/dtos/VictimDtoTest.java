package dtos;

import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VictimDtoTest {

    @Test
    public void testDefaultConstructor() {
        VictimDto victimDto = new VictimDto();
        assertEquals(0,victimDto.getId());
        assertNull(victimDto.get_user());
    }

    @Test
    public void testConstructorWithId() {
        long id = 1L;
        VictimDto victimDto = new VictimDto(id);
        assertEquals(id, victimDto.getId());
        assertNull(victimDto.get_user());
    }

    @Test
    public void testGetSetUser() {
        VictimDto victimDto = new VictimDto();
        UserDto user = new UserDto();
        victimDto.set_user(user);
        assertEquals(user, victimDto.get_user());
    }

}
