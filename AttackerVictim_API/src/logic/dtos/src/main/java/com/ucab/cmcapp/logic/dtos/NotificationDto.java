package com.ucab.cmcapp.logic.dtos;

import java.util.Date;

public class NotificationDto extends BaseDto {

    private Date _full_date;
    private String _status;
    private UserDto _user;

    public NotificationDto(){
    }

    public Date get_full_date() {
        return _full_date;
    }

    public void set_full_date(Date _full_date) {
        this._full_date = _full_date;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }

    public UserDto get_user() {
        return _user;
    }

    public void set_user(UserDto _user) {
        this._user = _user;
    }
}
