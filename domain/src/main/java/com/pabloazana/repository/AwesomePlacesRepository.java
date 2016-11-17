package com.pabloazana.repository;

import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.models.Category;

import java.util.List;


public class AwesomePlacesRepository {

    private AwesomePlacesDataSource mAwesomePlacesDataSource;
    private InMemoryCache<List<Category>> mCache;

    public AwesomePlacesRepository(AwesomePlacesDataSource awesomePlacesDataSource,
                                   InMemoryCache<List<Category>> cache) {
        mAwesomePlacesDataSource = awesomePlacesDataSource;
        mCache = cache;
    }

    public List<Category> getAwesomePlaces() {
        List<Category> awesomePlacesResponse = mCache.getObjects();
        if(awesomePlacesResponse == null){
            awesomePlacesResponse = mAwesomePlacesDataSource.getAwesomePlaces();
            mCache.setObjects(awesomePlacesResponse);
        }

        return awesomePlacesResponse;
    }
}
