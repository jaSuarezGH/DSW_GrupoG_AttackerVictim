package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactoryPersona;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.dtos.PersonaDTO;

import java.text.ParseException;
import java.util.Objects;

public class PersonaMapper extends BaseMapper {

    public static Persona mapDtoToEntity(PersonaDTO dto) throws ParseException {
        Persona entity = EntityFactoryPersona.createPersona();
        entity.set_name(dto.get_name());
        //entity.set_uid(dto.get_uid());

        return entity;
    }

    public static PersonaDTO mapEntityToDto(Persona entity) {
        final PersonaDTO dto = new PersonaDTO();

        dto.setId(entity.get_id());
        dto.set_name(entity.get_name());
        //dto.set_uid(entity.get_uid());

        return dto;
    }

    public static Persona mapDtoToEntity(long id) {
        Persona entity = EntityFactoryPersona.createPersona(id);
        entity.set_id(id);

        return entity;
    }

    public static Persona mapDtoToEntityName(String name) {
        Persona entity = EntityFactoryPersona.createPersona();
        entity.set_name(name);
        return entity;
    }

}
