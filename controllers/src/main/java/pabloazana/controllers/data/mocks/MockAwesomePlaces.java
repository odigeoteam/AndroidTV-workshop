package pabloazana.controllers.data.mocks;

import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category;
import com.pabloazana.models.Detail;

import java.util.ArrayList;
import java.util.List;

public class MockAwesomePlaces {


    public static Category getHungryTravel() {

        List<AwesomePlace> hungryTravel = new ArrayList<>();


        AwesomePlace malaga = new AwesomePlace(1, "MÁLAGA", "Tasty grilled fish", "malaga_card",
                "malaga_background", buildDetailsForMalaga());
        AwesomePlace mexico = new AwesomePlace(2, "MÉXICO", "The authentic burritos", "mexico_card",
                "mexico_background", buildDetailsForMexico());
        AwesomePlace naples = new AwesomePlace(3, "NAPLES", "Discover the pizza", "naples_card",
                "naples_background", buildDetailsForNaples());
        AwesomePlace newYork = new AwesomePlace(4, "NEW YORK", "The burger temple", "ny_card",
                "ny_background", buildDetailsForNY());
        AwesomePlace tokyo = new AwesomePlace(5, "TOKYO", "The mystery of sushi", "tokyo_card",
                "tokyo_background", buildDetailsForTokyo());

        hungryTravel.add(malaga);
        hungryTravel.add(mexico);
        hungryTravel.add(naples);
        hungryTravel.add(newYork);
        hungryTravel.add(tokyo);

        return new Category("Hungry for travel", hungryTravel, Category.CardType.DESCRIPTION, "ic_airplane");
    }

    public static Category getMovieDestination() {

        List<AwesomePlace> movieDestinations = new ArrayList<>();


        AwesomePlace chicago = new AwesomePlace(6, "Chicago", "",
                "chicago_card", "chicago_background", buildDetailsForChicago());
        AwesomePlace newYork = new AwesomePlace(7, "New York", "T",
                "new_york_card", "new_york_background", buildDetailsForNYC());
        AwesomePlace newZeland = new AwesomePlace(8, "New Zelan", "",
                "new_zeland_card", "new_zeland_background", buildDetailsForNewZealand());
        AwesomePlace paris = new AwesomePlace(9, "Paris", "",
                "paris_card", "paris_background",  buildDetailsForParis());
        AwesomePlace sanFrancisco = new AwesomePlace(10, "San Francisco", "",
                "san_francisco_card", "san_francisco_background",  buildDetailsForSanFrancisco());

        movieDestinations.add(chicago);
        movieDestinations.add(newYork);
        movieDestinations.add(newZeland);
        movieDestinations.add(paris);
        movieDestinations.add(sanFrancisco);

        return new Category("Movie destinations", movieDestinations, Category.CardType.IMAGE_ONLY, "ic_airplane");
    }

    public static Category getOnceUponATime() {
        List<AwesomePlace> unceUponATime = new ArrayList<>();


        AwesomePlace cambodia = new AwesomePlace(11, "CAMBODIA", "Kingdom of Wonde", "cambodia_card",
                "cambodia_background", buildDetailsForCambodia());
        AwesomePlace china = new AwesomePlace(12, "CHINA", "The Great Wall", "china_card",
                "china_background", buildDetailsForChina());
        AwesomePlace egypt = new AwesomePlace(13, "EGYPT", "The cradle of civilization", "egypt_card",
                "egypt_background", buildDetailsForEgipto());
        AwesomePlace mexico = new AwesomePlace(14, "MEXICO", "Amazing Temples", "mexico_upon_card",
                "mexico_upon_background", buildDetailsForMX());
        AwesomePlace roma = new AwesomePlace(15, "ROMA", "All roads lead to Rome", "roma_card",
                "roma_background", buildDetailsForRome());

        unceUponATime.add(cambodia);
        unceUponATime.add(china);
        unceUponATime.add(egypt);
        unceUponATime.add(mexico);
        unceUponATime.add(roma);

        return new Category("Once upon a time", unceUponATime, Category.CardType.DESCRIPTION, "ic_airplane");
    }

    private static Detail buildDetailsForMalaga() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("malaga_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForMexico() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("mexico_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForNaples() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("naples_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForNY() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("new_york_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForTokyo() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("tokyo_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForChicago() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("chicago_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForNYC() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("ny_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForNewZealand() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("new_zealand_01_1920");
        carouselImages.add("new_zealand_03_1920");
        carouselImages.add("new_zealand_04_1920");
        carouselImages.add("new_zealand_05_1920");
        carouselImages.add("new_zealand_06_1920");
        carouselImages.add("new_zealand_07_1920");
        return new Detail("This the long description of this awesome place",
                "awakening", carouselImages);
    }

    private static Detail buildDetailsForParis() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("paris_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForSanFrancisco() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("san_francisco_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForCambodia() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("cambodia_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForChina() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("china_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForEgipto() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("egypt_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForMX() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("mexico_upon_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    private static Detail buildDetailsForRome() {
        List<String> carouselImages = new ArrayList<>();
        carouselImages.add("roma_background");
        return new Detail("This the long description of this awesome place",
                "", carouselImages);
    }

    public static Detail getDetailsFromId(int awesomePlaceId) {
        Category hungry = getHungryTravel();
        Category movies = getMovieDestination();
        Category upon = getOnceUponATime();

        for(AwesomePlace awesomePlace : hungry.getAwesomePlaceList()) {
            if(awesomePlace.getId() == awesomePlaceId) {
                return awesomePlace.getDetails();
            }
        }

        for(AwesomePlace awesomePlace : movies.getAwesomePlaceList()) {
            if(awesomePlace.getId() == awesomePlaceId) {
                return awesomePlace.getDetails();
            }
        }

        for(AwesomePlace awesomePlace : upon.getAwesomePlaceList()) {
            if(awesomePlace.getId() == awesomePlaceId) {
                return awesomePlace.getDetails();
            }
        }

        return null;


    }


}
