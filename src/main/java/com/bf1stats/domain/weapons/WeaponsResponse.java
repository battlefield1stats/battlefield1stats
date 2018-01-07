package com.bf1stats.domain.weapons;

import com.bf1stats.domain.RootMarker;

import java.util.List;

public class WeaponsResponse implements RootMarker {

    private boolean successful;
    private List<Weapons> result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<Weapons> getResult() {
        return result;
    }

    public void setResult(List<Weapons> result) {
        this.result = result;
    }
}
