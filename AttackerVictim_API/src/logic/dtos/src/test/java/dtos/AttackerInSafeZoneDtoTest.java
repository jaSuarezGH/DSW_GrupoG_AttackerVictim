package dtos;

import com.ucab.cmcapp.logic.dtos.AttackerInSafeZoneDto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AttackerInSafeZoneDtoTest {

    @Test
    public void testConstructor() {
        AttackerInSafeZoneDto attackerInSafeZoneDto = new AttackerInSafeZoneDto();
        assertNull(attackerInSafeZoneDto.get_inside());
        assertTrue(attackerInSafeZoneDto.get_zones().isEmpty());
        assertNull(attackerInSafeZoneDto.get_latitude());
        assertNull(attackerInSafeZoneDto.get_longitude());
    }

    @Test
    public void testGetSetInside() {
        AttackerInSafeZoneDto attackerInSafeZoneDto = new AttackerInSafeZoneDto();
        attackerInSafeZoneDto.set_inside(true);
        assertEquals(true, attackerInSafeZoneDto.get_inside());
    }

    @Test
    public void testGetSetZones() {
        AttackerInSafeZoneDto attackerInSafeZoneDto = new AttackerInSafeZoneDto();
        List<String> zones = Arrays.asList("Zona1", "Zona2");
        attackerInSafeZoneDto.set_zones(zones);
        assertEquals(zones, attackerInSafeZoneDto.get_zones());
    }

    @Test
    public void testGetSetLatitude() {
        AttackerInSafeZoneDto attackerInSafeZoneDto = new AttackerInSafeZoneDto();
        attackerInSafeZoneDto.set_latitude(10.5);
        assertEquals(10.5, attackerInSafeZoneDto.get_latitude());
    }

    @Test
    public void testGetSetLongitude() {
        AttackerInSafeZoneDto attackerInSafeZoneDto = new AttackerInSafeZoneDto();
        attackerInSafeZoneDto.set_longitude(-66.8);
        assertEquals(-66.8, attackerInSafeZoneDto.get_longitude());
    }
}

