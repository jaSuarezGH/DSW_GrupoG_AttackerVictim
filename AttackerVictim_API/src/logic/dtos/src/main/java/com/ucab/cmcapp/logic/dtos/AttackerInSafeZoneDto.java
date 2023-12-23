package com.ucab.cmcapp.logic.dtos;

import java.util.ArrayList;
import java.util.List;

public class AttackerInSafeZoneDto {

    private Boolean _inside;
    private List<String> _zones = new ArrayList<>();
    private Double _latitude;
    private Double _longitude;

    public AttackerInSafeZoneDto() {
    }

    public Boolean get_inside() {
        return _inside;
    }

    public void set_inside(Boolean _inside) {
        this._inside = _inside;
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

    public List<String> get_zones() {
        return _zones;
    }

    public void set_zones(List<String> _zones) {
        this._zones = _zones;
    }
}
