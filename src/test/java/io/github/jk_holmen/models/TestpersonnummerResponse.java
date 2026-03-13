package io.github.jk_holmen.models;

import java.util.List;

public class TestpersonnummerResponse {
    
    private int resultCount;

    private int offset;

    private int limit;

    private int queryTime;

    private List<TestpersonnummerResult> results;

    public int getResultCount() {
        return resultCount;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getQueryTime() {
        return queryTime;
    }

    public List<TestpersonnummerResult> getResults() {
        return results;
    }
}
