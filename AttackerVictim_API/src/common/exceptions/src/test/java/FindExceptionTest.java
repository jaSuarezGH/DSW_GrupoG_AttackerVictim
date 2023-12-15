import com.ucab.cmcapp.common.exceptions.FindException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        FindException exception = new FindException(message);
        assertEquals(message, exception.getMessage());
    }

}
