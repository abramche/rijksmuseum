package nl.rijksmuseum.api;

import nl.rijksmuseum.enums.Culture;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ApiClient {
    private static final Logger logger = LoggerFactory.getLogger(ApiClient.class);
    public static final String BASE_URL = "https://www.rijksmuseum.nl/api";
    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient();

    public ApiClient() {
        apiKey = System.getenv("RIJKSMUSEUM_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            logger.error("Environment variable 'RIJKSMUSEUM_API_KEY' is not set.");
        }
    }

    public GenericHTTPResponse makeAuthenticatedRequest(Culture culture, String endpoint, String query) {
        String url = BASE_URL + "/" + culture + endpoint + "?query=" + query + "&key=" + apiKey;

        Request request = new Request.Builder()
                .url(url)
                .build();

        logRequest(request);
        GenericHTTPResponse httpResponse = null;

        try (Response response = client.newCall(request).execute()) {
            httpResponse = new GenericHTTPResponse(response);
            logResponse(response, httpResponse.getResponseBody());
        } catch (IOException e) {
            logger.error("An error occurred while sending the request: ", e);
        }
        return httpResponse;
    }

    private void logRequest(Request request) {
        Headers headers = request.headers();
        StringBuilder headersString = new StringBuilder();
        for (String name : headers.names()) {
            headersString.append(name).append(": ").append(headers.get(name)).append("\n");
        }

        logger.info("{} {}\n{}\nBody:\n{}",
                request.method(),
                maskApiKey(request.url()),
                headersString,
                request.body() != null ? request.body() : "<none>");
    }

    private void logResponse(Response response, String responseBody) {
        Headers headers = response.headers();
        StringBuilder headersString = new StringBuilder();
        for (String name : headers.names()) {
            headersString.append(name).append(": ").append(headers.get(name)).append("\n");
        }

        logger.info("Got HTTP [{}] from {}\n{}\nBody:\n{}",
                response.code(),
                maskApiKey(response.request().url()),
                headersString,
                responseBody.isEmpty() ? "<none>" : abbreviate(responseBody, 1000));
    }

    private String maskApiKey(HttpUrl s) {
        return String.valueOf(s).replaceAll("(?<=key=)[^&]*", "***");
    }

    private String abbreviate(String input, int maxLength) {
        if (input == null || input.length() <= maxLength) {
            return input;
        }
        if (maxLength <= 3) {
            return "...".substring(0, maxLength);
        }
        return input.substring(0, maxLength - 3) + "...";
    }
}
