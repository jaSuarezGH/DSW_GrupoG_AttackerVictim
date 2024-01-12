import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CommandTest {

    private Command<Object> command;

    @Before
    public void setUp() {
        command = Mockito.mock(Command.class, Mockito.CALLS_REAL_METHODS);
    }

    private DBHandler handler;

    @Test
    public void testGetHandler() {

        // Act
        command.setHandler(handler);
        DBHandler actualHandler = command.getHandler();

        // Assert
        Assert.assertEquals(handler, actualHandler);
    }

    @Test
    public void testSetHandler() {

        // Act
        command.setHandler(handler);
        DBHandler actualHandler = command.getHandler();

        // Assert
        Assert.assertEquals(handler, actualHandler);
    }
}
