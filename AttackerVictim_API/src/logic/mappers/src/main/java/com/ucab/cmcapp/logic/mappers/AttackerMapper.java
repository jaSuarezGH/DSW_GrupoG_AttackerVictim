package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AttackerMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(AttackerMapper.class);

    public static Attacker mapDtoToEntity(AttackerDto dto) throws ParseException {
        Attacker entity = EntityFactory.createAttacker();

        entity.set_id(dto.getId());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    public static AttackerDto mapEntityToDto(Attacker entity){
        final AttackerDto dto = new AttackerDto();

        dto.setId(entity.get_id());
        if(entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        return dto;
    }

    public static Attacker mapDtoToEntity(long id) {
        Attacker entity = EntityFactory.createAttacker(id);
        entity.set_id(id);
        return entity;
    }

    public static List<AttackerDto> mapEntityListToDtoList(List<Attacker> entityList){
        List<AttackerDto> dtoList = new ArrayList<>();
        AttackerDto attackerDto;

        for (Attacker attacker : entityList) {
            attackerDto = new AttackerDto();
            attackerDto.setId(attacker.get_id());
            attackerDto.set_user(UserMapper.mapEntityToDto(attacker.get_user()));
            dtoList.add(attackerDto);
        }

        return dtoList;
    }

    public static Attacker mapDtoToEntityUserId(String userId){
        User user = new User();
        user.set_id(Integer.valueOf(userId));
        Attacker entity = EntityFactory.createAttacker();
        entity.set_user(user);
        return entity;
    }

}
