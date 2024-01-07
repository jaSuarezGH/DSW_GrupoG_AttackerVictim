package mappers;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.AttackerMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VictimMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        VictimDto victimDto = new VictimDto();
        victimDto.setId(1);
        victimDto.set_user(new UserDto(1));

        Victim victim = VictimMapper.mapDtoToEntity(victimDto);

        assertEquals(victim.get_id(), victimDto.getId());
    }

    @Test
    public void mapEntityToDtoTest() {
        Victim victim = new Victim();
        User user = new User(1);
        victim.set_id(1);
        victim.set_user(user);
        VictimDto victimDto = VictimMapper.mapEntityToDto(victim);

        assertEquals(victim.get_id(), victimDto.getId());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        Victim victim = VictimMapper.mapDtoToEntity(1);

        assertEquals(1, victim.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<Victim> entityList = new ArrayList<>();
        Victim victim = new Victim(1);
        victim.set_user(new User(1));
        entityList.add(victim);
        List<VictimDto> dtoList = VictimMapper.mapEntityListToDtoList(entityList);

        assertEquals(1, dtoList.get(0).getId());
    }

    @Test
    public void mapDtoToEntityUserIdTest() {
        Victim victim = VictimMapper.mapDtoToEntityUserId(1);

        assertEquals(1, victim.get_user().get_id());
    }

}
