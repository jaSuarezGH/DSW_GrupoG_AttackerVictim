package mappers;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoryMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        HistoryDto historyDto = new HistoryDto();
        historyDto.setId(1);
        historyDto.set_full_date(new Date());
        historyDto.set_latitude(99.0);
        historyDto.set_longitude(98.0);
        historyDto.set_status("test");
        historyDto.set_user(userDto);

        History history = HistoryMapper.mapDtoToEntity(historyDto);

        assertEquals(history.get_id(), historyDto.getId());
        assertEquals(history.get_full_date(), historyDto.get_full_date());
        assertEquals(history.get_latitude(), historyDto.get_latitude());
        assertEquals(history.get_longitude(), historyDto.get_longitude());
        assertEquals(history.get_status(), historyDto.get_status());
        assertEquals(history.get_user().get_id(), historyDto.get_user().getId());
    }

    @Test
    public void mapEntityToDtoTest() {
        History history = new History(1);
        history.set_full_date(new Date());
        history.set_latitude(99.0);
        history.set_longitude(98.0);
        history.set_status("test");
        history.set_user(new User(1));

        HistoryDto historyDto = HistoryMapper.mapEntityToDto(history);

        assertEquals(historyDto.getId(), history.get_id());
        assertEquals(historyDto.get_full_date(), history.get_full_date());
        assertEquals(historyDto.get_latitude(), history.get_latitude());
        assertEquals(historyDto.get_longitude(), history.get_longitude());
        assertEquals(historyDto.get_status(), history.get_status());
        assertEquals(historyDto.get_user().getId(), history.get_user().get_id());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        History history = HistoryMapper.mapDtoToEntity(1);

        assertEquals(1, history.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<History> entityList = new ArrayList<>();
        History history = new History(1);
        history.set_user(new User(1));
        entityList.add(history);

        List<HistoryDto> dtoList = HistoryMapper.mapEntityListToDtoList(entityList);


        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_user().get_id(), dtoList.get(0).get_user().getId());
    }

    @Test
    public void mapDtoToEntityUserIdTest() {
        History history = HistoryMapper.mapDtoToEntityUserId(1);

        assertEquals(1, history.get_user().get_id());
    }

}
