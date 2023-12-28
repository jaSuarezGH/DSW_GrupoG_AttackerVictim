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

    // --------------------

    public static History createHistory(){
        return new History();
    }

    public static History createHistory(long id){
        return new History(id);
    }

    // --------------------

    public static SafeZone createSafeZone(){
        return new SafeZone();
    }

    public static SafeZone createSafeZone(long id){
        return new SafeZone(id);
    }

    // --------------------

    public static Coordinate createCoordinate(){
        return new Coordinate();
    }

    public static Coordinate createCoordinate(long id){
        return new Coordinate(id);
    }

    // --------------------

    public static Administrator createAdministrator(){
        return new Administrator();
    }

    public static Administrator createAdministrator(long id){
        return new Administrator(id);
    }

    // --------------------

    public static Notification createNotification(){
        return new Notification();
    }

    public static Notification createNotification(long id){
        return new Notification();
    }

}
