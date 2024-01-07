package dtos;

import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryDtoTest {

    @Test
    public void testConstructor() {
        HistoryDto historyDto = new HistoryDto();
        assertEquals(0,historyDto.getId());
        assertNull(historyDto.get_full_date());
        assertNull(historyDto.get_status());
        assertNull(historyDto.get_latitude());
        assertNull(historyDto.get_longitude());
        assertNull(historyDto.get_user());
    }

    @Test
    public void testGetSetFullDate() {
        HistoryDto historyDto = new HistoryDto();
        Date fullDate = new Date();
        historyDto.set_full_date(fullDate);
        assertEquals(fullDate, historyDto.get_full_date());
    }

    @Test
    public void testGetSetStatus() {
        HistoryDto historyDto = new HistoryDto();
        String status = "Active";
        historyDto.set_status(status);
        assertEquals(status, historyDto.get_status());
    }

    @Test
    public void testGetSetLatitude() {
        HistoryDto historyDto = new HistoryDto();
        Double latitude = 10.5;
        historyDto.set_latitude(latitude);
        assertEquals(latitude, historyDto.get_latitude());
    }

    @Test
    public void testGetSetLongitude() {
        HistoryDto historyDto = new HistoryDto();
        Double longitude = -66.8;
        historyDto.set_longitude(longitude);
        assertEquals(longitude, historyDto.get_longitude());
    }

    @Test
    public void testGetSetUser() {
        HistoryDto historyDto = new HistoryDto();
        UserDto user = new UserDto();
        historyDto.set_user(user);
        assertEquals(user, historyDto.get_user());
    }

    @Test
    public void testGetSetId() {
        HistoryDto historyDto = new HistoryDto();
        Long id = 1L;
        historyDto.setId(id);
        assertEquals(id, historyDto.getId());
    }
}
