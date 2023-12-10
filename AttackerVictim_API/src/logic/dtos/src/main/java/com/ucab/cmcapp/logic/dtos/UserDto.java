package com.ucab.cmcapp.logic.dtos;


public class UserDto extends BaseDto {

    private String _firstname;
    private String _lastname;
    private String _username;
    private String _personal_id;
    private String _email;
    private String _mac_address;
    private Boolean _active;
    private String _password;

    public UserDto() {
    }

    public UserDto(long id) {
        super(id);
    }

    public String get_firstname() {
        return _firstname;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public String get_lastname() {
        return _lastname;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_personal_id() {
        return _personal_id;
    }

    public void set_personal_id(String _personal_id) {
        this._personal_id = _personal_id;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_mac_address() {
        return _mac_address;
    }

    public void set_mac_address(String _mac_address) {
        this._mac_address = _mac_address;
    }

    public Boolean get_active() {
        return _active;
    }

    public void set_active(Boolean _active) {
        this._active = _active;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
