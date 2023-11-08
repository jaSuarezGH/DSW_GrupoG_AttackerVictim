package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class UserMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(UserMapper.class);

    public static User mapDtoToEntity(UserDto dto) throws ParseException {
        User entity = EntityFactory.createUser();

        entity.set_id(dto.getId());
        entity.set_firstname(dto.get_firstname());
        entity.set_lastname(dto.get_lastname());
        entity.set_username(dto.get_username());
        entity.set_personal_id(dto.get_personal_id());
        entity.set_email(dto.get_email());
        entity.set_mac_address(dto.get_mac_address());
        entity.set_active(dto.get_active());

        if (Objects.nonNull(dto.get_userType())) {
            entity.set_userType(UserTypeMapper.mapDtoToEntity(dto.get_userType()));
        }

        return entity;
    }

    public static UserDto mapEntityToDto(User entity) {
        final UserDto dto = new UserDto();


        dto.setId(entity.get_id());
        dto.set_firstname(entity.get_firstname());
        dto.set_lastname(entity.get_lastname());
        dto.set_username(entity.get_username());
        dto.set_personal_id(entity.get_personal_id());
        dto.set_email(entity.get_email());
        dto.set_mac_address(entity.get_mac_address());
        dto.set_active(entity.get_active());

        if (Objects.nonNull(entity.get_userType()))
            dto.set_userType(UserTypeMapper.mapEntityToDto(entity.get_userType()));

        return dto;
    }

    public static User mapDtoToEntity(long id) {
        User entity = EntityFactory.createUser(id);
        entity.set_id(id);
        return entity;
    }

    public static User mapDtoToEntityEmail(String email) {
        User entity = EntityFactory.createUser();
        entity.set_email(email);
        return entity;
    }

    public static User mapDtoToEntityUsername(String username){
        User entity = EntityFactory.createUser();
        entity.set_username(username);
        return entity;
    }

}
