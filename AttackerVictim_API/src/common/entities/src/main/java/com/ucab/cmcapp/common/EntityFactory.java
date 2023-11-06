package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    public static User createUser() {
        return new User();
    }

    public static User createUser(long id) {
        return new User(id);
    }

    public static UserType createUserType() {
        return new UserType();
    }

    public static UserType createUserType(long id) {
        return new UserType(id);
    }
}
