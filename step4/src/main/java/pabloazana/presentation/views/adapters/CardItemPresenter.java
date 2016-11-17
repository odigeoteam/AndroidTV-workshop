package pabloazana.presentation.views.adapters;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.support.v7.view.ContextThemeWrapper;
import android.view.ViewGroup;

import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category.CardType;
import com.squareup.picasso.Picasso;

import pabloazana.DependencyInjector;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.step4.R;

import static com.pabloazana.models.Category.CardType.DESCRIPTION;

public class CardItemPresenter extends Presenter {

    private static final int CARD_WIDTH = 500;
    private static final int CARD_HEIGHT = 250;

    private ImageDataSource mImageDataSource;
    private CardType mCardType;

    public CardItemPresenter(Context context, CardType cardType) {
        mImageDataSource = DependencyInjector.getInstance().injectImageDataSource(context);
        mCardType = cardType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        ImageCardView cardView = mCardType.equals(DESCRIPTION) ?
                buildDescriptionImagecradView(parent.getContext()) : buildImageOnlyImageCardView(parent.getContext());
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        AwesomePlace placeItem = (AwesomePlace) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        mImageDataSource.paintImage(cardView.getMainImageView(), placeItem.getCardImageUri());
        if(mCardType.equals(DESCRIPTION)){
            cardView.setTitleText(placeItem.getName());
            cardView.setContentText(placeItem.getLittleDescription());
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }

    private void setBackGroundColor(ImageCardView imageCardView, boolean isSelected) {
        imageCardView.findViewById(R.id.info_field).setBackgroundColor(isSelected ? imageCardView.getResources().getColor(R.color.primary_brand) :
                imageCardView.getResources().getColor(R.color.primary_brand_dark));
    }

    private ImageCardView buildDescriptionImagecradView(Context context) {
        ImageCardView cardView = new ImageCardView(context){
            @Override
            public void setSelected(boolean selected) {
                setBackGroundColor(this, selected);
                super.setSelected(selected);
            }
        };

        setBackGroundColor(cardView, false);

        return cardView;
    }

    private ImageCardView buildImageOnlyImageCardView(Context context) {
        return new ImageCardView(new ContextThemeWrapper(context, R.style.CustomImageCardTheme)){
            @Override
            public void setSelected(boolean selected) {
                super.setSelected(selected);
            }
        };
    }
}
