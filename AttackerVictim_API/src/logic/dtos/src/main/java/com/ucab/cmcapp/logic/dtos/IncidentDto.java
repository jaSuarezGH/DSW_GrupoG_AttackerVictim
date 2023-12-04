package com.ucab.cmcapp.logic.dtos;

public class IncidentDto extends BaseDto {

    private VictimDto _victim;
    private AttackerDto _attacker;
    private Double _separation_distance;

    public IncidentDto() {
    }

    public VictimDto get_victim() {
        return _victim;
    }

    public void set_victim(VictimDto _victim) {
        this._victim = _victim;
    }

    public AttackerDto get_attacker() {
        return _attacker;
    }

    public void set_attacker(AttackerDto _attacker) {
        this._attacker = _attacker;
    }

    public Double get_separation_distance() {
        return _separation_distance;
    }

    public void set_separation_distance(Double _separation_distance) {
        this._separation_distance = _separation_distance;
    }
}
