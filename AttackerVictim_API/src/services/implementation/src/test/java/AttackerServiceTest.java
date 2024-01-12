import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.implementation.AttackerService;
import com.ucab.cmcapp.logic.commands.attacker.composite.GetAllAttackerCommand;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class AttackerServiceTest {

    private AttackerService attackerService;

    @Before
    public void setUp() {
        attackerService = new AttackerService();
    }

    @Test
    public void testGetAllAttackers() {
        // Arrange
        GetAllAttackerCommand commandMock = Mockito.mock(GetAllAttackerCommand.class);
        List<Attacker> attackerList = new ArrayList<>();
        attackerList.add(new Attacker());

        Mockito.doNothing().when(commandMock).execute();
        Mockito.when(commandMock.getReturnParam()).thenReturn(attackerList);

        // Act
        Response response = attackerService.getAllAttackers();

        // Assert
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        CustomResponse<List<AttackerDto>> customResponse = (CustomResponse<List<AttackerDto>>) response.getEntity();
        Assert.assertNotNull(customResponse.response);
        Assert.assertFalse(customResponse.response.isEmpty());
        Assert.assertEquals("[OK NORMAL RESPONSE] Successfully listed all attackers", customResponse.description);
    }

}
