import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.implementation.BaseService;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import javax.ws.rs.core.Response;
import java.util.Set;


public class BaseServiceTest {

    @Test
    public void verifyParams_throwsExceptionIfObjectIsNull() {
        BaseService service = new BaseService();
        Assertions.assertThrows(RuntimeException.class, () -> {
            service.verifyParams(null);
        });
    }

    @Test
    public void getClasses_returnsEmptySet() {
        BaseService service = new BaseService();
        Set<Class<?>> classes = service.getClasses();
        assertTrue(classes.isEmpty());
    }

    @Test
    public void testVerifyParamsWithNonNullObject() {
        BaseService service = new BaseService();
        Object nonNullObject = new Object();
        service.verifyParams(nonNullObject); // No debería lanzar excepción
    }


    @Test(expected = JWTVerifyException.class)
    public void testValidateCredentialsWithInvalidJWT() {
        BaseService service = new BaseService();
        String invalidJWT = "invalidToken";

        service.validateCredentials(invalidJWT); // Debería lanzar JWTVerifyException
    }

    @Test
    public void throwExceptionTest(){
        BaseService baseService = new BaseService();
        Assertions.assertThrows(RuntimeException.class, () -> {
            Exception exception = new Exception();
            baseService.throwException(exception, null);

        });
    }

}
