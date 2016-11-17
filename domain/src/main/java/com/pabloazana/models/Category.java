package com.pabloazana.models;

import java.util.List;

public class Category {

    public enum CardType {
        IMAGE_ONLY,
        DESCRIPTION
    }

    private String mCategoryName;
    private String mResourceIconName;
    private List<AwesomePlace> mAwesomePlaceList;
    private CardType mCardType;

    public Category(String categoryName, List<AwesomePlace> awesomePlaceList, CardType cardType,
                    String resourceIconName) {
        mCategoryName = categoryName;
        mAwesomePlaceList = awesomePlaceList;
        mCardType = cardType;
        mResourceIconName = resourceIconName;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public List<AwesomePlace> getAwesomePlaceList() {
        return mAwesomePlaceList;
    }

    public CardType getCardType() {
        return mCardType;
    }

    public void addAwesomePlace(AwesomePlace awesomePlace) {
        mAwesomePlaceList.add(awesomePlace);
    }

    public String getResourceIconName() {
        return mResourceIconName;
    }
}
