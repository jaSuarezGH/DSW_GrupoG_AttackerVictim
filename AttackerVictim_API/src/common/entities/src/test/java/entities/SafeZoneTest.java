package entities;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SafeZoneTest {

    @Test
    public void testGettersAndSetters(){
        SafeZone safeZone = new SafeZone();
        User user = new User(1);
        Coordinate coordinate = new Coordinate(1);

        safeZone.set_id(1);
        safeZone.set_user(user);
        safeZone.set_coordinate(coordinate);
        safeZone.set_name("test");

        assertEquals(1, safeZone.get_id());
        assertEquals(1, safeZone.get_user().get_id());
        assertEquals(1, safeZone.get_coordinate().get_id());
        assertEquals("test", safeZone.get_name());
    }

    @Test
    public void testSafeZoneWithIdParam(){
        SafeZone safeZone = new SafeZone(1);

        assertEquals(1, safeZone.get_id());
    }

    @Test
    public void testSafeZoneWithSafeZoneParam(){
        SafeZone safeZone = new SafeZone(1);
        safeZone.set_name("test");

        SafeZone safeZone1 = new SafeZone(safeZone);

        assertEquals(1, safeZone1.get_id());
        assertEquals("test", safeZone1.get_name());
        assertNull(safeZone1.get_coordinate());
        assertNull(safeZone1.get_user());
    }
}
