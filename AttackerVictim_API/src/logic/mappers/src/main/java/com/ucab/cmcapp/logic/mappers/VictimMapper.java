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

    /**
     * Este metodo mapea una VictimDto a Victim
     *
     * @param dto estructura VictimDto
     * @return Victim
     */
    public static Victim mapDtoToEntity(VictimDto dto) {
        Victim entity = EntityFactory.createVictim();

        entity.set_id(dto.getId());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    /**
     * Este metodo mapea una Victim a VictimDto
     *
     * @param entity Victim
     * @return VictimDto
     */
    public static VictimDto mapEntityToDto(Victim entity){
        final VictimDto dto = new VictimDto();

        dto.setId(entity.get_id());
        if(entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        return dto;
    }

    /**
     * Este metodo mapea una VictimDto a Victim por id
     *
     * @param id id de VictimDto
     * @return Victim
     */
    public static Victim mapDtoToEntity(long id) {
        Victim entity = EntityFactory.createVictim(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Este metodo mapeo una lista de Victim a una lista de VictimDto
     *
     * @param entityList lista de Victim
     * @return lista de VictimDto
     */
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

    /**
     * Este metodo mapea una Victim segun su id de usuario
     *
     * @param userId id de User de la victima
     * @return Victim
     */
    public static Victim mapDtoToEntityUserId(long userId){
        UserDto userDto = new UserDto(userId);
        Victim entity = EntityFactory.createVictim();
        entity.set_user(UserMapper.mapDtoToEntity(userDto));
        return entity;
    }

}
