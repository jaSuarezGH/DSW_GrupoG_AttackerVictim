package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SafeZoneMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(SafeZoneMapper.class);

    public static SafeZone mapDtoToEntity(SafeZoneDto dto) throws ParseException {
        SafeZone entity = EntityFactory.createSafeZone();

        entity.set_id(dto.getId());
        entity.set_name(dto.get_name());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    public static SafeZoneDto mapEntityToDto(SafeZone entity) {
        final SafeZoneDto dto = new SafeZoneDto();

        dto.setId(entity.get_id());
        dto.set_name(entity.get_name());
        if (entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

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
            dtoList.add(safeZoneDto);
        }

        return dtoList;
    }

}
