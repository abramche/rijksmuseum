package nl.rijksmuseum.model;

import nl.rijksmuseum.enums.ArtType;
import nl.rijksmuseum.enums.Culture;
import nl.rijksmuseum.enums.Sorting;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionQuery {
    private final Map<String, String> params = new LinkedHashMap<>();

    public CollectionQuery setCulture(Culture culture) {
        params.put("culture", culture.toString());
        return this;
    }

    public CollectionQuery setType(ArtType type) {
        params.put("type", type.toString());
        return this;
    }

    public CollectionQuery setSorting(Sorting sorting) {
        params.put("s", sorting.toString());
        return this;
    }

    public CollectionQuery setInvolvedMaker(String involvedMaker) {
        params.put("involvedMaker", involvedMaker);
        return this;
    }

    public CollectionQuery setResultsPerPage(int ps) {
        params.put("ps", String.valueOf(ps));
        return this;
    }

    public CollectionQuery setPage(int page) {
        params.put("p", String.valueOf(page));
        return this;
    }

    public String toQueryString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.name()))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported", e);
            }
        }
        return sb.toString();
    }
}