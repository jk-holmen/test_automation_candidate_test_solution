package io.github.jk_holmen.models;

/**
 * A single record from the Testpersonnummer dataset API response.
 *
 * <p>
 * Represents one entry in the {@link TestpersonnummerResponse#getResults()}
 * list. Fields are populated by Gson.
 *
 * @author jk-holmen
 */
public class TestpersonnummerResult {
    private String testpersonnummer;

    public String getTestpersonnummer() {
        return testpersonnummer;
    }
}
