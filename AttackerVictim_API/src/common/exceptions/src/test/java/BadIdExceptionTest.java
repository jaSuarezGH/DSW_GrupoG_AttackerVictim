import com.ucab.cmcapp.common.exceptions.BadIdException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadIdExceptionTest {
    @Test
    public void testConstructor() {
        BadIdException exception = new BadIdException("123");
        assertEquals("Invalid Id: 123", exception.getMessage());
    }
}
