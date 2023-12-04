package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "incident")
public class Incident {
    public Incident() {
    }

    public Incident(long id) {
        _id = id;
    }

    public Incident(Incident incident) {
        _id = incident._id;
        _victim = incident._victim;
        _attacker = incident._attacker;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne
    @JoinColumn(name = "victim", nullable = false, unique = true)
    private Victim _victim;

    @OneToOne
    @JoinColumn(name = "attacker", nullable = false, unique = true)
    private Attacker _attacker;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Victim get_victim() {
        return _victim;
    }

    public void set_victim(Victim _victim) {
        this._victim = _victim;
    }

    public Attacker get_attacker() {
        return _attacker;
    }

    public void set_attacker(Attacker _attacker) {
        this._attacker = _attacker;
    }
}
