package mappers;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import com.ucab.cmcapp.logic.mappers.CoordinateMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateMapperTest {

    @Test
    public void mapDtoToEntityTest(){
        CoordinateDto coordinateDto = new CoordinateDto();
        coordinateDto.setId(1);
        coordinateDto.set_latitude(99.0);
        coordinateDto.set_longitude(98.0);
        Coordinate coordinate = CoordinateMapper.mapDtoToEntity(coordinateDto);

        assertEquals(1, coordinate.get_id());
        assertEquals(99.0, coordinate.get_latitude());
        assertEquals(98.0, coordinate.get_longitude());
    }

    @Test
    public void mapEntityToDtoTest(){
        Coordinate coordinate = new Coordinate(1);
        coordinate.set_latitude(99.0);
        coordinate.set_longitude(98.0);
        CoordinateDto coordinateDto = CoordinateMapper.mapEntityToDto(coordinate);

        assertEquals(1, coordinateDto.getId());
        assertEquals(99.0, coordinate.get_latitude());
        assertEquals(98.0, coordinate.get_longitude());
    }

    @Test
    public void mapDtoToEntityWithIdTest(){
        Coordinate coordinate = CoordinateMapper.mapDtoToEntity(1);

        assertEquals(1, coordinate.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest(){
        List<Coordinate> entityList = new ArrayList<>();
        Coordinate coordinate = new Coordinate(1);
        entityList.add(coordinate);
        List<CoordinateDto> dtoList = CoordinateMapper.mapEntityListToDtoList(entityList);

        assertEquals(1, dtoList.get(0).getId());
    }

}
