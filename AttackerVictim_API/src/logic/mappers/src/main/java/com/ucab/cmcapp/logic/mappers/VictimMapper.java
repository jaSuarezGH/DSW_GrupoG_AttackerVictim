package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VictimMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(VictimMapper.class);

    public static Victim mapDtoToEntity(VictimDto dto) {
        Victim entity = EntityFactory.createVictim();

        entity.set_id(dto.getId());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    public static VictimDto mapEntityToDto(Victim entity){
        final VictimDto dto = new VictimDto();

        dto.setId(entity.get_id());
        if(entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        return dto;
    }

    public static Victim mapDtoToEntity(long id) {
        Victim entity = EntityFactory.createVictim(id);
        entity.set_id(id);
        return entity;
    }

    public static List<VictimDto> mapEntityListToDtoList(List<Victim> entityList){
        List<VictimDto> dtoList = new ArrayList<>();
        VictimDto victimDto;

        for (Victim victim : entityList) {
            victimDto = new VictimDto();
            victimDto.setId(victim.get_id());
            victimDto.set_user(UserMapper.mapEntityToDto(victim.get_user()));
            dtoList.add(victimDto);
        }

        return dtoList;
    }

    public static Victim mapDtoToEntityUserId(long userId){
        UserDto userDto = new UserDto(userId);
        Victim entity = EntityFactory.createVictim();
        entity.set_user(UserMapper.mapDtoToEntity(userDto));
        return entity;
    }

}
