package mappers;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IncidentMapperTest {

    @Test
    public void mapDtoToEntityTest() {
        IncidentDto incidentDto = new IncidentDto();
        UserDto userVictimDto = new UserDto(1);
        UserDto userAttackerDto = new UserDto(2);
        AttackerDto attackerDto = new AttackerDto(1);
        attackerDto.set_user(userAttackerDto);
        VictimDto victimDto = new VictimDto(1);
        victimDto.set_user(userVictimDto);
        incidentDto.setId(1);
        incidentDto.set_attacker(attackerDto);
        incidentDto.set_victim(victimDto);
        incidentDto.set_separation_distance(99.0);

        Incident incident = IncidentMapper.mapDtoToEntity(incidentDto);

        assertEquals(incident.get_id(), incidentDto.getId());
        assertEquals(incident.get_attacker().get_id(), incidentDto.get_attacker().getId());
        assertEquals(incident.get_victim().get_id(), incidentDto.get_victim().getId());
        assertEquals(incident.get_separation_distance(), incidentDto.get_separation_distance());
    }

    @Test
    public void mapEntityToDtoTest() {
        Incident incident = new Incident();
        User userVictim = new User(1);
        User userAttackerDto = new User(2);
        Attacker attacker = new Attacker(1);
        attacker.set_user(userAttackerDto);
        Victim victim = new Victim(1);
        victim.set_user(userVictim);
        incident.set_id(1);
        incident.set_attacker(attacker);
        incident.set_victim(victim);
        incident.set_separation_distance(99.0);

        IncidentDto incidentDto = IncidentMapper.mapEntityToDto(incident);

        assertEquals(incidentDto.getId(), incident.get_id());
        assertEquals(incidentDto.get_attacker().getId(), incident.get_attacker().get_id());
        assertEquals(incidentDto.get_victim().getId(), incident.get_victim().get_id());
        assertEquals(incidentDto.get_separation_distance(), incident.get_separation_distance());
    }

    @Test
    public void mapDtoToEntityWithIdTest() {
        Incident incident = IncidentMapper.mapDtoToEntity(1);

        assertEquals(1, incident.get_id());
    }

    @Test
    public void mapEntityListToDtoListTest() {
        List<Incident> entityList = new ArrayList<>();
        Incident incident = new Incident();
        User userVictim = new User(1);
        User userAttackerDto = new User(2);
        Attacker attacker = new Attacker(1);
        attacker.set_user(userAttackerDto);
        Victim victim = new Victim(1);
        victim.set_user(userVictim);
        incident.set_id(1);
        incident.set_attacker(attacker);
        incident.set_victim(victim);
        incident.set_separation_distance(99.0);
        entityList.add(incident);

        List<IncidentDto> dtoList = IncidentMapper.mapEntityListToDtoList(entityList);

        assertEquals(dtoList.get(0).getId(), entityList.get(0).get_id());
        assertEquals(dtoList.get(0).get_attacker().getId(), entityList.get(0).get_attacker().get_id());
        assertEquals(dtoList.get(0).get_victim().getId(), entityList.get(0).get_victim().get_id());
        assertEquals(dtoList.get(0).get_separation_distance(), entityList.get(0).get_separation_distance());
    }

    @Test
    public void mapDtoToEntityVictimIdTest() {
        Incident incident = IncidentMapper.mapDtoToEntityVictimId(1);

        assertEquals(1, incident.get_victim().get_id());
    }

    @Test
    public void mapDtoToEntityAttackerIdTest() {
        Incident incident = IncidentMapper.mapDtoToEntityAttackerId(1);

        assertEquals(1, incident.get_attacker().get_id());
    }

}
