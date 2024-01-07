import com.ucab.cmcapp.common.util.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.json.JSONObject;
import org.mockito.Mockito;

public class UtilitiesTest {

    @Test
    void testJsonToObject() {
        // Mock the dependencies
        JSONObject jsonObject = Mockito.mock(JSONObject.class);

        // Set up the mock behavior
        Mockito.when(jsonObject.toString()).thenReturn("{\"name\":\"value\"}");

        // Instantiate the Utilities class
        Utilities utilities = new Utilities();

        // Test the jsonToObject method
        String jsonString = "{\"name\":\"value\"}";
        JSONObject result = utilities.jsonToObject(jsonString);

        // Verify the expected behavior
        assertEquals(jsonObject.toString(), result.toString());
    }
}
