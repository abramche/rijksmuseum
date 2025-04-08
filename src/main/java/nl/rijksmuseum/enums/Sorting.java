package nl.rijksmuseum.enums;

public enum Sorting {
    RELEVANCE("relevance"),
    OBJECTTYPE("objecttype"),
    CHRONOLOGIC("chronologic"),
    ACHRONOLOGIC("achronologic"),
    ARTIST("artist"),
    ARTISTDESC("artistdesc"),
    ;

    private final String sorting;

    /**
     * @param sorting - Defines how search results should be sorted
     */
    Sorting(String sorting) {
        this.sorting = sorting;
    }

    @Override
    public String toString() {
        return sorting;
    }
}
