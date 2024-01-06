package entities;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.User;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HistoryTest {

    @Test
    public void testGettersAndSetters(){

        User user = new User();
        user.set_id(2);
        History history = new History();

        history.set_id(1);
        history.set_user(user);
        history.set_full_date(new Date(169050918));
        history.set_latitude(1.0000);
        history.set_longitude(1.0000);
        history.set_status("statusTest");

        assertEquals(1, history.get_id());
        assertEquals(2, history.get_user().get_id());
        assertEquals(new Date(169050918), history.get_full_date());
        assertEquals(1.0000, history.get_latitude());
        assertEquals(1.0000, history.get_longitude());
        assertEquals("statusTest", history.get_status());

    }

    @Test
    public void testHistoryWithIdParam(){
        History history = new History(1);

        assertEquals(1, history.get_id());

    }

    @Test
    public void testHistoryWithHistoryParam(){
        History history = new History();
        history.set_id(1);

        History newHistory = new History(history);

        assertEquals(1, newHistory.get_id());


    }


}
