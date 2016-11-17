package com.pabloazana.contracts;

import com.pabloazana.models.Category;
import com.pabloazana.models.Detail;

import java.util.List;

public interface AwesomePlacesDataSource {

    List<Category> getAwesomePlaces();
    Detail getAwesomePlaceDetails(int awesomePlaceId);

}
