import com.ucab.cmcapp.common.entities.*;
import org.junit.jupiter.api.Test;

import static com.ucab.cmcapp.common.EntityFactory.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityFactoryTest {

    @Test
    public void testCreateUser(){
        User user = new User();
        user.set_id(1);

        User user1 = createUser();
        user1.set_id(1);

        assertEquals(user.get_id(), user1.get_id());
        assertNull(user1.get_mac_address());
        assertNull(user1.get_lastname());
        assertNull(user1.get_password());
        assertNull(user1.get_username());
        assertNull(user1.get_active());
        assertNull(user1.get_personal_id());
        assertNull(user1.get_email());
        assertNull(user1.get_firstname());
    }

    @Test
    public void testCreateUserWithId(){
        User user = new User();
        user.set_id(1);

        User user1 = createUser(1);

        assertEquals(user.get_id(), user1.get_id());
        assertNull(user1.get_mac_address());
        assertNull(user1.get_lastname());
        assertNull(user1.get_password());
        assertNull(user1.get_username());
        assertNull(user1.get_active());
        assertNull(user1.get_personal_id());
        assertNull(user1.get_email());
        assertNull(user1.get_firstname());
    }

    // --------------


    @Test
    public void testCreateVictim(){
        Victim victim = new Victim();
        victim.set_id(1);

        Victim victim1 = createVictim();
        victim1.set_id(1);

        User user = new User(1);
        victim1.set_user(user);
        victim.set_user(user);

        assertEquals(victim.get_id(), victim1.get_id());
        assertEquals(victim.get_user().get_id(), victim1.get_user().get_id());
    }

    @Test
    public void testCreateVictimWithId(){
        Victim victim = new Victim(1);

        Victim victim1 = createVictim(1);

        User user = new User(1);
        victim1.set_user(user);
        victim.set_user(user);

        assertEquals(victim.get_id(), victim1.get_id());
        assertEquals(victim.get_user().get_id(), victim1.get_user().get_id());
    }

    // --------------


    @Test
    public void testCreateAttacker(){
        Attacker attacker = new Attacker();
        attacker.set_id(1);

        Attacker attacker1 = createAttacker();
        attacker1.set_id(1);

        User user = new User(1);
        attacker1.set_user(user);
        attacker.set_user(user);

        assertEquals(attacker.get_id(), attacker1.get_id());
        assertEquals(attacker.get_user().get_id(), attacker1.get_user().get_id());
    }

    @Test
    public void testCreateAttackerWithId(){
        Attacker attacker = new Attacker(1);

        Attacker attacker1 = createAttacker(1);

        User user = new User(1);
        attacker1.set_user(user);
        attacker.set_user(user);

        assertEquals(attacker.get_id(), attacker1.get_id());
        assertEquals(attacker.get_user().get_id(), attacker1.get_user().get_id());
    }

    // --------------



    @Test
    public void testCreateIncident(){
        Incident incident = new Incident();
        incident.set_id(1);

        Incident incident1 = createIncident();
        incident1.set_id(1);

        User user = new User(1);
        Victim victim = new Victim(1);
        Attacker attacker = createAttacker(1);
        victim.set_user(user);
        attacker.set_user(user);

        incident.set_victim(victim);
        incident1.set_victim(victim);
        incident.set_attacker(attacker);
        incident1.set_attacker(attacker);

        assertEquals(incident.get_id(), incident1.get_id());
        assertEquals(incident.get_victim().get_id(), incident1.get_victim().get_id());
        assertEquals(incident.get_attacker().get_id(), incident1.get_attacker().get_id());
        assertEquals(incident.get_victim().get_user().get_id(), incident1.get_victim().get_user().get_id());
        assertEquals(incident.get_attacker().get_user().get_id(), incident1.get_attacker().get_user().get_id());
        assertNull(incident1.get_separation_distance());

    }

    @Test
    public void testCreateIncidentWithId(){
        Incident incident = new Incident(1);

        Incident incident1 = createIncident(1);

        User user = new User(1);
        Victim victim = new Victim(1);
        Attacker attacker = createAttacker(1);
        victim.set_user(user);
        attacker.set_user(user);

        incident.set_victim(victim);
        incident1.set_victim(victim);
        incident.set_attacker(attacker);
        incident1.set_attacker(attacker);

        assertEquals(incident.get_id(), incident1.get_id());
        assertEquals(incident.get_victim().get_id(), incident1.get_victim().get_id());
        assertEquals(incident.get_attacker().get_id(), incident1.get_attacker().get_id());
        assertEquals(incident.get_victim().get_user().get_id(), incident1.get_victim().get_user().get_id());
        assertEquals(incident.get_attacker().get_user().get_id(), incident1.get_attacker().get_user().get_id());
        assertNull(incident1.get_separation_distance());
    }

    // --------------



    @Test
    public void testCreateHistory(){
        History history = new History();
        history.set_id(1);

        History history1 = createHistory();
        history1.set_id(1);

        User user = new User(1);

        history.set_user(user);
        history1.set_user(user);

        assertEquals(history.get_id(), history1.get_id());
        assertEquals(history.get_user().get_id(), history1.get_user().get_id());
        assertNull(history1.get_status());
        assertNull(history1.get_longitude());
        assertNull(history1.get_latitude());
        assertNull(history1.get_full_date());

    }

    @Test
    public void testCreateHistoryWithId(){
        History history = new History(1);

        History history1 = createHistory(1);

        User user = new User(1);
        history.set_user(user);
        history1.set_user(user);

        assertEquals(history.get_id(), history1.get_id());
        assertEquals(history.get_user().get_id(), history1.get_user().get_id());
        assertNull(history1.get_status());
        assertNull(history1.get_longitude());
        assertNull(history1.get_latitude());
        assertNull(history1.get_full_date());
    }

    // --------------



    @Test
    public void testCreateSafeZone(){
        SafeZone safeZone = new SafeZone();
        safeZone.set_id(1);

        SafeZone safeZone1 = createSafeZone();
        safeZone1.set_id(1);

        User user = new User(1);
        safeZone.set_user(user);
        safeZone1.set_user(user);

        assertEquals(safeZone.get_id(), safeZone1.get_id());
        assertEquals(safeZone.get_user().get_id(), safeZone1.get_user().get_id());
        assertNull(safeZone1.get_name());
        assertNull(safeZone1.get_coordinate());

    }

    @Test
    public void testCreateSafeZoneWithId(){
        SafeZone safeZone = new SafeZone(1);

        SafeZone safeZone1 = createSafeZone(1);

        User user = new User(1);
        safeZone.set_user(user);
        safeZone1.set_user(user);

        assertEquals(safeZone.get_id(), safeZone1.get_id());
        assertEquals(safeZone.get_user().get_id(), safeZone1.get_user().get_id());
        assertNull(safeZone1.get_name());
        assertNull(safeZone1.get_coordinate());
    }

    // --------------



    @Test
    public void testCreateCoordinates(){

        Coordinate coordinate = new Coordinate();
        coordinate.set_id(1);

        Coordinate coordinate1 = createCoordinate();
        coordinate1.set_id(1);

        assertEquals(coordinate.get_id(), coordinate1.get_id());
        assertNull(coordinate1.get_latitude());
        assertNull(coordinate1.get_longitude());

    }

    @Test
    public void testCreateCoordinatesWithId(){
        Coordinate coordinate = new Coordinate(1);

        Coordinate coordinate1 = createCoordinate(1);

        assertEquals(coordinate.get_id(), coordinate1.get_id());
        assertNull(coordinate1.get_latitude());
        assertNull(coordinate1.get_longitude());
    }

    // --------------



    @Test
    public void testCreateAdministrator(){

        Administrator administrator = new Administrator();
        administrator.set_id(1);

        Administrator administrator1 = createAdministrator();
        administrator1.set_id(1);

        assertEquals(administrator.get_id(), administrator1.get_id());
        assertNull(administrator1.get_email());
        assertNull(administrator1.get_username());
        assertNull(administrator1.get_password());

    }

    @Test
    public void testCreateAdministratorWithId(){

        Administrator administrator = new Administrator(1);

        Administrator administrator1 = createAdministrator(1);

        assertEquals(administrator.get_id(), administrator1.get_id());
        assertNull(administrator1.get_email());
        assertNull(administrator1.get_username());
        assertNull(administrator1.get_password());
    }

    // --------------



    @Test
    public void testCreateNotification(){

        Notification notification = new Notification();
        notification.set_id(1);

        Notification notification1 = createNotification();
        notification1.set_id(1);

        assertEquals(notification.get_id(), notification1.get_id());
        assertNull(notification1.get_full_date());
        assertNull(notification1.get_user());
        assertNull(notification1.get_status());

    }

    @Test
    public void testCreateNotificationWithId() {

        Notification notification = new Notification(1);

        Notification notification1 = createNotification(1);

        assertEquals(notification.get_id(), notification1.get_id());
        assertNull(notification1.get_full_date());
        assertNull(notification1.get_user());
        assertNull(notification1.get_status());

    }
}
