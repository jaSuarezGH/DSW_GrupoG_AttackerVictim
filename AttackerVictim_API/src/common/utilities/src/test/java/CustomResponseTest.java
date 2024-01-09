import com.ucab.cmcapp.common.util.CustomResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomResponseTest {

    @Test
    public void testConstructorWithResponseAndDescription(){
        CustomResponse customResponse = new CustomResponse<>(100, "sample");

        assertEquals(100, customResponse.response);
        assertEquals("sample", customResponse.description);
    }

    @Test
    public void testConstructorWithDescription(){
        CustomResponse customResponse = new CustomResponse<>("sample");

        assertNull(customResponse.response);
        assertEquals("sample", customResponse.description);
    }

}
