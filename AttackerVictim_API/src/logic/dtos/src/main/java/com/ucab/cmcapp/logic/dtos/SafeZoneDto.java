package com.ucab.cmcapp.logic.dtos;

public class SafeZoneDto extends BaseDto {

    private String _name;
    private UserDto _user;

    public SafeZoneDto(){
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public UserDto get_user() {
        return _user;
    }

    public void set_user(UserDto _user) {
        this._user = _user;
    }
}
