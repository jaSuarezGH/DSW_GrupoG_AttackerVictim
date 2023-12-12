import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationExceptionTest {
    @Test
    public void testConstructor() {
        AuthenticationException exception = new AuthenticationException("Authentication failed");
        assertEquals("Authentication failed", exception.getMessage());
    }
}
