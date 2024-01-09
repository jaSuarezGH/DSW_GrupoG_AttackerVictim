package dtos;

import com.ucab.cmcapp.logic.dtos.NotificationDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationDtoTest {

    @Test
    public void testConstructor() {
        NotificationDto notificationDto = new NotificationDto();
        assertEquals(0,notificationDto.getId());
        assertNotNull(notificationDto.get_full_date());
        assertNull(notificationDto.get_status());
        assertNull(notificationDto.get_user());
    }

    @Test
    public void testGetSetFullDate() {
        NotificationDto notificationDto = new NotificationDto();
        Date fullDate = new Date();
        notificationDto.set_full_date(fullDate);
        assertEquals(fullDate, notificationDto.get_full_date());
    }

    @Test
    public void testGetSetStatus() {
        NotificationDto notificationDto = new NotificationDto();
        String status = "Active";
        notificationDto.set_status(status);
        assertEquals(status, notificationDto.get_status());
    }

    @Test
    public void testGetSetUser() {
        NotificationDto notificationDto = new NotificationDto();
        UserDto user = new UserDto();
        notificationDto.set_user(user);
        assertEquals(user, notificationDto.get_user());
    }

    @Test
    public void testGetSetId() {
        NotificationDto notificationDto = new NotificationDto();
        Long id = 1L;
        notificationDto.setId(id);
        assertEquals(id, notificationDto.getId());
    }

}
