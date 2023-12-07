package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "coordinate")
public class Coordinate {

    public Coordinate() {
    }

    public Coordinate(long id) {
        _id = id;
    }

    public Coordinate(Coordinate coordinate) {
        _id = coordinate._id;
        _latitude = coordinate._latitude;
        _longitude = coordinate._longitude;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "latitude", nullable = false)
    private Double _latitude;

    @Column(name = "longitude", nullable = false)
    private Double _longitude;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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
}
