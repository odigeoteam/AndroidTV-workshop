package pabloazana.presentation.views.adapters;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;
import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category.CardType;
import com.squareup.picasso.Picasso;
import pabloazana.DependencyInjector;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.step2.R;

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
                buildDescriptionImagecardView(parent.getContext()) : buildImageOnlyImageCardView(parent.getContext());
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {

        AwesomePlace placeItem = (AwesomePlace) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        Picasso.with(viewHolder.view.getContext()).
                load(mImageDataSource.getResourceIdByName(placeItem.getCardImageUri(), "drawable")).
                resize(CARD_WIDTH, CARD_HEIGHT).centerCrop().into(cardView.getMainImageView());

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

    private ImageCardView buildDescriptionImagecardView(Context context) {
        /* Implement this method for creating a card which should have the background
         * image, the title of the destination and the content of the destination. Also should use
         * the setBackgroundColor method for updating the background of the card when has he focus*/
        return null;
    }

    private ImageCardView buildImageOnlyImageCardView(Context context) {
        /* Implement this method for creating a card which should have just the backgroundImage.
         * Tip: you have already a Theme created in the styles */
        return null;
    }

    private void setBackGroundColor(ImageCardView imageCardView, boolean isSelected) {
        imageCardView.findViewById(R.id.info_field).setBackgroundColor(isSelected ? imageCardView.getResources().getColor(R.color.primary_brand) :
                imageCardView.getResources().getColor(R.color.primary_brand_dark));
    }
}
