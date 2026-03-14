package io.github.jk_holmen.clients;

import com.google.gson.Gson;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

public class ApiResponse {

    private final HttpResponse<String> httpResponse;
    private static final Gson gson = new Gson();

    public ApiResponse(HttpResponse<String> httpResponse) {
        this.httpResponse = httpResponse;
    }

    public int statusCode() {
        return httpResponse.statusCode();
    }

    public String body() {
        return httpResponse.body();
    }

    public HttpHeaders headers() {
        return httpResponse.headers();
    }

    public <T> T as(Class<T> type) {
        return gson.fromJson(httpResponse.body(), type);
    }
}
