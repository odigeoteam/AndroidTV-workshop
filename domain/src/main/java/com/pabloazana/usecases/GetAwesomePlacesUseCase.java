package com.pabloazana.usecases;


import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.Category;
import com.pabloazana.repository.AwesomePlacesRepository;

import java.util.List;

public class GetAwesomePlacesUseCase extends BaseUseCase<List<Category>> {

    private AwesomePlacesRepository mAwesomePlacesRepository;

    public GetAwesomePlacesUseCase(AwesomePlacesRepository awesomePlacesRepository, ThreadExecutor threadExecutor,
                                   UIThreadExecutor uiThreadExecutor) {
        super(threadExecutor, uiThreadExecutor);
        mAwesomePlacesRepository = awesomePlacesRepository;
    }

    @Override
    protected void doAction(UseCaseListener useCaseListener) {
        List<Category> awesomePlaceList = mAwesomePlacesRepository.getAwesomePlaces();
        onSuccess(awesomePlaceList);
    }

    public List<Category> getAwesomePlacesFromCache() {
        return mAwesomePlacesRepository.getAwesomePlaces();
    }

}
