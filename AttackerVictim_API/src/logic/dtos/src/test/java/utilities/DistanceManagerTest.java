package utilities;

import com.ucab.cmcapp.logic.dtos.*;
import com.ucab.cmcapp.logic.utilities.DistanceManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceManagerTest {

    @Test
    public void testCalculateSeparationDistance() {
        // Coordenadas de prueba
        double latitude1 = 10.48385129965897;
        double longitude1 = -67.06815737573243;
        double latitude2 = 10.482838523792939;
        double longitude2 = -67.04584139672852;

        // Crear objetos HistoryDto
        HistoryDto firstLocation = new HistoryDto();
        firstLocation.set_latitude(latitude1);
        firstLocation.set_longitude(longitude1);
        HistoryDto secondLocation = new HistoryDto();
        secondLocation.set_latitude(latitude2);
        secondLocation.set_longitude(longitude2);

        // Calcular la distancia
        double distance = new DistanceManager().calculateSeparationDistance(firstLocation, secondLocation);

        // Distancia esperada aproximada (redondeada a 2 decimales)
        double expectedDistance = 2442.6;

        // Afirmar que la distancia calculada es correcta
        assertEquals(expectedDistance, Math.round(distance * 100.0) / 100.0);
    }

    @Test
    public void testVerifyAttackerInSafeZone() {
        // Coordenadas del atacante
        double attackerLatitude = 10.464328;
        double attackerLongitude = -66.976589;

        // Zonas seguras de prueba
        List<SafeZoneDto> safeZones = new ArrayList<>();

        //+++++++++++++

        SafeZoneDto zone1_a = new SafeZoneDto();
        zone1_a.set_name("Zona 1");
        CoordinateDto coordinateDto = new CoordinateDto();
        coordinateDto.set_latitude(10.464528);
        coordinateDto.set_longitude(-66.978638);
        zone1_a.set_coordinate(coordinateDto);
        safeZones.add(zone1_a);

        SafeZoneDto zone1_b = new SafeZoneDto();
        zone1_b.set_name("Zona 1");
        CoordinateDto coordinateDto2 = new CoordinateDto();
        coordinateDto2.set_latitude(10.465657);
        coordinateDto2.set_longitude(-66.974797);
        zone1_b.set_coordinate(coordinateDto2);
        safeZones.add(zone1_b);

        SafeZoneDto zone1_c = new SafeZoneDto();
        zone1_c.set_name("Zona 1");
        CoordinateDto coordinateDto3 = new CoordinateDto();
        coordinateDto3.set_latitude(10.463948);
        coordinateDto3.set_longitude(-66.973799);
        zone1_c.set_coordinate(coordinateDto3);
        safeZones.add(zone1_c);

        SafeZoneDto zone1_d = new SafeZoneDto();
        zone1_d.set_name("Zona 1");
        CoordinateDto coordinateDto4 = new CoordinateDto();
        coordinateDto4.set_latitude(10.462904);
        coordinateDto4.set_longitude(-66.978488);
        zone1_d.set_coordinate(coordinateDto4);
        safeZones.add(zone1_d);

        //+++++++++++++

        SafeZoneDto zone2_a = new SafeZoneDto();
        zone2_a.set_name("Zona 2");
        CoordinateDto coordinateDto5 = new CoordinateDto();
        coordinateDto5.set_latitude(10.464528);
        coordinateDto5.set_longitude(-66.978638);
        zone2_a.set_coordinate(coordinateDto5);
        safeZones.add(zone2_a);

        SafeZoneDto zone2_b = new SafeZoneDto();
        zone2_b.set_name("Zona 2");
        CoordinateDto coordinateDto6 = new CoordinateDto();
        coordinateDto6.set_latitude(10.465657);
        coordinateDto6.set_longitude(-66.974797);
        zone2_b.set_coordinate(coordinateDto6);
        safeZones.add(zone2_b);

        SafeZoneDto zone2_c = new SafeZoneDto();
        zone2_c.set_name("Zona 2");
        CoordinateDto coordinateDto7 = new CoordinateDto();
        coordinateDto7.set_latitude(10.463948);
        coordinateDto7.set_longitude(-66.973799);
        zone2_c.set_coordinate(coordinateDto7);
        safeZones.add(zone2_c);

        SafeZoneDto zone2_d = new SafeZoneDto();
        zone2_d.set_name("Zona 2");
        CoordinateDto coordinateDto8 = new CoordinateDto();
        coordinateDto8.set_latitude(10.462904);
        coordinateDto8.set_longitude(-66.978488);
        zone2_d.set_coordinate(coordinateDto8);
        safeZones.add(zone2_d);

        //+++++++++++++

        // Crear objeto HistoryDto para el atacante
        HistoryDto lastAttackerCoordinate = new HistoryDto();
        lastAttackerCoordinate.set_latitude(attackerLatitude);
        lastAttackerCoordinate.set_longitude(attackerLongitude);

        // Verificar si el atacante está en una zona segura
        AttackerInSafeZoneDto result = new DistanceManager().verifyAttackerInSafeZone(lastAttackerCoordinate, safeZones);

        // Afirmar que el resultado es correcto

        assertTrue(result.get_inside());
        assertEquals(2, result.get_zones().size());
        assertEquals("Zona 1", result.get_zones().get(0));
        assertEquals(attackerLatitude, result.get_latitude());
        assertEquals(attackerLongitude, result.get_longitude());
    }

    @Test
    public void testCalculateCoordinatesInArea() {
        // Coordenadas de la persona
        double personLatitude = 10.473899193192572;
        double personLongitude = -67.05957230688475;

        // Coordenadas de la zona
        Double[] areaLatitudes = {10.48385129965897, 10.482838523792939, 10.463426346546605, 10.462919925656141};
        Double[] areaLongitudes = {-67.06815737573243, -67.04584139672852, -67.04532641259766, -67.06575411645508};

        // Comprobar si la persona está dentro de la zona
        boolean inside = new DistanceManager().calculateCoordinatesInArea(personLatitude, personLongitude, areaLatitudes, areaLongitudes);

        // Afirmar que el resultado es correcto
        assertTrue(inside);
    }
}
