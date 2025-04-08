package nl.rijksmuseum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtObject {
    @JsonProperty("id")
    public String id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("principalOrFirstMaker")
    public String principalOrFirstMaker;

    @JsonProperty("longTitle")
    public String longTitle;

}
