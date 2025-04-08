package nl.rijksmuseum.enums;

public enum Culture {
    NL("nl"),
    BE("be")
    ;

    private final String culture;

    /**
     * @param culture - sets the region for API calls
     */
    Culture(String culture) {
        this.culture = culture;
    }

    @Override
    public String toString() {
        return culture;
    }
}
