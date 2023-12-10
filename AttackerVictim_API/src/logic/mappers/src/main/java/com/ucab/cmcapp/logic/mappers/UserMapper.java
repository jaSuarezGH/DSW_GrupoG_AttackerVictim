package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
        entity.set_password(dto.get_password());

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
        dto.set_password(entity.get_password());

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

    public static User mapDtoToEntityPersonalId(String personal_id){
        User entity = EntityFactory.createUser();
        entity.set_personal_id(personal_id);
        return entity;
    }

    public static User mapDtoToEntityMacAddress(String mac_address){
        User entity = EntityFactory.createUser();
        entity.set_mac_address(mac_address);
        return entity;
    }

    public static List<UserDto> mapEntityListToDtoList(List<User> entityList){
        List<UserDto> dtoList = new ArrayList<>();
        UserDto userDto;

        for (User user : entityList) {
            userDto = new UserDto();
            userDto.setId(user.get_id());
            userDto.set_firstname(user.get_firstname());
            userDto.set_lastname(user.get_lastname());
            userDto.set_username(user.get_username());
            userDto.set_personal_id(user.get_personal_id());
            userDto.set_email(user.get_email());
            userDto.set_mac_address(user.get_mac_address());
            userDto.set_active(user.get_active());
            userDto.set_password(user.get_password());
            dtoList.add(userDto);
        }

        return dtoList;
    }

}
