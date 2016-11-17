package com.pabloazana.repository;

import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.models.Detail;

public class DetailsRepository {

    private AwesomePlacesDataSource mDataSource;

    public DetailsRepository(AwesomePlacesDataSource dataSource) {
        mDataSource = dataSource;
    }

    public Detail getDetailsFromId(int awesomePlaceId) {
        return mDataSource.getAwesomePlaceDetails(awesomePlaceId);
    }



}
