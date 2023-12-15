package mappers;

import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import com.ucab.cmcapp.common.exceptions.FaultBean;
import com.ucab.cmcapp.common.exceptions.mappers.AuthenticationExceptionMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

public class AuthenticationExceptionMapperTest {

    /*private AuthenticationExceptionMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new AuthenticationExceptionMapper();
    }

    @Test
    public void testToResponse() {
        AuthenticationException exception = new AuthenticationException("test message");

        Response response = mapper.toResponse(exception);

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
        FaultBean faultBean = (FaultBean) response.getEntity();
        Assert.assertEquals("your_expected_code", faultBean.getCode());
        Assert.assertEquals("your_expected_message", faultBean.getMessage());
        //Assert.assertEquals("test message", faultBean.getDetails());
    }*/

}
