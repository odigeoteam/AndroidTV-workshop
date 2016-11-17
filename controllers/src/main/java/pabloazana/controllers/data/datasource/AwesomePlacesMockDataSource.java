package pabloazana.controllers.data.datasource;

import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.models.Category;
import com.pabloazana.models.Detail;

import java.util.ArrayList;
import java.util.List;

import pabloazana.controllers.data.mocks.MockAwesomePlaces;


public class AwesomePlacesMockDataSource implements AwesomePlacesDataSource {

    @Override
    public List<Category> getAwesomePlaces() {

        try {
            /* Sleep 3 sec in order to simulate a long request */
            Thread.sleep(3000);

        } catch (InterruptedException ignored) { }

        List<Category> mainCategories = new ArrayList<>();
        mainCategories.add(MockAwesomePlaces.getHungryTravel());
        mainCategories.add(MockAwesomePlaces.getMovieDestination());
        mainCategories.add(MockAwesomePlaces.getOnceUponATime());
        return mainCategories;
    }

    @Override
    public Detail getAwesomePlaceDetails(int awesomePlaceId) {
        return MockAwesomePlaces.getDetailsFromId(awesomePlaceId);
    }
}
