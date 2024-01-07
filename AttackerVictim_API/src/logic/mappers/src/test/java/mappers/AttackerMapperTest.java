package mappers;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.AttackerMapper;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttackerMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        AttackerDto attackerDto = new AttackerDto();
        attackerDto.setId(1);
        attackerDto.set_user(new UserDto(1));

        Attacker attacker = AttackerMapper.mapDtoToEntity(attackerDto);

        assertEquals(attacker.get_id(), attackerDto.getId());
    }

    @Test
    public void mapEntityToDtoTest() {
        Attacker attacker = new Attacker();
        User user = new User(1);
        attacker.set_id(1);
        attacker.set_user(user);
        AttackerDto attackerDto = AttackerMapper.mapEntityToDto(attacker);

        assertEquals(attacker.get_id(), attackerDto.getId());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        Attacker attacker = AttackerMapper.mapDtoToEntity(1);

        assertEquals(1, attacker.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<Attacker> entityList = new ArrayList<>();
        Attacker attacker = new Attacker(1);
        attacker.set_user(new User(1));
        entityList.add(attacker);
        List<AttackerDto> dtoList = AttackerMapper.mapEntityListToDtoList(entityList);

        assertEquals(1, dtoList.get(0).getId());
    }

    @Test
    public void mapDtoToEntityUserIdTest() {
        Attacker attacker = AttackerMapper.mapDtoToEntityUserId(1);

        assertEquals(1, attacker.get_user().get_id());
    }

}
