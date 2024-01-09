package entities;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncidentTest {

    @Test
    public void testGettersAndSetters(){
        Incident incident = new Incident();
        Victim victim = new Victim();
        victim.set_id(2);
        Attacker attacker = new Attacker();
        attacker.set_id(3);

        incident.set_id(1);
        incident.set_victim(victim);
        incident.set_attacker(attacker);
        incident.set_separation_distance(100.99);

        assertEquals(1, incident.get_id());
        assertEquals(2, incident.get_victim().get_id());
        assertEquals(3, incident.get_attacker().get_id());
        assertEquals(100.99, incident.get_separation_distance());

    }

    @Test
    public void testIncidentWithIdParam(){

        Incident incident = new Incident(1);

        assertEquals(1, incident.get_id());

    }

    @Test
    public void testIncidentWithIncidentParam(){

        Incident incident = new Incident();
        incident.set_id(1);
        incident.set_separation_distance(10.0);

        Incident incident1 = new Incident(incident);

        assertEquals(1, incident1.get_id());
        assertEquals(10.0, incident1.get_separation_distance());

    }

}
