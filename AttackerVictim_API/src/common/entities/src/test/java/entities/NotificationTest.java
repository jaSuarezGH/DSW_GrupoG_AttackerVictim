package entities;

import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.common.entities.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class NotificationTest {

    @Test
    public void testGettersAndSetters(){
        Notification notification = new Notification();
        User user = new User();
        user.set_id(1);
        notification.set_id(1);
        notification.set_status("test");
        notification.set_full_date(new Date(100000000));
        notification.set_user(user);

        assertEquals(1, notification.get_id());
        assertEquals("test", notification.get_status());
        assertEquals(new Date(100000000), notification.get_full_date());
        assertEquals(1, notification.get_user().get_id());
    }

    @Test
    public void testNotificationWithIdParam(){
        Notification notification = new Notification(1);
        notification.set_status("test");

        assertEquals(1, notification.get_id());
        assertEquals("test", notification.get_status());
    }

    @Test
    public void testNotificationWithNotificationParam(){
        Notification notification = new Notification();
        notification.set_status("test");
        notification.set_id(1);

        Notification notification1 = new Notification(notification);

        assertEquals(1, notification1.get_id());
        assertEquals("test", notification1.get_status());
        assertNull(notification1.get_user());
        assertNull(notification1.get_full_date());
    }
}
