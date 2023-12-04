package com.ucab.cmcapp.logic.dtos;

public class IncidentDto extends BaseDto {

    private VictimDto _victim;
    private AttackerDto _attacker;

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
}
