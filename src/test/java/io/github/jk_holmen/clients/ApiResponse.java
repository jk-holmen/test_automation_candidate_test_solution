package io.github.jk_holmen.clients;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

public class ApiResponse {
    
    private final HttpResponse<String> httpResponse;

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
}
