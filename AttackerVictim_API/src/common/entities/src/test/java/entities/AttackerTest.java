package entities;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttackerTest {

    @Test
    public void testGettersAndSetters() {
        Attacker attacker = new Attacker();
        User user = new User();
        user.set_id(2);

        attacker.set_id(1);
        attacker.set_user(user);

        assertEquals(1, attacker.get_id());
        assertEquals(2, attacker.get_user().get_id());
    }

    @Test
    public void testConstructorWithAttackerParam() {
        User user = new User();
        user.set_id(1);
        user.set_username("testUser");
        user.set_email("testEmail");
        user.set_password("testPassword");
        Attacker originalAttacker = new Attacker();
        originalAttacker.set_user(user);
        Attacker newAttacker = new Attacker(originalAttacker);

        assertEquals(originalAttacker.get_user(), newAttacker.get_user());
    }

    @Test
    public void testConstructorWithIdParam() {
        Attacker attacker = new Attacker(1);

        assertEquals(1, attacker.get_id());
        assertNull(attacker.get_user());
    }

}
