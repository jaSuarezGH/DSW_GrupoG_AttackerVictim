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

    public static Coordinate mapDtoToEntity(CoordinateDto dto) throws ParseException {
        Coordinate entity = EntityFactory.createCoordinate();
        entity.set_id(dto.getId());
        entity.set_latitude(dto.get_latitude());
        entity.set_longitude(dto.get_longitude());
        return entity;
    }

    public static CoordinateDto mapEntityToDto(Coordinate entity) {
        final CoordinateDto dto = new CoordinateDto();
        dto.setId(entity.get_id());
        dto.set_latitude(entity.get_latitude());
        dto.set_longitude(entity.get_longitude());
        return dto;
    }

    public static Coordinate mapDtoToEntity(long id) {
        Coordinate entity = EntityFactory.createCoordinate(id);
        entity.set_id(id);
        return entity;
    }

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
