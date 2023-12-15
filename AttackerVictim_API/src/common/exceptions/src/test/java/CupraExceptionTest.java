import com.ucab.cmcapp.common.exceptions.ConvertObjectToJsonException;
import com.ucab.cmcapp.common.exceptions.CupraException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CupraExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        CupraException exception = new CupraException(message);
        assertEquals(message, exception.getMessage());
    }

}
