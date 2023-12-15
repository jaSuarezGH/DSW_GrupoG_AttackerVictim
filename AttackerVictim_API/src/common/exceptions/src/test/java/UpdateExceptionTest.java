import com.ucab.cmcapp.common.exceptions.UpdateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpdateExceptionTest {

    @Test
    public void testConstructor() {
        Exception cause = new Exception();
        String message = "test message";
        assertThrows(UpdateException.class, () -> { throw new UpdateException(cause, message); });
    }

}
