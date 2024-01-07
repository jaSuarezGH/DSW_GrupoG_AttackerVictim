package mappers;

import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.NotificationDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.NotificationMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotificationMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        NotificationDto notificationDto = new NotificationDto();
        UserDto userDto = new UserDto();
        userDto.setId(1);

        notificationDto.setId(1);
        notificationDto.set_full_date(new Date());
        notificationDto.set_status("test status");
        notificationDto.set_user(userDto);

        Notification notification = NotificationMapper.mapDtoToEntity(notificationDto);

        assertEquals(notificationDto.getId(), notification.get_id());
        assertEquals(notificationDto.get_full_date(), notification.get_full_date());
        assertEquals(notificationDto.get_status(), notification.get_status());
        assertEquals(notificationDto.get_user().getId(), notification.get_user().get_id());

    }

    @Test
    public void mapEntityToDtoTest() {
        Notification notification = new Notification();

        notification.set_id(1);
        notification.set_full_date(new Date());
        notification.set_status("test status");
        notification.set_user(new User(1));

        NotificationDto notificationDto = NotificationMapper.mapEntityToDto(notification);

        assertEquals(notificationDto.getId(), notification.get_id());
        assertEquals(notificationDto.get_full_date(), notification.get_full_date());
        assertEquals(notificationDto.get_status(), notification.get_status());
        assertEquals(notificationDto.get_user().getId(), notification.get_user().get_id());

    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        Notification notification = NotificationMapper.mapDtoToEntity(1);

        assertEquals(1, notification.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<Notification> entityList = new ArrayList<>();
        Notification notification = new Notification();
        notification.set_id(1);
        notification.set_full_date(new Date());
        notification.set_status("test status");
        notification.set_user(new User(1));
        entityList.add(notification);

        List<NotificationDto> dtoList = NotificationMapper.mapEntityListToDtoList(entityList);

        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_full_date(), dtoList.get(0).get_full_date());
        assertEquals(entityList.get(0).get_status(), dtoList.get(0).get_status());
        assertEquals(entityList.get(0).get_user().get_id(), dtoList.get(0).get_user().getId());
    }

    @Test
    public void mapDtoToEntityUserIdTest() {
        Notification notification = NotificationMapper.mapDtoToEntityUserId(1);

        assertEquals(1, notification.get_user().get_id());
    }

}
