package io.github.jk_holmen.clients;

import java.io.IOException;
import io.github.jk_holmen.config.ConfigurationManager;

public class TestpersonnummerClient extends BaseClient {

    private final String DATASET_ID = ConfigurationManager.getInstance().getDatasetId("testpersonnummer");
    private final String PATH = "/dataset/" + DATASET_ID + "/json?";

    public TestpersonnummerClient() {
        super();
    }

    public ApiResponse getTestpersonnummer(String testpersonnummer)
            throws IOException, InterruptedException {
        return get(PATH + "testpersonnummer=" + testpersonnummer);
    }
}
