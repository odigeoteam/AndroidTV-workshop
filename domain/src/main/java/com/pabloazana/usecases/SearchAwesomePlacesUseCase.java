package com.pabloazana.usecases;

import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category;

import java.util.ArrayList;
import java.util.List;


public class SearchAwesomePlacesUseCase extends BaseUseCase<List<Category>> {

    private InMemoryCache<List<Category>> mCache;
    private String mQuery;

    public SearchAwesomePlacesUseCase(ThreadExecutor threadExecutor, UIThreadExecutor uiThreadExecutor,
                                      InMemoryCache<List<Category>> cache) {
        super(threadExecutor, uiThreadExecutor);
        mCache = cache;
    }

    public void setQuery(String query) {
        mQuery = query;
    }

    @Override
    void doAction(UseCaseListener useCaseListener) {
        List<Category> searchResult = mCache.getObjects();
        onSuccess(searchInArray(searchResult));
    }

    private List<Category> searchInArray(List<Category> allCategories) {

        List<Category> result = new ArrayList<>();

        for (Category category : allCategories) {
            Category categoryResult = null;
            for (AwesomePlace awesomePlace : category.getAwesomePlaceList()) {
                List<AwesomePlace> awesomeResult = new ArrayList<>();
                if(matchQuery(awesomePlace, mQuery)){
                    awesomeResult.add(awesomePlace);
                    if(categoryResult == null){
                        categoryResult = new Category(category.getCategoryName(), awesomeResult, category.getCardType(), "ic_airplane");
                    } else {
                        categoryResult.addAwesomePlace(awesomePlace);
                    }
                }
            }
            if(categoryResult != null){
                result.add(categoryResult);
            }
        }

        return result;
    }

    private boolean matchQuery(AwesomePlace awesomePlace, String query) {
        return (awesomePlace.getName().toLowerCase().contains(query.toLowerCase()) ||
                awesomePlace.getLittleDescription().toLowerCase().contains(query.toLowerCase()));
    }
}
