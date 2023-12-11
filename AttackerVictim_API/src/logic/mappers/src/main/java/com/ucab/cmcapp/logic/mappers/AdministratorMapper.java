package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AdministratorMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(AdministratorMapper.class);

    public static Administrator mapDtoToEntity(AdministratorDto dto) {
        Administrator entity = EntityFactory.createAdministrator();

        entity.set_id(dto.getId());
        entity.set_username(dto.get_username());
        entity.set_email(dto.get_email());
        entity.set_password(dto.get_password());

        return entity;
    }

    public static AdministratorDto mapEntityToDto(Administrator entity) {
        final AdministratorDto dto = new AdministratorDto();

        dto.setId(entity.get_id());
        dto.set_username(entity.get_username());
        dto.set_email(entity.get_email());
        dto.set_password(entity.get_password());

        return dto;
    }

    public static Administrator mapDtoToEntity(long id) {
        Administrator entity = EntityFactory.createAdministrator(id);
        entity.set_id(id);
        return entity;
    }

    public static Administrator mapDtoToEntityEmail(String email) {
        Administrator entity = EntityFactory.createAdministrator();
        entity.set_email(email);
        return entity;
    }

    public static Administrator mapDtoToEntityUsername(String username){
        Administrator entity = EntityFactory.createAdministrator();
        entity.set_username(username);
        return entity;
    }

    public static List<AdministratorDto> mapEntityListToDtoList(List<Administrator> entityList){
        List<AdministratorDto> dtoList = new ArrayList<>();
        AdministratorDto administratorDto;

        for (Administrator administrator : entityList) {
            administratorDto = new AdministratorDto();
            administratorDto.setId(administrator.get_id());
            administratorDto.set_username(administrator.get_username());
            administratorDto.set_email(administrator.get_email());
            administratorDto.set_password(administrator.get_password());
            dtoList.add(administratorDto);
        }

        return dtoList;
    }
}
