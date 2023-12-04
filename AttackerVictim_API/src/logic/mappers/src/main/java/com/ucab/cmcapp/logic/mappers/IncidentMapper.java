package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class IncidentMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(IncidentMapper.class);

    public static Incident mapDtoToEntity(IncidentDto dto) throws ParseException {
        Incident entity = EntityFactory.createIncident();
        entity.set_id(dto.getId());
        entity.set_attacker(AttackerMapper.mapDtoToEntity(dto.get_attacker()));
        entity.set_victim(VictimMapper.mapDtoToEntity(dto.get_victim()));
        return entity;
    }

    public static IncidentDto mapEntityToDto(Incident entity){
        final IncidentDto dto = new IncidentDto();

        dto.setId(entity.get_id());
        if(entity.get_attacker() != null)
            dto.set_attacker(AttackerMapper.mapEntityToDto(entity.get_attacker()));

        if(entity.get_victim() != null)
            dto.set_victim(VictimMapper.mapEntityToDto(entity.get_victim()));

        return dto;
    }

    public static Incident mapDtoToEntity(long id) {
        Incident entity = EntityFactory.createIncident(id);
        entity.set_id(id);
        return entity;
    }

    public static List<IncidentDto> mapEntityListToDtoList(List<Incident> entityList){
        List<IncidentDto> dtoList = new ArrayList<>();
        IncidentDto incidentDto;

        for (Incident incident : entityList) {
            incidentDto = new IncidentDto();
            incidentDto.setId(incident.get_id());
            incidentDto.set_attacker(AttackerMapper.mapEntityToDto(incident.get_attacker()));
            incidentDto.set_victim(VictimMapper.mapEntityToDto(incident.get_victim()));
            dtoList.add(incidentDto);
        }

        return dtoList;
    }

    public static Incident mapDtoToEntityVictimId(String victimId){
        Victim victim = new Victim();
        victim.set_id(Integer.valueOf(victimId));
        Incident entity = EntityFactory.createIncident();
        entity.set_victim(victim);
        return entity;
    }

    public static Incident mapDtoToEntityAttackerId(String attackerId){
        Attacker attacker = new Attacker();
        attacker.set_id(Integer.valueOf(attackerId));
        Incident entity = EntityFactory.createIncident();
        entity.set_attacker(attacker);
        return entity;
    }

}
