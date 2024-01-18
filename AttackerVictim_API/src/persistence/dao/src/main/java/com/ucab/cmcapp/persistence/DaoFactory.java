package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    /**
     * Este metodo genera la instancia UserDao
     *
     * @param handler instancia handler de base de datos
     * @return UserDao
     */
    public static UserDao createUserDao(DBHandler handler) {
        return new UserDao(handler);
    }

    /**
     * Este metodo genera la instancia VictimDao
     *
     * @param handler instancia handler de base de datos
     * @return VictimDao
     */
    public static VictimDao createVictimDao(DBHandler handler) {
        return new VictimDao(handler);
    }

    /**
     * Este metodo genera la instancia AttackerDao
     *
     * @param handler instancia handler de base de datos
     * @return AttackerDao
     */
    public static AttackerDao createAttackerDao(DBHandler handler) {
        return new AttackerDao(handler);
    }

    /**
     * Este metodo genera la instancia IncidentDao
     *
     * @param handler instancia handler de base de datos
     * @return IncidentDao
     */
    public static IncidentDao createIncidentDao(DBHandler handler) {
        return new IncidentDao(handler);
    }

    /**
     * Este metodo genera la instancia HistoryDao
     *
     * @param handler instancia handler de base de datos
     * @return HistoryDao
     */
    public static HistoryDao createHistoryDao(DBHandler handler) {
        return new HistoryDao(handler);
    }

    /**
     * Este metodo genera la instancia SafeZoneDao
     *
     * @param handler instancia handler de base de datos
     * @return SafeZoneDao
     */
    public static SafeZoneDao createSafeZoneDao(DBHandler handler) {
        return new SafeZoneDao(handler);
    }

    /**
     * Este metodo genera la instancia CoordinateDao
     *
     * @param handler instancia handler de base de datos
     * @return CoordinateDao
     */
    public static CoordinateDao createCoordinateDao(DBHandler handler) {
        return new CoordinateDao(handler);
    }

    /**
     * Este metodo genera la instancia AdministratorDao
     *
     * @param handler instancia handler de base de datos
     * @return AdministratorDao
     */
    public static AdministratorDao createAdministratorDao(DBHandler handler) {
        return new AdministratorDao(handler);
    }

    /**
     * Este metodo genera la instancia NotificationDao
     *
     * @param handler instancia handler de base de datos
     * @return NotificationDao
     */
    public static NotificationDao createNotificationDao(DBHandler handler) {
        return new NotificationDao(handler);
    }

}
