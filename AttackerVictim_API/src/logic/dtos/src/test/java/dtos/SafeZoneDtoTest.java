package dtos;

import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SafeZoneDtoTest {

    @Test
    public void testConstructor() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        assertEquals(0, safeZoneDto.getId());
        assertNull(safeZoneDto.get_name());
        assertNull(safeZoneDto.get_user());
        assertNull(safeZoneDto.get_coordinate());
    }

    @Test
    public void testGetSetName() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        String name = "Casa";
        safeZoneDto.set_name(name);
        assertEquals(name, safeZoneDto.get_name());
    }

    @Test
    public void testGetSetUser() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        UserDto user = new UserDto();
        safeZoneDto.set_user(user);
        assertEquals(user, safeZoneDto.get_user());
    }

    @Test
    public void testGetSetCoordinate() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        CoordinateDto coordinate = new CoordinateDto();
        safeZoneDto.set_coordinate(coordinate);
        assertEquals(coordinate, safeZoneDto.get_coordinate());
    }

    @Test
    public void testGetSetId() {
        SafeZoneDto safeZoneDto = new SafeZoneDto();
        Long id = 1L;
        safeZoneDto.setId(id);
        assertEquals(id, safeZoneDto.getId());
    }

}
