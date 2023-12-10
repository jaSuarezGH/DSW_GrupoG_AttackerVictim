package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "attacker")
public class Attacker {
    public Attacker() {
    }

    public Attacker(long id) {
        _id = id;
    }

    public Attacker(Attacker attacker) {
        _id = attacker._id;
        _user = attacker._user;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne(fetch = FetchType.EAGER)
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

    public void set_user(User _user) {
        this._user = _user;
    }
}
