package mappers;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.set_firstname("test name");
        userDto.set_lastname("test lastname");
        userDto.set_username("test username");
        userDto.set_personal_id("test personal ID");
        userDto.set_email("test email");
        userDto.set_mac_address("test MAC Address");
        userDto.set_active(true);
        userDto.set_password("test password");

        User user = UserMapper.mapDtoToEntity(userDto);

        assertEquals(user.get_id(), userDto.getId());
        assertEquals(user.get_firstname(), userDto.get_firstname());
        assertEquals(user.get_lastname(), userDto.get_lastname());
        assertEquals(user.get_username(), userDto.get_username());
        assertEquals(user.get_personal_id(), userDto.get_personal_id());
        assertEquals(user.get_email(), userDto.get_email());
        assertEquals(user.get_mac_address(), userDto.get_mac_address());
        assertEquals(user.get_active(), userDto.get_active());
        assertEquals(user.get_password(), userDto.get_password());
    }

    @Test
    public void mapEntityToDtoTest() {
        User user = new User();
        user.set_id(1);
        user.set_firstname("test name");
        user.set_lastname("test lastname");
        user.set_username("test username");
        user.set_personal_id("test personal ID");
        user.set_email("test email");
        user.set_mac_address("test MAC Address");
        user.set_active(true);
        user.set_password("test password");

        UserDto userDto = UserMapper.mapEntityToDto(user);

        assertEquals(user.get_id(), userDto.getId());
        assertEquals(user.get_firstname(), userDto.get_firstname());
        assertEquals(user.get_lastname(), userDto.get_lastname());
        assertEquals(user.get_username(), userDto.get_username());
        assertEquals(user.get_personal_id(), userDto.get_personal_id());
        assertEquals(user.get_email(), userDto.get_email());
        assertEquals(user.get_mac_address(), userDto.get_mac_address());
        assertEquals(user.get_active(), userDto.get_active());
        assertEquals(user.get_password(), userDto.get_password());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        User user = UserMapper.mapDtoToEntity(1);

        assertEquals(1, user.get_id());
    }

    @Test
    public void mapDtoToEntityWithEmailTest() {
        User user = UserMapper.mapDtoToEntityEmail("test email");

        assertEquals("test email", user.get_email());
    }

    @Test
    public void mapDtoToEntityWithUsernameTest() {
        User user = UserMapper.mapDtoToEntityUsername("test username");

        assertEquals("test username", user.get_username());
    }

    @Test
    public void mapDtoToEntityWithPersonalIdTest() {
        User user = UserMapper.mapDtoToEntityPersonalId("11111111");

        assertEquals("11111111", user.get_personal_id());
    }

    @Test
    public void mapDtoToEntityWithMacAddressTest() {
        User user = UserMapper.mapDtoToEntityMacAddress("00-B0-D0-63-C2-26");

        assertEquals("00-B0-D0-63-C2-26", user.get_mac_address());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<User> entityList = new ArrayList<>();
        User user = new User();
        user.set_id(1);
        user.set_firstname("test name");
        user.set_lastname("test lastname");
        user.set_username("test username");
        user.set_personal_id("test personal ID");
        user.set_email("test email");
        user.set_mac_address("test MAC Address");
        user.set_active(true);
        user.set_password("test password");
        entityList.add(user);

        List<UserDto> dtoList = UserMapper.mapEntityListToDtoList(entityList);

        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_firstname(), dtoList.get(0).get_firstname());
        assertEquals(entityList.get(0).get_lastname(), dtoList.get(0).get_lastname());
        assertEquals(entityList.get(0).get_username(), dtoList.get(0).get_username());
        assertEquals(entityList.get(0).get_personal_id(), dtoList.get(0).get_personal_id());
        assertEquals(entityList.get(0).get_email(), dtoList.get(0).get_email());
        assertEquals(entityList.get(0).get_mac_address(), dtoList.get(0).get_mac_address());
        assertEquals(entityList.get(0).get_active(), dtoList.get(0).get_active());
        assertEquals(entityList.get(0).get_password(), dtoList.get(0).get_password());
    }

}
