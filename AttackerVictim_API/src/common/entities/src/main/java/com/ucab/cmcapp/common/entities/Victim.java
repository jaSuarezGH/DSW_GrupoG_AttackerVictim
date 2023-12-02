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
        _user_id = victim._user_id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User _user_id;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public User get_user_id() {
        return _user_id;
    }

    public void set_user_id(User _user_id) {
        this._user_id = _user_id;
    }
}
