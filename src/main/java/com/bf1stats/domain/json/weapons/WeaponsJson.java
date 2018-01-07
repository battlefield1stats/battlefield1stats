package com.bf1stats.domain.json.weapons;

import java.util.List;

public class WeaponsJson {

    private String name;
    private List<WeaponJson> weapons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeaponJson> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<WeaponJson> weapons) {
        this.weapons = weapons;
    }
}
