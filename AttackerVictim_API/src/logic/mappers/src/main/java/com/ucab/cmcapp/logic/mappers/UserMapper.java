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

        //region Instrumentation DEBUG
        _logger.debug("Get in UserMapper.mapDtoToEntity: dto {}", dto);
        //endregion

        // No se incluye el ID

        entity.set_firstname(dto.get_firstname());
        entity.set_lastname(dto.get_lastname());
        entity.set_username(dto.get_username());
        entity.set_license(dto.get_license());
        entity.set_email(dto.get_email());
        entity.set_mac_address(dto.get_mac_address());

        if (Objects.nonNull(dto.get_userType())) {
            entity.set_userType(UserTypeMapper.mapDtoToEntity(dto.get_userType()));
        }

        //region Instrumentation DEBUG
        _logger.debug("Leaving UserMapper.mapDtoToEntity: entity {}", entity);
        //endregion

        return entity;
    }

    public static UserDto mapEntityToDto(User entity) {
        final UserDto dto = new UserDto();

        //region Instrumentation DEBUG
        _logger.debug("Get in UserMapper.mapEntityToDto: entity {}", entity);
        //endregion

        // Si se incluye el ID

        dto.setId(entity.get_id());
        dto.set_firstname(entity.get_firstname());
        dto.set_lastname(entity.get_lastname());
        dto.set_username(entity.get_username());
        dto.set_license(entity.get_license());
        dto.set_email(entity.get_email());
        dto.set_mac_address(entity.get_mac_address());

        if (Objects.nonNull(entity.get_userType()))
            dto.set_userType(UserTypeMapper.mapEntityToDto(entity.get_userType()));

        //region Instrumentation DEBUG
        _logger.debug("Leaving UserMapper.mapEntityToDto: dto {}", dto);
        //endregion
        return dto;
    }

    public static User mapDtoToEntity(long id) {
        User entity = EntityFactory.createUser(id);

        //region Instrumentation DEBUG
        _logger.debug("Get in UserMapper.mapDtoToEntity: id {}", id);
        //endregion

        entity.set_id(id);

        //region Instrumentation DEBUG
        _logger.debug("Leaving UserMapper.mapDtoToEntity: entity {}", entity);
        //endregion

        return entity;
    }

    public static User mapDtoToEntityEmail(String email) {
        User entity = EntityFactory.createUser();

        //region Instrumentation DEBUG
        _logger.debug("Get in UserMapper.mapDtoToEntityEmail: email {}", email);
        //endregion

        entity.set_email(email);

        //region Instrumentation DEBUG
        _logger.debug("Leaving UserMapper.mapDtoToEntityEmail: entity {}", entity);
        //endregion

        return entity;
    }

}
