package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class FetchingDataFromRecommendedCarousel extends BaseClass {
    @Given("the user is on the home page of the website")
    public void the_user_is_on_the_home_page_of_the_website() throws IOException {
        setup();
    }

    @And("number of items in recommended for you is fetched")
    public void number_of_items_in_recommended_for_you_is_fetched() throws InterruptedException {
        pageFactory.getHomePage().fetchRecommendedForYouItems();
    }
}
