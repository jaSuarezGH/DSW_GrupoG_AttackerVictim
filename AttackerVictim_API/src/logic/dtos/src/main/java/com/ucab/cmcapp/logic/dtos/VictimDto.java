package com.ucab.cmcapp.logic.dtos;

public class VictimDto extends BaseDto {

    private UserDto _user_id;

    public VictimDto() {
    }

    public UserDto get_user_id() {
        return _user_id;
    }

    public void set_user_id(UserDto _user_id) {
        this._user_id = _user_id;
    }
}
