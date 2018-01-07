package com.bf1stats.domain.json.weapons;

import com.bf1stats.domain.json.JsonRootMarker;

import java.util.List;

public class WeaponsResponseJson implements JsonRootMarker {

    private boolean successful;
    private List<WeaponsJson> result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<WeaponsJson> getResult() {
        return result;
    }

    public void setResult(List<WeaponsJson> result) {
        this.result = result;
    }
}
