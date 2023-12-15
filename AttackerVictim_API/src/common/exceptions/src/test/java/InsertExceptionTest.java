import com.ucab.cmcapp.common.exceptions.InsertException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        InsertException exception = new InsertException(message);
        assertEquals(message, exception.getMessage());
    }

}
