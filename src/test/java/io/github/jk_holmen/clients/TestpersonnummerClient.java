package io.github.jk_holmen.clients;

import java.io.IOException;
import java.net.http.HttpResponse;

import io.github.jk_holmen.config.ConfigurationManager;

public class TestpersonnummerClient extends BaseClient {

    private final String datasetId = ConfigurationManager.getInstance().getDatasetId("testpersonnummer");
    private final String BASE_PATH = "/dataset/" + datasetId + "/json?";

    public TestpersonnummerClient() {
        super();
    }

    public HttpResponse<String> getTestpersonnummer(String testpersonnummer) throws IOException, InterruptedException {
        return get(BASE_PATH + "testpersonnummer=" + testpersonnummer);
    }
}
