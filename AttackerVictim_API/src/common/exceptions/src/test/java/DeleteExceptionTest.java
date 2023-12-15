import com.ucab.cmcapp.common.exceptions.DbHandlerException;
import com.ucab.cmcapp.common.exceptions.DeleteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        DeleteException exception = new DeleteException(message);
        assertEquals(message, exception.getMessage());
    }

}
