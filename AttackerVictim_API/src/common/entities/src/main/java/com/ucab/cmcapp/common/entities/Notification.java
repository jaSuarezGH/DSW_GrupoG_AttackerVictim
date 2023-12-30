package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {

    public Notification() {
    }

    public Notification(Notification notification) {
        _id = notification._id;
        _full_date = notification._full_date;
        _status = notification._status;
        _user = notification._user;
    }

    public Notification(long id) {
        _id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    //@Basic(optional = false)
    @Column(name = "full_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date _full_date;

    @Column(name = "status", nullable = false)
    private String _status;

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

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }
}
