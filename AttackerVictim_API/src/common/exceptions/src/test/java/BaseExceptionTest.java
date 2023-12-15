import com.ucab.cmcapp.common.exceptions.BaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseExceptionTest {

    @Test
    public void testConstructorWithExceptionAndString() {
        Exception cause = new Exception();
        String message = "test message";
        BaseException exception = new BaseException(cause, message);
        assertThrows(BaseException.class, () -> { throw exception; });
    }

    @Test
    public void testConstructorWithString() {
        String message = "test message";
        BaseException exception = new BaseException(message);
        assertThrows(BaseException.class, () -> { throw exception; });
    }

    @Test
    public void testConstructorWithException() {
        Exception cause = new Exception();
        BaseException exception = new BaseException(cause);
        assertThrows(BaseException.class, () -> { throw exception; });
    }

    @Test
    public void testConstructorWithIllegalArgumentException() {
        IllegalArgumentException cause = new IllegalArgumentException();
        BaseException exception = new BaseException(cause);
        assertThrows(BaseException.class, () -> { throw exception; });
    }

}
