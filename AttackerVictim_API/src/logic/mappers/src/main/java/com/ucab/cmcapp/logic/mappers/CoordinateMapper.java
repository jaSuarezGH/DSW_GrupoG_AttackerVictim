package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CoordinateMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(CoordinateMapper.class);

    /**
     * Este metodo mapea CoordinateDto a Coordinate
     *
     * @param dto CoordinateDto
     * @return Coordinate
     */
    public static Coordinate mapDtoToEntity(CoordinateDto dto) {
        Coordinate entity = EntityFactory.createCoordinate();
        entity.set_id(dto.getId());
        entity.set_latitude(dto.get_latitude());
        entity.set_longitude(dto.get_longitude());
        return entity;
    }

    /**
     * Este metodo mapea Coordinate a CoordinateDto
     *
     * @param entity Coordinate
     * @return CoordinateDto
     */
    public static CoordinateDto mapEntityToDto(Coordinate entity) {
        final CoordinateDto dto = new CoordinateDto();
        dto.setId(entity.get_id());
        dto.set_latitude(entity.get_latitude());
        dto.set_longitude(entity.get_longitude());
        return dto;
    }

    /**
     * Este metodo mapea Coordinate a partir de un id
     *
     * @param id id asociado
     * @return Coordinate
     */
    public static Coordinate mapDtoToEntity(long id) {
        Coordinate entity = EntityFactory.createCoordinate(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Este metodo mapea una lista de Coordinate a una lista de CoordinateDto
     *
     * @param entityList lista de Coordinate
     * @return lista de CoordinateDto
     */
    public static List<CoordinateDto> mapEntityListToDtoList(List<Coordinate> entityList) {
        List<CoordinateDto> dtoList = new ArrayList<>();
        CoordinateDto coordinateDto;

        for (Coordinate coordinate : entityList) {
            coordinateDto = new CoordinateDto();
            coordinateDto.setId(coordinate.get_id());
            coordinateDto.set_latitude(coordinate.get_latitude());
            coordinateDto.set_longitude(coordinate.get_longitude());
            dtoList.add(coordinateDto);
        }

        return dtoList;
    }

}
