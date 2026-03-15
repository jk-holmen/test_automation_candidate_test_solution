package io.github.jk_holmen.clients;

import java.io.IOException;
import io.github.jk_holmen.config.ConfigurationManager;

/**
 * Client for the Testpersonnumer dataset API.
 * 
 * <p>
 * Retrieves test personal numbers (testpersonnummer). The dataset ID
 * is resolved from {@link ConfigurationManager} at construction time.
 * 
 * @author jk-holmen
 */
public class TestpersonnummerClient extends BaseClient {

    private final String DATASET_ID = ConfigurationManager.getInstance().getDatasetId("testpersonnummer");
    private final String PATH = "/dataset/" + DATASET_ID + "/json?";

    /**
     * Creates a new client, with the base URL and dataset ID loaded from
     * configuration.
     */
    public TestpersonnummerClient() {
        super();
    }

    /**
     * Fetches a specific test personal number from the dataset.
     * 
     * @param testpersonnummer the personal number to look up
     * @return ApiResponse the wrapped HTTP response
     * @throws IOException
     * @throws InterruptedException
     */
    public ApiResponse getTestpersonnummer(String testpersonnummer)
            throws IOException, InterruptedException {
        return get(PATH + "testpersonnummer=" + testpersonnummer);
    }
}
