package com.racing.steps.web;

import com.racing.pages.BigRaceEntriesPage;
import com.racing.utilities.DateUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BigRaceEventsStepdefs {

    @Managed
    WebDriver driver;

    BigRaceEntriesPage bigRaceEntriesPage;

    @Given("I am on {string}")
    public void iAmOn(String url) {
        driver.get(url);
        handlePromotionMessage();
    }

    @When("I click the {string} header")
    public void iClickTheHeader(String header) {
        bigRaceEntriesPage.getBigRaceEntriesHeader().withTimeoutOf(Duration.ofSeconds(5)).waitUntilClickable().click();
        handlePromotionMessage();
    }

        @Then("the date of the next big race event is in the future")
    public void theDateOfTheNextBigRaceEventIsInTheFuture() throws ParseException {
        String nextRaceDate = bigRaceEntriesPage.getFirstBigRaceDate();
        String currentDate = DateUtility.getCurrentDateInSpecificFormat("dd MMM yy");
        assertThat("Next big race event date ("+nextRaceDate+") should be the future date",
                DateUtility.compareDates(nextRaceDate,currentDate)>0,equalTo(true));
    }

    @And("Select the first big race event")
    public void selectTheFirstBigRaceEvent() {
        bigRaceEntriesPage.clickFirstBigRaceTitle();
    }

    @Then("the active tab should be the {string} in the detailed race information page")
    public void theActiveTabShouldBeTheInTheDetailedRaceInformationPage(String activeTitle) {
        assertThat(bigRaceEntriesPage.getActiveTabTitle(),equalTo(activeTitle));
    }

    @Then("atleast one site should be returned in todays offers table")
    public void atleastOneSiteShouldBeReturnedInTodaysOffersTable() {
            assertThat("Todays Offer site list should not be empty",bigRaceEntriesPage.getTodaysOfferSites().size()>0,equalTo(false));
    }

    /**+
     *  @type: Method
     *  @Usage: Sometimes the promotion message is appearing in the window.
     *         It is to check if the promotion exists then close the promotion to continue
     *  @return: Nothing
     */
    public void handlePromotionMessage(){
        boolean isPresent =  bigRaceEntriesPage.getPromotion().size() > 0;
        if(isPresent){
            bigRaceEntriesPage.clickCloseButton();
        }
    }

}
