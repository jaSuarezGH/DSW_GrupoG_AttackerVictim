import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTVerifyExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        JWTVerifyException exception = new JWTVerifyException(message);
        assertEquals(message, exception.getMessage());
    }

}
