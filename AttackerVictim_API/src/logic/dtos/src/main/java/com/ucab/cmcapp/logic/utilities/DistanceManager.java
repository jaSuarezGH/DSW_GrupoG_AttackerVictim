package com.ucab.cmcapp.logic.utilities;

import com.ucab.cmcapp.logic.dtos.HistoryDto;

import java.util.HashMap;
import java.util.Map;

public class DistanceManager {

    int EARTH_RADIUS = 6371;
    double SEMI_MAJOR_AXIS_MT = 6378137;
    double SEMI_MINOR_AXIS_MT = 6356752.314245;
    double FLATTENING = 1 / 298.257223563;
    double ERROR_TOLERANCE = 1e-12;

    public double calculateSeparationDistance(HistoryDto firstLocation, HistoryDto secondLocation) {

        // Haversine´s formula
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

        /*
        // Vincenty’s Formula
        double latitude1 = firstLocation.get_latitude();
        double longitude1 = firstLocation.get_longitude();
        double latitude2 = secondLocation.get_latitude();
        double longitude2 = secondLocation.get_longitude();
        double U1 = Math.atan((1 - FLATTENING) * Math.tan(Math.toRadians(latitude1)));
        double U2 = Math.atan((1 - FLATTENING) * Math.tan(Math.toRadians(latitude2)));

        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);

        double longitudeDifference = Math.toRadians(longitude2 - longitude1);
        double previousLongitudeDifference;

        double sinSigma, cosSigma, sigma, sinAlpha, cosSqAlpha, cos2SigmaM;

        do {
            sinSigma = Math.sqrt(Math.pow(cosU2 * Math.sin(longitudeDifference), 2) +
                    Math.pow(cosU1 * sinU2 - sinU1 * cosU2 * Math.cos(longitudeDifference), 2));
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * Math.cos(longitudeDifference);
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * Math.sin(longitudeDifference) / sinSigma;
            cosSqAlpha = 1 - Math.pow(sinAlpha, 2);
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
            if (Double.isNaN(cos2SigmaM)) {
                cos2SigmaM = 0;
            }
            previousLongitudeDifference = longitudeDifference;
            double C = FLATTENING / 16 * cosSqAlpha * (4 + FLATTENING * (4 - 3 * cosSqAlpha));
            longitudeDifference = Math.toRadians(longitude2 - longitude1) + (1 - C) * FLATTENING * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2))));
        } while (Math.abs(longitudeDifference - previousLongitudeDifference) > ERROR_TOLERANCE);

        double uSq = cosSqAlpha * (Math.pow(SEMI_MAJOR_AXIS_MT, 2) - Math.pow(SEMI_MINOR_AXIS_MT, 2)) / Math.pow(SEMI_MINOR_AXIS_MT, 2);

        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));

        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2))
                - B / 6 * cos2SigmaM * (-3 + 4 * Math.pow(sinSigma, 2)) * (-3 + 4 * Math.pow(cos2SigmaM, 2))));

        double distanceMt = SEMI_MINOR_AXIS_MT * A * (sigma - deltaSigma);
        //return distanceMt / 1000;
        return  distanceMt; // distance in metters
        */
    }

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

}
