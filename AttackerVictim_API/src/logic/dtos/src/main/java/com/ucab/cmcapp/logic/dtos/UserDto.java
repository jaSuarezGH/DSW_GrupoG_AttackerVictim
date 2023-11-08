package com.ucab.cmcapp.logic.dtos;


public class UserDto extends BaseDto {

    private String _firstname;
    private String _lastname;
    private String _username;
    private String _personal_id;
    private String _email;
    private String _mac_address;
    private UserTypeDto _userType;


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

    public UserTypeDto get_userType() {
        return _userType;
    }

    public void set_userType(UserTypeDto _userType) {
        this._userType = _userType;
    }
}
