package nl.rijksmuseum.enums;

public enum ArtType {
    PAINTING("painting")
    ;

    private final String artType;

    /**
     * @param artType - The type of the object (singular). E.g. painting
     */
    ArtType(String artType) {
        this.artType = artType;
    }

    @Override
    public String toString() {
        return artType;
    }
}
