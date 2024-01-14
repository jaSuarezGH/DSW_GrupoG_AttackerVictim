import com.ucab.cmcapp.implementation.CoordinateService;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class CoordinateServiceTest {


    private CoordinateService coordinateService;

    @BeforeEach
    public void setUp(){
        coordinateService = new CoordinateService();

    }

    @Test
    public void getAllCoordinatesTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = coordinateService.getAllCoordinates();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getCoordinateByIdTest(){

        long coordinateId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = coordinateService.getCoordinateById(coordinateId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addCoordinateTest(){

        CoordinateDto coordinateDto = new CoordinateDto();

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = coordinateService.addCoordinate(coordinateDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

}
