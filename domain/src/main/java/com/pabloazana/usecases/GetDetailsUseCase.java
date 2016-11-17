package com.pabloazana.usecases;

import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.Detail;
import com.pabloazana.repository.DetailsRepository;

public class GetDetailsUseCase extends BaseUseCase<Detail> {

    private DetailsRepository mRepository;
    private int mAwesomePlaceId;

    public GetDetailsUseCase(ThreadExecutor threadExecutor, UIThreadExecutor uiThreadExecutor,
                             DetailsRepository repository) {
        super(threadExecutor, uiThreadExecutor);
        mRepository = repository;
    }

    public void setAwesomePlaceId(int awesomePlaceId) {
        mAwesomePlaceId = awesomePlaceId;
    }

    @Override
    void doAction(UseCaseListener useCaseListener) {
        Detail detailsResult = mRepository.getDetailsFromId(mAwesomePlaceId);
        onSuccess(detailsResult);
    }
}
