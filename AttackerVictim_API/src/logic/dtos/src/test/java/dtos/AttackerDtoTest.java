package dtos;

import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackerDtoTest {

    @Test
    public void testConstructorWithoutId() {
        AttackerDto attackerDto = new AttackerDto();
        assertNull(attackerDto.get_user());
    }

    @Test
    public void testConstructorWithId() {
        AttackerDto attackerDto = new AttackerDto(1);
        assertEquals(1, attackerDto.getId());
        assertNull(attackerDto.get_user());
    }

    @Test
    public void testGetSetUser() {
        UserDto userDto = new UserDto();
        AttackerDto attackerDto = new AttackerDto();
        attackerDto.set_user(userDto);
        assertEquals(userDto, attackerDto.get_user());
    }
}
