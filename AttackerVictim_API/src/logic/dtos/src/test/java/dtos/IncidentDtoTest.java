package dtos;

import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncidentDtoTest {

    @Test
    public void testConstructor() {
        IncidentDto incidentDto = new IncidentDto();
        assertEquals(0,incidentDto.getId()); // Comprueba herencia de BaseDto
        assertNull(incidentDto.get_victim());
        assertNull(incidentDto.get_attacker());
        assertNull(incidentDto.get_separation_distance());
    }

    @Test
    public void testGetSetVictim() {
        IncidentDto incidentDto = new IncidentDto();
        VictimDto victim = new VictimDto();
        incidentDto.set_victim(victim);
        assertEquals(victim, incidentDto.get_victim());
    }

    @Test
    public void testGetSetAttacker() {
        IncidentDto incidentDto = new IncidentDto();
        AttackerDto attacker = new AttackerDto();
        incidentDto.set_attacker(attacker);
        assertEquals(attacker, incidentDto.get_attacker());
    }

    @Test
    public void testGetSetSeparationDistance() {
        IncidentDto incidentDto = new IncidentDto();
        Double separationDistance = 100.5;
        incidentDto.set_separation_distance(separationDistance);
        assertEquals(separationDistance, incidentDto.get_separation_distance());
    }

    @Test
    public void testGetSetId() {
        IncidentDto incidentDto = new IncidentDto();
        Long id = 1L;
        incidentDto.setId(id);
        assertEquals(id, incidentDto.getId());
    }

}
