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
        _separation_distance = incident._separation_distance;
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

    @Column(name = "separation_distance", nullable = false)
    private Double _separation_distance;

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

    public Double get_separation_distance() {
        return _separation_distance;
    }

    public void set_separation_distance(Double _separation_distance) {
        this._separation_distance = _separation_distance;
    }
}
