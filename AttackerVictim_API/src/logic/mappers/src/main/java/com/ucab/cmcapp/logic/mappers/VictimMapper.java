package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class VictimMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(VictimMapper.class);

    public static Victim mapDtoToEntity(VictimDto dto) throws ParseException {
        Victim entity = EntityFactory.createVictim();

        entity.set_id(dto.getId());
        entity.set_user_id(UserMapper.mapDtoToEntity(dto.get_user_id()));

        return entity;
    }

    public static VictimDto mapEntityToDto(Victim entity){
        final VictimDto dto = new VictimDto();

        dto.setId(entity.get_id());
        dto.set_user_id(UserMapper.mapEntityToDto(entity.get_user_id()));

        return dto;
    }

    public static Victim mapDtoToEntity(long id) {
        Victim entity = EntityFactory.createVictim(id);
        entity.set_id(id);
        return entity;
    }
}
