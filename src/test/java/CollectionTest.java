import nl.rijksmuseum.enums.Culture;
import nl.rijksmuseum.model.ArtObject;
import nl.rijksmuseum.model.CollectionQuery;
import nl.rijksmuseum.model.Collection;
import nl.rijksmuseum.service.CollectionService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CollectionTest {

    @Test
    public void collectionPaginationMaxObjectTest() {
        // given
        CollectionService collectionService = new CollectionService();
        int maxPageSize = 5;
        CollectionQuery query = new CollectionQuery()
                .setInvolvedMaker("Rembrandt van Rijn").setResultsPerPage(maxPageSize);

        // when
        Collection collection = collectionService.getCollection(Culture.NL, query);

        // then
        assertThat(collection.artObjects.size()).isLessThanOrEqualTo(maxPageSize);
    }

    @Test
    public void collectionMakerQueryTest() {
        // given
        CollectionService collectionService = new CollectionService();
        String painter = "Rembrandt van Rijn";
        CollectionQuery query = new CollectionQuery()
                .setInvolvedMaker(painter);

        // when
        Collection collection = collectionService.getCollection(Culture.NL, query);

        // then
        assertThat(collection.count).isGreaterThan(0);
        for (ArtObject artObject : collection.artObjects) {
            assertThat(artObject.principalOrFirstMaker).containsIgnoringCase(painter);
        }
    }

    @Test
    public void collectionTextQueryTest() {
        // given
        CollectionService collectionService = new CollectionService();
        String expectedArtTitle = "De Nachtwacht";
        CollectionQuery query = new CollectionQuery()
                .setQuery(expectedArtTitle)
                .setCulture(Culture.NL);

        // when
        Collection collection = collectionService.getCollection(Culture.NL, query);

        // then
        assertThat(collection.count).isGreaterThan(0);
        for (ArtObject artObject : collection.artObjects) {
            assertThat(artObject.longTitle).containsIgnoringCase(expectedArtTitle);
        }
    }
}
