package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    public static User createUser() {
        return new User();
    }

    public static User createUser(long id) {
        return new User(id);
    }

    // --------------------

    public static UserType createUserType() {
        return new UserType();
    }

    public static UserType createUserType(long id) {
        return new UserType(id);
    }

    // --------------------

    public static Victim createVictim(){
        return new Victim();
    }

    public static Victim createVictim(long id){
        return new Victim(id);
    }

    // --------------------

    public static Attacker createAttacker(){
        return new Attacker();
    }

    public static Attacker createAttacker(long id){
        return new Attacker(id);
    }

    // --------------------

    public static Incident createIncident(){
        return new Incident();
    }

    public static Incident createIncident(long id){
        return new Incident(id);
    }

}
