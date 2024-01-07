package dtos;

import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateDtoTest {

    @Test
    public void testConstructor() {
        CoordinateDto coordinateDto = new CoordinateDto();
        assertEquals(0, coordinateDto.getId()); // Comprueba herencia de BaseDto
        assertNull(coordinateDto.get_latitude());
        assertNull(coordinateDto.get_longitude());
    }

    @Test
    public void testGetSetLatitude() {
        CoordinateDto coordinateDto = new CoordinateDto();
        Double latitude = 10.5;
        coordinateDto.set_latitude(latitude);
        assertEquals(latitude, coordinateDto.get_latitude());
    }

    @Test
    public void testGetSetLongitude() {
        CoordinateDto coordinateDto = new CoordinateDto();
        Double longitude = -66.8;
        coordinateDto.set_longitude(longitude);
        assertEquals(longitude, coordinateDto.get_longitude());
    }
}
