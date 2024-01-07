package mappers;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import com.ucab.cmcapp.logic.mappers.AdministratorMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdministratorMapperTest {
    @Test
    void testMapDtoToEntity() {
        AdministratorDto dto = new AdministratorDto();
        dto.setId(1L);
        dto.set_username("username");
        dto.set_email("email");
        dto.set_password("password");

        Administrator entity = AdministratorMapper.mapDtoToEntity(dto);

        assertEquals(1L, entity.get_id());
        assertEquals("username", entity.get_username());
        assertEquals("email", entity.get_email());
        assertEquals("password", entity.get_password());
    }

    @Test
    void testMapEntityToDto() {
        Administrator entity = new Administrator();
        entity.set_id(1L);
        entity.set_username("username");
        entity.set_email("email");
        entity.set_password("password");

        AdministratorDto dto = AdministratorMapper.mapEntityToDto(entity);

        assertEquals(1L, dto.getId());
        assertEquals("username", dto.get_username());
        assertEquals("email", dto.get_email());
        assertEquals("password", dto.get_password());
    }

    @Test
    void testMapDtoToEntityByID() {
        long id = 1L;
        AdministratorDto dto = new AdministratorDto();
        dto.setId(id);

        Administrator entity = AdministratorMapper.mapDtoToEntity(id);

        assertEquals(id, entity.get_id());
    }

    @Test
    void testMapDtoToEntityByEmail() {
        String email = "email";
        AdministratorDto dto = new AdministratorDto();
        dto.set_email(email);

        Administrator entity = AdministratorMapper.mapDtoToEntityEmail(email);


        assertEquals(email, entity.get_email());
    }

    @Test
    void testMapDtoToEntityByUsername() {
        String username = "username";
        AdministratorDto dto = new AdministratorDto();
        dto.set_username(username);

        Administrator entity = AdministratorMapper.mapDtoToEntityUsername(username);

        assertEquals(username, entity.get_username());
    }

    @Test
    void testMapEntityListToDtoList() {
        List<Administrator> entityList = new ArrayList<>();
        entityList.add(new Administrator());
        entityList.add(new Administrator());

        List<AdministratorDto> dtoList = AdministratorMapper.mapEntityListToDtoList(entityList);

        assertEquals(2, dtoList.size());
        assertEquals(0L, dtoList.get(0).getId());
    }
}
