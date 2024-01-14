
import com.ucab.cmcapp.implementation.HistoryService;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class HistoryServiceTest {

    private HistoryService historyService;

    @BeforeEach
    public void setUp(){
        historyService = new HistoryService();

    }

    @Test
    public void getAllHistoriesTest(){

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = historyService.getAllHistories();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void getHistoryByUserIdTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = historyService.getAllHistoryByUserId(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }


    @Test
    public void addHistoryTest(){

        HistoryDto historyDto = new HistoryDto();

        Assertions.assertThrows(RuntimeException.class, () -> {
            Response response = historyService.addHistory(historyDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }

    @Test
    public void deleteHistoryTest(){

        long userId = 1L;

        Assertions.assertThrows(NoClassDefFoundError.class, () -> {
            Response response = historyService.deleteHistory(userId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        });
    }



}
