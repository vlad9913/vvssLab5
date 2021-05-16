package org.example.steps.serenity;

import org.example.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        //dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        //dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        //assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    @Step
    public void login(String user, String pass){
        dictionaryPage.login(user,pass);
    }
    @Step
    public void verifyGoodLogin(WebDriver driver) throws InterruptedException {
        assert (dictionaryPage.verifyGoodLogin(driver).equals("Mesaje"));
    }
    @Step
    public void verifyBadLogin(WebDriver driver) throws InterruptedException {
        assert (dictionaryPage.verifyGoodLogin(driver).equals("Favorite"));
    }
    @Step
    public void search(String string){
        dictionaryPage.searchKeyword(string);
    }
    @Step
    public void verifySearch(WebDriver driver,String string){
        assert(dictionaryPage.verifySearch(driver).equals("https://www.publi24.ro/anunturi/?q=" + string));
    }
    @Step
    public void accessAd(WebDriver driver){
        assert(dictionaryPage.accessAd(driver).equals(dictionaryPage.verifySearch(driver)));
    }
    @Step
    public void addToFaves(WebDriver driver){
        assert(dictionaryPage.addToFaves(driver).equals("fa fa-heart favoriteIcon inactive active"));
    }
    @Step
    public void logout(WebDriver driver) throws InterruptedException {
        dictionaryPage.logout(driver);
    }
    @Step
    public void deleteFavs(WebDriver driver){
        dictionaryPage.deleteFavs(driver);

    }
    @Step
    public void verifyNoOfFaves(WebDriver driver){
        assert(dictionaryPage.verifyNoOfFavs(driver)==0);
    }
}