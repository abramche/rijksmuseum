package nl.rijksmuseum.api;

import okhttp3.Response;

import java.io.IOException;

public class GenericHTTPResponse {
    private int responseCode;

    private String responseBody;

    public GenericHTTPResponse(Response response) {
        try {
            responseBody = response.body() != null ? response.body().string() : "";
            responseCode = response.code();
        } catch (IOException e) {
            throw new IllegalStateException("Bad response body: ", e);
        }
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
