package com.ucab.cmcapp.logic.dtos;

public class VictimDto extends BaseDto {

    private UserDto _user;

    public VictimDto() {
    }

    public VictimDto(long id) {
        super(id);
    }

    public UserDto get_user() {
        return _user;
    }

    public void set_user(UserDto _user) {
        this._user = _user;
    }
}
