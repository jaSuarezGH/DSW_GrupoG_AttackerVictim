import com.ucab.cmcapp.common.exceptions.JWTSetKeyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTSetKeyExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        JWTSetKeyException exception = new JWTSetKeyException(message);
        assertEquals(message, exception.getMessage());
    }

}
