package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    public History(){
    }

    public History(long id) {
        _id = id;
    }

    public History(History history){
        _id = history._id;
        _full_date = history._full_date;
        _status = history._status;
        _latitude = history._latitude;
        _longitude = history._longitude;
        _user = history._user;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "full_date", nullable = false)
    private Date _full_date;

    @Column(name = "status", nullable = false)
    private String _status;

    @Column(name = "latitude", nullable = false)
    private Double _latitude;

    @Column(name = "longitude", nullable = false)
    private Double _longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", nullable = false)
    private User _user;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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

    public Double get_latitude() {
        return _latitude;
    }

    public void set_latitude(Double _latitude) {
        this._latitude = _latitude;
    }

    public Double get_longitude() {
        return _longitude;
    }

    public void set_longitude(Double _longitude) {
        this._longitude = _longitude;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }
}
