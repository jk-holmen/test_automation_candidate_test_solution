package io.github.jk_holmen.models;

import java.util.List;

/**
 * Response model for the Testpersonnummer dataset API.
 *
 * <p>
 * Deserialized from JSON via
 * {@link io.github.jk_holmen.clients.ApiResponse#as(Class)}. Fields are
 * populated by Gson and match the API response structure.
 *
 * @author jk-holmen
 */
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
