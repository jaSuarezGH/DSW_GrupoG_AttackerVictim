import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.DbHandlerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbHandlerExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        DbHandlerException exception = new DbHandlerException(message);
        assertEquals(message, exception.getMessage());
    }

}
