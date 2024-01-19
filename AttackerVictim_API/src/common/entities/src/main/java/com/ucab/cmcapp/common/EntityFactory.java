package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    /**
     * Este metodo retorna una instancia de User
     *
     * @return User
     */
    public static User createUser() {
        return new User();
    }

    /**
     * Este metodo retorna una instancia de User con id
     *
     * @return User
     */
    public static User createUser(long id) {
        return new User(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Victim
     *
     * @return Victim
     */
    public static Victim createVictim(){
        return new Victim();
    }

    /**
     * Este metodo retorna una instancia de Victim con id
     *
     * @return Victim
     */
    public static Victim createVictim(long id){
        return new Victim(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Attacker
     *
     * @return Attacker
     */
    public static Attacker createAttacker(){
        return new Attacker();
    }

    /**
     * Este metodo retorna una instancia de Attacker con id
     *
     * @return Attacker
     */
    public static Attacker createAttacker(long id){
        return new Attacker(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Incident
     *
     * @return Incident
     */
    public static Incident createIncident(){
        return new Incident();
    }

    /**
     * Este metodo retorna una instancia de Incident con id
     *
     * @return Incident
     */
    public static Incident createIncident(long id){
        return new Incident(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de History
     *
     * @return History
     */
    public static History createHistory(){
        return new History();
    }

    /**
     * Este metodo retorna una instancia de History con id
     *
     * @return History
     */
    public static History createHistory(long id){
        return new History(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de SafeZone
     *
     * @return SafeZone
     */
    public static SafeZone createSafeZone(){
        return new SafeZone();
    }

    /**
     * Este metodo retorna una instancia de SafeZone con id
     *
     * @return SafeZone
     */
    public static SafeZone createSafeZone(long id){
        return new SafeZone(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Coordinate
     *
     * @return Coordinate
     */
    public static Coordinate createCoordinate(){
        return new Coordinate();
    }

    /**
     * Este metodo retorna una instancia de Coordinate con id
     *
     * @return Coordinate
     */
    public static Coordinate createCoordinate(long id){
        return new Coordinate(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Administrator
     *
     * @return Administrator
     */
    public static Administrator createAdministrator(){
        return new Administrator();
    }

    /**
     * Este metodo retorna una instancia de Administrator con id
     *
     * @return Administrator
     */
    public static Administrator createAdministrator(long id){
        return new Administrator(id);
    }

    // --------------------

    /**
     * Este metodo retorna una instancia de Notification
     *
     * @return Notification
     */
    public static Notification createNotification(){
        return new Notification();
    }

    /**
     * Este metodo retorna una instancia de Notification con id
     *
     * @return Notification
     */
    public static Notification createNotification(long id){
        return new Notification(id);
    }

}
