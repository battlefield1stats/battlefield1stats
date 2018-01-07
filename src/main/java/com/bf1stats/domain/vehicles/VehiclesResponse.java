package com.bf1stats.domain.vehicles;

import com.bf1stats.domain.RootMarker;

import java.util.List;

public class VehiclesResponse implements RootMarker {
    private boolean successful;
    private List<Vehicles> result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<Vehicles> getResult() {
        return result;
    }

    public void setResult(List<Vehicles> result) {
        this.result = result;
    }
}
