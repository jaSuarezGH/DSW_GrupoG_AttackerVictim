package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    public Persona() {
    }

    public Persona(Persona persona) {
        _name = persona._name;
    }

    public Persona(long _id) {
        this._id = _id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "name", nullable = false)
    private String _name;

    //@Column(name = "uid", nullable = false)
    //private String _uid;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    /*public String get_uid() {
        return _uid;
    }

    public void set_uid(String _uid) {
        this._uid = _uid;
    }*/
}
