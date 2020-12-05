package com.racing.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;

import java.util.List;

@At("https://www.racingpost.com/racecards/big-race-entries")
public class BigRaceEntriesPage extends PageObject {

    @FindBy(xpath="//*[contains(text(),'Big Race Entries')]")
    WebElementFacade bigRaceEntriesTab;

    @FindBy(css=".RC-bigRaces__race .RC-bigRaces__dateWide")
    WebElementFacade firstBigRaceDate;

    @FindBy(css=".ab-in-app-message", timeoutInSeconds = "15")
    List<WebElementFacade> promotionImage;

    @FindBy(css=".ab-close-button")
    WebElementFacade closeButton;

    @FindBy(css=".li.rh-bookmaker")
    List<WebElementFacade> todaysOfferSites;

    @FindBy(css="a.ui-tabs__tab_selected  div.ui-tabs__label")
    WebElementFacade activeTab;

    @FindBy(css="a.RC-bigRaces__link")
    WebElementFacade firstBigRaceTitle;

    public WebElementFacade getBigRaceEntriesHeader(){
        return bigRaceEntriesTab;
    }

    public String getFirstBigRaceDate(){
        return firstBigRaceDate.getText();
    }

    public List<WebElementFacade> getPromotion(){
        return promotionImage;
    }

    public List<WebElementFacade> getTodaysOfferSites(){
        return todaysOfferSites;
    }

    public void clickCloseButton(){
        closeButton.click();
    }

    public String getActiveTabTitle(){
        return activeTab.getText();
    }

    public void clickFirstBigRaceTitle(){
        firstBigRaceTitle.click();
    }

}
