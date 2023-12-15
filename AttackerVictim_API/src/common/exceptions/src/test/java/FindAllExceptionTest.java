import com.ucab.cmcapp.common.exceptions.FindAllException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String message = "This is a test message";
        FindAllException exception = new FindAllException(message);
        assertEquals(message, exception.getMessage());
    }

}
