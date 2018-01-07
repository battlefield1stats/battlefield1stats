package com.bf1stats.domain.json.vehicles;

import java.util.List;

public class VehiclesJson {

    private String name;
    private List<VehicleJson> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VehicleJson> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleJson> vehicles) {
        this.vehicles = vehicles;
    }
}
