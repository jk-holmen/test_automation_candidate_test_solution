package io.github.jk_holmen.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import io.github.jk_holmen.config.ConfigurationManager;

/**
 * Base HTTP client for API test automation.
 * 
 * <p>
 * Provides a shared {@link HttpClient} instance and common request methods
 * that subclasses can use to interact with specific API resources.
 * 
 * @author jk-holmen
 */
public class BaseClient {

    protected final HttpClient client;
    protected final String BASE_URL;

    private final Long CONNECTION_TIMEOUT = ConfigurationManager.getInstance().getConnectionTimeout();
    private final Long RESPONSE_TIMEOUT = ConfigurationManager.getInstance().getResponseTimeout();

    /**
     * Creates a client with a default {@link HttpClient} and the base URL
     * from {@link ConfigurationManager#getBaseUrl()}.
     */
    public BaseClient() {
        client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT)).build();
        BASE_URL = ConfigurationManager.getInstance().getBaseUrl();
    }

    /**
     * Sends a GET request to the specified endpoint path and returns a response.
     * 
     * <p>
     * The full URL is constructed by appending the endpoint {@code path} to
     * {@code BASE_URL}.
     * The path should include a leading slash.
     * 
     * @param path the resource path to append to the base URL
     * @return ApiResponse the wrapped HTTP response
     * @throws IOException
     * @throws InterruptedException
     */
    public ApiResponse get(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + path))
                .timeout(Duration.ofSeconds(RESPONSE_TIMEOUT)).build();

        ApiResponse response = new ApiResponse(client.send(request, BodyHandlers.ofString()));
        return response;
    }
}
