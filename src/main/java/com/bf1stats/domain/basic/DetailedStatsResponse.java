package com.bf1stats.domain.basic;

import com.bf1stats.domain.RootMarker;

public class DetailedStatsResponse implements RootMarker {

    private boolean successful;
    private DetailedStats result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public DetailedStats getResult() {
        return result;
    }

    public void setResult(DetailedStats result) {
        this.result = result;
    }
}
