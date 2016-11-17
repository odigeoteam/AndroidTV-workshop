package pabloazana.presentation.views.utils;


import pabloazana.presentation.presenter.SearchViewPresenter;

public class SearchRunnable implements Runnable {

    private String mQuery;
    private SearchViewPresenter mPresenter;

    public SearchRunnable(SearchViewPresenter presenter) {
        mPresenter = presenter;
    }

    public void setSearchQuery(String query){
        mQuery = query;
    }

    @Override
    public void run() {
        mPresenter.search(mQuery);
    }
}
