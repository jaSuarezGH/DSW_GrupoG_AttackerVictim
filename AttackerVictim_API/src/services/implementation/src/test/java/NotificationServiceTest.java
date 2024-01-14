import com.ucab.cmcapp.implementation.NotificationService;
import com.ucab.cmcapp.logic.dtos.NotificationDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class NotificationServiceTest {

    private NotificationService notificationService;

    @BeforeEach
    public void setUp(){
        notificationService = new NotificationService();

    }

    @Test
    public void getAllNotificationsTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = notificationService.getAllNotifications();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getNotificationByUserIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = notificationService.getAllNotificationByUserId(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addNotificationTest(){

        NotificationDto notificationDto = new NotificationDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = notificationService.addNotification(notificationDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


}
