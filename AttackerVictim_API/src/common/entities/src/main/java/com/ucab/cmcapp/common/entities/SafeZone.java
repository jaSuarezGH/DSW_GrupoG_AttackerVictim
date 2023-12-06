package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "safe_zone")
public class SafeZone {

    public SafeZone() {
    }

    public SafeZone(long id) {
        _id = id;
    }

    public SafeZone(SafeZone safeZone) {
        _id = safeZone._id;
        _name = safeZone._name;
        _user = safeZone._user;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "name", nullable = false)
    private String _name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", nullable = false)
    private User _user;

    /*@ElementCollection
    @Column(name="nickname")
    private List<Point> _coordinates;*/

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }
}
