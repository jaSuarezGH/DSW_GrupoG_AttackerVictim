package entities;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VictimTest {

    @Test
    public void testGettersAndSetters(){
        User user = new User();
        Victim victim = new Victim();

        user.set_id(1);

        victim.set_id(2);
        victim.set_user(user);

        assertEquals(2, victim.get_id());
        assertEquals(1, victim.get_user().get_id());

    }

    @Test
    public void testVictimWithIdParam(){
        Victim victimWithId = new Victim(1);

        assertEquals(1, victimWithId.get_id());

    }

    @Test
    public void testVictimWithVictimParam(){
        User user = new User();
        user.set_id(1);
        user.set_email("testEmail");
        user.set_password("testPassword");

        Victim victim = new Victim();
        victim.set_id(2);
        victim.set_user(user);

        Victim victimWithParam = new Victim(victim);

        assertEquals(victim.get_user(), victimWithParam.get_user());
        assertEquals(1, victimWithParam.get_user().get_id());
    }
}
