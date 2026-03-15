package io.github.jk_holmen.clients;

import com.google.gson.Gson;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

/**
 * Wrapper around {@link HttpResponse} for API test assertions.
 * 
 * <p>
 * Provides direct access to status code, body, headers, as well as
 * deserialization
 * of JSON via {@link #as(Class)} into a response model object.
 * 
 * @author jk-holmen
 */
public class ApiResponse {

    private final HttpResponse<String> httpResponse;
    private static final Gson gson = new Gson();

    /**
     * Wraps a {@link HttpResponse} for convenient access and deserialization.
     * 
     * @param httpResponse the HTTP response to wrap
     */
    public ApiResponse(HttpResponse<String> httpResponse) {
        this.httpResponse = httpResponse;
    }

    /**
     * Returns the HTTP status code of the response.
     *
     * @return the status code
     */
    public int statusCode() {
        return httpResponse.statusCode();
    }

    /**
     * Returns the raw response body as a string.
     *
     * @return the response body
     */
    public String body() {
        return httpResponse.body();
    }

    /**
     * Returns the response headers.
     *
     * @return the HTTP headers
     */
    public HttpHeaders headers() {
        return httpResponse.headers();
    }

    /**
     * Deserializes the JSON response body into the specified type.
     * 
     * @param <T>  the target type
     * @param type the class to deserialize into
     * @return the deserialized object
     */
    public <T> T as(Class<T> type) {
        return gson.fromJson(httpResponse.body(), type);
    }
}
