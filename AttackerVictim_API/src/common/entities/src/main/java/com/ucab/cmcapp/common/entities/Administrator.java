package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {

    public Administrator() {
    }

    public Administrator(Administrator administrator) {
        _username = administrator._username;
        _email = administrator._email;
        _password = administrator._password;
    }

    public Administrator(long id) {
        _id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "username", nullable = false, unique = true)
    private String _username;

    @Column(name = "email", nullable = false, unique = true)
    private String _email;

    @Column(name = "password", nullable = false)
    private String _password;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
