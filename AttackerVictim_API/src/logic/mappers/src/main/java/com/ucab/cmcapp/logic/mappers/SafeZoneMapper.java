package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SafeZoneMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(SafeZoneMapper.class);

    public static SafeZone mapDtoToEntity(SafeZoneDto dto) {
        SafeZone entity = EntityFactory.createSafeZone();

        entity.set_id(dto.getId());
        entity.set_name(dto.get_name());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));
        entity.set_coordinate(CoordinateMapper.mapDtoToEntity(dto.get_coordinate()));

        return entity;
    }

    public static SafeZoneDto mapEntityToDto(SafeZone entity) {
        final SafeZoneDto dto = new SafeZoneDto();

        dto.setId(entity.get_id());
        dto.set_name(entity.get_name());

        if (entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        if (entity.get_coordinate() != null)
            dto.set_coordinate(CoordinateMapper.mapEntityToDto(entity.get_coordinate()));

        return dto;
    }

    public static SafeZone mapDtoToEntity(long id) {
        SafeZone entity = EntityFactory.createSafeZone(id);
        entity.set_id(id);
        return entity;
    }

    public static List<SafeZoneDto> mapEntityListToDtoList(List<SafeZone> entityList) {
        List<SafeZoneDto> dtoList = new ArrayList<>();
        SafeZoneDto safeZoneDto;

        for (SafeZone safeZone : entityList) {
            safeZoneDto = new SafeZoneDto();
            safeZoneDto.setId(safeZone.get_id());
            safeZoneDto.set_name(safeZone.get_name());
            safeZoneDto.set_user(UserMapper.mapEntityToDto(safeZone.get_user()));
            safeZoneDto.set_coordinate(CoordinateMapper.mapEntityToDto(safeZone.get_coordinate()));
            dtoList.add(safeZoneDto);
        }

        return dtoList;
    }

    public static SafeZone mapDtoToEntityUserId(long userId) {
        UserDto userDto = new UserDto(userId);
        SafeZone entity = EntityFactory.createSafeZone();
        entity.set_user(UserMapper.mapDtoToEntity(userDto));
        return entity;
    }

}
