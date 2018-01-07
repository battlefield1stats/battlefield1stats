package com.bf1stats.domain.json.basic;

import com.bf1stats.domain.json.JsonRootMarker;

public class DetailedStatsResponseJson implements JsonRootMarker {

    private boolean successful;
    private DetailedStatsJson result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public DetailedStatsJson getResult() {
        return result;
    }

    public void setResult(DetailedStatsJson result) {
        this.result = result;
    }
}
