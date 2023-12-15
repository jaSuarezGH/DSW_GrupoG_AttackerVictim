import com.ucab.cmcapp.common.exceptions.FaultBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaultBeanTest {

    @Test
    public void testConstructorAndGetters() {
        String code = "test code";
        String message = "test message";
        String supportMessage = "test support message";
        FaultBean faultBean = new FaultBean(code, message, supportMessage);
        assertEquals(code, faultBean.getCode());
        assertEquals(message, faultBean.getMessage());
        assertEquals(supportMessage, faultBean.getSoportMessage());
    }

    @Test
    public void testSetters() {
        String code = "test code";
        String message = "test message";
        String supportMessage = "test support message";
        FaultBean faultBean = new FaultBean("", "", "");
        faultBean.setCode(code);
        faultBean.setMessage(message);
        faultBean.setSoportMessage(supportMessage);
        assertEquals(code, faultBean.getCode());
        assertEquals(message, faultBean.getMessage());
        assertEquals(supportMessage, faultBean.getSoportMessage());
    }

}
