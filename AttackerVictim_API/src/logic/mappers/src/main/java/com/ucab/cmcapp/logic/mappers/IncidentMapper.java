package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class IncidentMapper extends BaseMapper {

    /**
     * Este metodo mapea IncidentDto a Incident
     *
     * @param dto IncidentDto
     * @return Incident
     */
    public static Incident mapDtoToEntity(IncidentDto dto) {
        Incident entity = EntityFactory.createIncident();
        entity.set_id(dto.getId());
        entity.set_attacker(AttackerMapper.mapDtoToEntity(dto.get_attacker()));
        entity.set_victim(VictimMapper.mapDtoToEntity(dto.get_victim()));
        entity.set_separation_distance(dto.get_separation_distance());
        return entity;
    }

    /**
     * Este metodo mapea Incident a IncidentDto
     *
     * @param entity Incident
     * @return IncidentDto
     */
    public static IncidentDto mapEntityToDto(Incident entity){
        final IncidentDto dto = new IncidentDto();

        dto.setId(entity.get_id());

        if(entity.get_attacker() != null)
            dto.set_attacker(AttackerMapper.mapEntityToDto(entity.get_attacker()));

        if(entity.get_victim() != null)
            dto.set_victim(VictimMapper.mapEntityToDto(entity.get_victim()));

        dto.set_separation_distance(entity.get_separation_distance());

        return dto;
    }

    /**
     * Este metodo mapea Incident a partir de un id
     *
     * @param id id de incidente
     * @return Incident
     */
    public static Incident mapDtoToEntity(long id) {
        Incident entity = EntityFactory.createIncident(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Este metodo mapea una lista de Incident a una lista de IncidentDto
     *
     * @param entityList lista de Incident
     * @return lista de IncidentDto
     */
    public static List<IncidentDto> mapEntityListToDtoList(List<Incident> entityList){
        List<IncidentDto> dtoList = new ArrayList<>();
        IncidentDto incidentDto;

        for (Incident incident : entityList) {
            incidentDto = new IncidentDto();
            incidentDto.setId(incident.get_id());
            incidentDto.set_attacker(AttackerMapper.mapEntityToDto(incident.get_attacker()));
            incidentDto.set_victim(VictimMapper.mapEntityToDto(incident.get_victim()));
            incidentDto.set_separation_distance(incident.get_separation_distance());
            dtoList.add(incidentDto);
        }

        return dtoList;
    }

    /**
     * Este metodo mapea un Incident a partir de una victima
     *
     * @param victimId id de la victima de Incident
     * @return Incident
     */
    public static Incident mapDtoToEntityVictimId(long victimId){
        VictimDto victimDto = new VictimDto(victimId);
        Incident entity = EntityFactory.createIncident();
        entity.set_victim(VictimMapper.mapDtoToEntity(victimDto.getId()));
        return entity;
    }

    /**
     * Este metodo mapea un Incident a partir de un atacante
     *
     * @param attackerId id del atacante de Incident
     * @return Incident
     */
    public static Incident mapDtoToEntityAttackerId(long attackerId){
        AttackerDto attackerDto = new AttackerDto(attackerId);
        Incident entity = EntityFactory.createIncident();
        entity.set_attacker(AttackerMapper.mapDtoToEntity(attackerDto.getId()));
        return entity;
    }

}
