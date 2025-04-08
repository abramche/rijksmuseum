package nl.rijksmuseum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection {
    @JsonProperty("count")
    public int count;

    @JsonProperty("artObjects")
    public List<ArtObject> artObjects;
}
