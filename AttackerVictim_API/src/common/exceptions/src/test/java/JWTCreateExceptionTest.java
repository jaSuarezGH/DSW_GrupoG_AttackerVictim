import com.ucab.cmcapp.common.exceptions.JWTCreateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTCreateExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        JWTCreateException exception = new JWTCreateException(message);
        assertEquals(message, exception.getMessage());
    }

}
