package com.ucab.cmcapp.logic.dtos;

public class UserLoginDto {

    private String _username;
    private String _password;

    public UserLoginDto() {
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
