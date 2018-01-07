package com.bf1stats.domain.json.vehicles;

import com.bf1stats.domain.json.JsonRootMarker;

import java.util.List;

public class VehiclesResponseJson implements JsonRootMarker {
    private boolean successful;
    private List<VehiclesJson> result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<VehiclesJson> getResult() {
        return result;
    }

    public void setResult(List<VehiclesJson> result) {
        this.result = result;
    }
}
