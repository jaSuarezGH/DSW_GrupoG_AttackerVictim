package com.ucab.cmcapp.logic.dtos;

public class AttackerDto extends BaseDto {

    private UserDto _user;

    public AttackerDto() {
    }

    public AttackerDto(long id) {
        super(id);
    }

    public UserDto get_user() {
        return _user;
    }

    public void set_user(UserDto _user) {
        this._user = _user;
    }

}
