package com.ucab.cmcapp.logic.dtos;

public class CoordinateDto extends BaseDto {

    private Double _latitude;
    private Double _longitude;

    public CoordinateDto() {
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
