package com.ucab.cmcapp.logic.utilities;

import com.ucab.cmcapp.logic.dtos.AttackerInSafeZoneDto;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;

import java.awt.geom.Path2D;
import java.util.*;

public class DistanceManager {

    public double calculateSeparationDistance(HistoryDto firstLocation, HistoryDto secondLocation) {
        // Haversine´s formula
        // ChatGPT
        double startLat = firstLocation.get_latitude();
        double startLong = firstLocation.get_longitude();
        double endLat = secondLocation.get_latitude();
        double endLong = secondLocation.get_longitude();

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));
        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);
        double a = haversine(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(dLong);
        double distance = 2 * Math.asin(Math.sqrt(a));
        double radius = 6371 * 1000; // Earth's radius in meters
        return distance * radius;
    }

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    public AttackerInSafeZoneDto verifyAttackerInSafeZone(HistoryDto lastAttackerCoordinate, List<SafeZoneDto> posibleZones) {
        AttackerInSafeZoneDto resultDto = new AttackerInSafeZoneDto();
        Double attackerLatitude = lastAttackerCoordinate.get_latitude();
        Double attackerLongitude = lastAttackerCoordinate.get_longitude();
        Map<String, List<Double>> latitudesMap = new HashMap<>();
        Map<String, List<Double>> longitudesMap = new HashMap<>();
        List<Double> latitudes;
        List<Double> longitudes;
        List<String> zoneKeys = new ArrayList<>();

        for (SafeZoneDto safeZone : posibleZones) {
            if (!latitudesMap.containsKey(safeZone.get_name())) { // no se verifica longitudeMap por que ya empieza vacio tambien
                latitudes = new ArrayList<>();
                longitudes = new ArrayList<>();
                latitudesMap.put(safeZone.get_name(), latitudes);
                longitudesMap.put(safeZone.get_name(), longitudes);
                zoneKeys.add(safeZone.get_name());
            }
            latitudesMap.get(safeZone.get_name()).add(safeZone.get_coordinate().get_latitude());
            longitudesMap.get(safeZone.get_name()).add(safeZone.get_coordinate().get_longitude());
        }

        boolean insideSafeZone;
        Double[] latitudeArray;
        Double[] longitudeArray;
        List<Double> auxLatList;
        List<Double> auxLonList;

        resultDto.set_inside(false); // Establecer en false por defecto

        for (String zoneName : zoneKeys) {
            auxLatList = latitudesMap.get(zoneName);
            auxLonList = longitudesMap.get(zoneName);
            latitudeArray = new Double[auxLatList.size()];
            longitudeArray = new Double[auxLonList.size()];

            for (int i = 0; i < auxLatList.size(); i++) {
                latitudeArray[i] = auxLatList.get(i);
            }

            for (int i = 0; i < auxLonList.size(); i++) {
                longitudeArray[i] = auxLonList.get(i);
            }

            insideSafeZone = calculateCoordinatesInArea(attackerLatitude, attackerLongitude, latitudeArray, longitudeArray);
            if (insideSafeZone) {
                resultDto.set_inside(insideSafeZone);
                resultDto.get_zones().add(zoneName);
                resultDto.set_latitude(attackerLatitude);
                resultDto.set_longitude(attackerLongitude);
            }

        }

        return resultDto;
    }

    public boolean calculateCoordinatesInArea(Double personLatitude, Double personLongitude, Double[] areaLatitudes, Double[] areaLongitudes) {
        // Crear un objeto Path2D para representar el polígono de la zona
        Path2D.Double zonaPoligono = new Path2D.Double();
        zonaPoligono.moveTo(areaLongitudes[0], areaLatitudes[0]);
        for (int i = 1; i < areaLatitudes.length; i++) {
            zonaPoligono.lineTo(areaLongitudes[i], areaLatitudes[i]);
        }
        zonaPoligono.closePath();

        // Comprobar si la persona se encuentra dentro de la zona determinada
        return zonaPoligono.contains(personLongitude, personLatitude);
    }

}
