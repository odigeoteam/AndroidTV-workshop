package com.pabloazana;

import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.Category;
import com.pabloazana.repository.AwesomePlacesRepository;
import com.pabloazana.repository.DetailsRepository;
import com.pabloazana.usecases.GetAwesomePlacesUseCase;
import com.pabloazana.usecases.GetDetailsUseCase;
import com.pabloazana.usecases.SearchAwesomePlacesUseCase;

import java.util.List;

public abstract class DomainDependencyInjector {

    public abstract ThreadExecutor injectThreadExecutor();
    public abstract UIThreadExecutor injectUIThreadExecutor();
    public abstract InMemoryCache<List<Category>> injectInMemoryCache();
    public abstract AwesomePlacesDataSource injectAwesomePlaceDataSource();


    protected GetAwesomePlacesUseCase injectGetAwesomePlacesUseCase() {
        return new GetAwesomePlacesUseCase(injectAwesomePlaceRepository(), injectThreadExecutor(), injectUIThreadExecutor());
    }

    protected SearchAwesomePlacesUseCase injectSearchAwesomePlacesUseCase(){
        return new SearchAwesomePlacesUseCase(injectThreadExecutor(), injectUIThreadExecutor(), injectInMemoryCache());
    }

    protected GetDetailsUseCase injectGetDetailUseCase() {
        return new GetDetailsUseCase(injectThreadExecutor(), injectUIThreadExecutor(), injectDetailsRepository());
    }

    private AwesomePlacesRepository injectAwesomePlaceRepository() {
        return new AwesomePlacesRepository(injectAwesomePlaceDataSource(),injectInMemoryCache());
    }

    private DetailsRepository injectDetailsRepository() {
        return new DetailsRepository(injectAwesomePlaceDataSource());
    }




}
