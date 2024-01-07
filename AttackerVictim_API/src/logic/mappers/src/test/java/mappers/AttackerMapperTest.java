package mappers;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.AttackerMapper;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttackerMapperTest {

    @Test
    public void mapDtoToEntityTest(){
        AttackerDto attackerDto = new AttackerDto();
        attackerDto.setId(1);
        attackerDto.set_user(new UserDto(1));

        Attacker attacker = AttackerMapper.mapDtoToEntity(attackerDto);

        assertEquals(attacker.get_id(), attackerDto.getId());
    }

    public void mapEntityToDtoTest(){

    }

}
