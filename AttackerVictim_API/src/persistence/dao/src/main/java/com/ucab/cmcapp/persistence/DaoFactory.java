package com.ucab.cmcapp.persistence;

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

}
