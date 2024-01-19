package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AdministratorMapper extends BaseMapper {

    /**
     * Este metodo mapea AdministratorDto a Administrator
     *
     * @param dto AdministratorDto
     * @return Administrator
     */
    public static Administrator mapDtoToEntity(AdministratorDto dto) {
        Administrator entity = EntityFactory.createAdministrator();

        entity.set_id(dto.getId());
        entity.set_username(dto.get_username());
        entity.set_email(dto.get_email());
        entity.set_password(dto.get_password());

        return entity;
    }

    /**
     * Este metodo Administrator a AdministratorDto
     *
     * @param entity Administrator
     * @return AdministratorDto
     */
    public static AdministratorDto mapEntityToDto(Administrator entity) {
        final AdministratorDto dto = new AdministratorDto();

        dto.setId(entity.get_id());
        dto.set_username(entity.get_username());
        dto.set_email(entity.get_email());
        dto.set_password(entity.get_password());

        return dto;
    }

    /**
     * Este metodo mapea un Administrator segun un id
     *
     * @param id id asociada
     * @return Administrator
     */
    public static Administrator mapDtoToEntity(long id) {
        Administrator entity = EntityFactory.createAdministrator(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Este metodo mapea un Administrator a partir de un email
     *
     * @param email email del Administrator
     * @return Administrator
     */
    public static Administrator mapDtoToEntityEmail(String email) {
        Administrator entity = EntityFactory.createAdministrator();
        entity.set_email(email);
        return entity;
    }

    /**
     * Este metodo mapea un Administrator a partir de un username
     *
     * @param username username del Administrator
     * @return Administrator
     */
    public static Administrator mapDtoToEntityUsername(String username){
        Administrator entity = EntityFactory.createAdministrator();
        entity.set_username(username);
        return entity;
    }

    /**
     * Este metodo mapea una lista de Administrator a una lista de AdministratorDto
     *
     * @param entityList lista de Administrator
     * @return lista de AdministratorDto
     */
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
