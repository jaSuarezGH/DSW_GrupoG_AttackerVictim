package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "victim")
public class Victim {

    public Victim() {
    }

    public Victim(long id) {
        _id = id;
    }

    public Victim(Victim victim) {
        _id = victim._id;
        _user = victim._user;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne
    @JoinColumn(name = "user", nullable = false, unique = true)
    private User _user;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user_id) {
        this._user = _user_id;
    }
}
