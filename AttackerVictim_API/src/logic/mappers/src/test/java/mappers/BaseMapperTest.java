package mappers;

import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.properties.Registry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BaseMapperTest {

    /*@Test
    void testParseStringToDate() throws ParseException {
        Registry registryMock = Mockito.mock(Registry.class);
        Mockito.when(registryMock.getInstance().getProperty(Registry.DATE_FORMAT)).thenReturn()


        String dateString = "2022-12-31";
        Date expectedDate = new Date(1640908800000L); // December 31, 2022
        Date result = BaseMapper.parseStringToDate(dateString);
        assertEquals(expectedDate, result);
    }

    @Test
    void testFormatDateToString() {
        Date date = new Date(1640908800000L); // December 31, 2022
        String expectedString = "2022-12-31";
        String result = BaseMapper.formatDateToString(date);
        assertEquals(expectedString, result);
    }*/

    @Test
    void testIsAnyBlank() {
        assertTrue(BaseMapper.isAnyBlank("", "test", null));
        assertFalse(BaseMapper.isAnyBlank("test", "test", "test"));
    }

    @Test
    void testIsBlank() {
        assertTrue(BaseMapper.isBlank(""));
        assertTrue(BaseMapper.isBlank("   "));
        assertFalse(BaseMapper.isBlank("test"));
    }

    @Test
    void testIsNullOrEmptyString() {
        assertTrue(BaseMapper.isNullOrEmptyString(null));
        assertTrue(BaseMapper.isNullOrEmptyString(""));
        assertFalse(BaseMapper.isNullOrEmptyString("test"));
    }

}
