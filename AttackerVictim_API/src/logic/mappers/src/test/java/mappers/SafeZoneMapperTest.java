package mappers;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.SafeZoneMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SafeZoneMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        UserDto userDto = new UserDto();
        userDto.setId(1);
        CoordinateDto coordinateDto = new CoordinateDto();
        coordinateDto.setId(1);

        safeZoneDto.setId(1);
        safeZoneDto.set_name("test name");
        safeZoneDto.set_user(userDto);
        safeZoneDto.set_coordinate(coordinateDto);

        SafeZone safeZone = SafeZoneMapper.mapDtoToEntity(safeZoneDto);

        assertEquals(safeZoneDto.getId(), safeZone.get_id());
        assertEquals(safeZoneDto.get_name(), safeZone.get_name());
        assertEquals(safeZoneDto.get_user().getId(), safeZone.get_user().get_id());
        assertEquals(safeZoneDto.get_coordinate().getId(), safeZone.get_coordinate().get_id());

    }

    @Test
    public void mapEntityToDtoTest() {
        SafeZone safeZone = new SafeZone();

        safeZone.set_id(1);
        safeZone.set_name("test name");
        safeZone.set_user(new User(1));
        safeZone.set_coordinate(new Coordinate(1));

        SafeZoneDto safeZoneDto = SafeZoneMapper.mapEntityToDto(safeZone);

        assertEquals(safeZone.get_id(), safeZoneDto.getId());
        assertEquals(safeZone.get_name(), safeZoneDto.get_name());
        assertEquals(safeZone.get_user().get_id(), safeZoneDto.get_user().getId());
        assertEquals(safeZone.get_coordinate().get_id(), safeZoneDto.get_coordinate().getId());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        SafeZone safeZone = SafeZoneMapper.mapDtoToEntity(1);

        assertEquals(1, safeZone.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<SafeZone> entityList = new ArrayList<>();
        SafeZone safeZone = new SafeZone();
        safeZone.set_id(1);
        safeZone.set_name("test name");
        safeZone.set_user(new User(1));
        safeZone.set_coordinate(new Coordinate(1));
        entityList.add(safeZone);

        List<SafeZoneDto> dtoList = SafeZoneMapper.mapEntityListToDtoList(entityList);

        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_name(), dtoList.get(0).get_name());
        assertEquals(entityList.get(0).get_user().get_id(), dtoList.get(0).get_user().getId());
        assertEquals(entityList.get(0).get_coordinate().get_id(), dtoList.get(0).get_coordinate().getId());
    }

    @Test
    public void mapDtoToEntityUserIdTest() {
        SafeZone safeZone = SafeZoneMapper.mapDtoToEntityUserId(1);

        assertEquals(1, safeZone.get_user().get_id());
    }

}
