package com.ucab.cmcapp.common;


import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.UserType;

public class EntityFactoryPersona {
    public static Persona createPersona() {
        return new Persona();
    }

    public static Persona createPersona(long id) {
        return new Persona(id);
    }

    /*public static PersonaType createUserType() {
        return new PersonaType();
    }

    public static PersonaType createUserType(long id) {
        return new PersonaType(id);
    }*/
}
