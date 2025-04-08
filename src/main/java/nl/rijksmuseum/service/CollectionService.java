package nl.rijksmuseum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.rijksmuseum.api.ApiClient;
import nl.rijksmuseum.api.GenericHTTPResponse;
import nl.rijksmuseum.enums.Culture;
import nl.rijksmuseum.model.CollectionQuery;
import nl.rijksmuseum.model.Collection;

import java.io.IOException;

public class CollectionService {

    private final ApiClient client = new ApiClient();
    private final String endpoint = "/collection";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Collection getCollection(Culture culture, CollectionQuery query) throws IOException {
        GenericHTTPResponse response = client.makeAuthenticatedRequest(culture, endpoint, query.toQueryString());
        return objectMapper.readValue(response.getResponseBody(), Collection.class);
    }
}
