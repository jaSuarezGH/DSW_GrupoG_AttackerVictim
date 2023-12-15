package entities;

import com.ucab.cmcapp.common.entities.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {

    @Test
    public void testConstructorWithIdParam(){
        Coordinate coordinate = new Coordinate(1);

        assertEquals(1, coordinate.get_id());
    }

    @Test
    public void testConstructorWithCoodinateParam(){
        Coordinate coordinateParam = new Coordinate();
        coordinateParam.set_id(1);
        coordinateParam.set_latitude(99.0);
        coordinateParam.set_longitude(88.0);


        Coordinate coordinate = new Coordinate(coordinateParam);

        assertEquals(1,coordinate.get_id());
        assertEquals(99.0,coordinate.get_latitude());
        assertEquals(88.0,coordinate.get_longitude());
    }

    /*@Test
    public void testGettersAndSetters(){
        Coordinate coordinate = new Coordinate();

        coordinate.set_id(1);
        coordinate.set_longitude(99.0);
        coordinate.set_latitude(88.0);


    }*/

}
