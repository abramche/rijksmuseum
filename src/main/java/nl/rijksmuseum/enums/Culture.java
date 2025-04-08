package nl.rijksmuseum.enums;

public enum Culture {
    NL("nl"),
    EN("en")
    ;

    private final String culture;

    /**
     * @param culture - sets the language for API calls
     */
    Culture(String culture) {
        this.culture = culture;
    }

    @Override
    public String toString() {
        return culture;
    }
}
