import com.ucab.cmcapp.common.exceptions.ConvertObjectToJsonException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConvertObjectToJsonExceptionTest {
    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        ConvertObjectToJsonException exception = new ConvertObjectToJsonException(message);
        assertEquals(message, exception.getMessage());
    }


}
