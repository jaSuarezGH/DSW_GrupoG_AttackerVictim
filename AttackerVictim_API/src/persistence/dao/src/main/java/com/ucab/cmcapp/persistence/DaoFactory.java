package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    public static UserDao createUserDao(DBHandler handler) {
        return new UserDao(handler);
    }

    public static VictimDao createVictimDao(DBHandler handler) {
        return new VictimDao(handler);
    }

    public static AttackerDao createAttackerDao(DBHandler handler) {
        return new AttackerDao(handler);
    }

    public static IncidentDao createIncidentDao(DBHandler handler) {
        return new IncidentDao(handler);
    }

    public static HistoryDao createHistoryDao(DBHandler handler) {
        return new HistoryDao(handler);
    }

    public static SafeZoneDao createSafeZoneDao(DBHandler handler) {
        return new SafeZoneDao(handler);
    }

    public static CoordinateDao createCoordinateDao(DBHandler handler) {
        return new CoordinateDao(handler);
    }

    public static AdministratorDao createAdministratorDao(DBHandler handler) {
        return new AdministratorDao(handler);
    }

    public static NotificationDao createAdministrationDao(DBHandler handler) {
        return new NotificationDao(handler);
    }

}
