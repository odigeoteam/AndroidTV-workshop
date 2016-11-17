package pabloazana.controllers.data.datasource;


import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.models.Category;

import java.util.List;


public class AwesomePlacesCacheImp implements InMemoryCache<List<Category>> {

    private List<Category> mAwesomePlaces;
    private static AwesomePlacesCacheImp instance;

    public static AwesomePlacesCacheImp getInstance() {
        if (instance == null) {
            instance = new AwesomePlacesCacheImp();
        }

        return instance;
    }

    @Override
    public synchronized List<Category> getObjects() {
        return mAwesomePlaces;
    }

    @Override
    public synchronized void setObjects(List<Category> awesomePlaces) {
        mAwesomePlaces = awesomePlaces;
    }
}
