package io.github.jk_holmen.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import io.github.jk_holmen.config.ConfigurationManager;

public class BaseClient {

    protected final HttpClient client;
    protected final String BASE_URL;

    public BaseClient() {
        client = HttpClient.newBuilder().build();
        BASE_URL = ConfigurationManager.getInstance().getBaseUrl();
    }

    public ApiResponse get(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + path)).build();

        ApiResponse response = new ApiResponse(client.send(request, BodyHandlers.ofString()));
        return response;
    }
}
