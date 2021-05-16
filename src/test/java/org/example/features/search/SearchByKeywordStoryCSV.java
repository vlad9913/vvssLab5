package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src\\test\\resources\\monthly_brands_list.csv")
public class SearchByKeywordStoryCSV {

    private  String user;
    private  String pass;


    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps dictSteps;


    /*@Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_should_display_the_corresponding_article() {
        dictSteps.is_the_home_page();
        dictSteps.looks_for(word);
        dictSteps.should_see_definition(description);
    }*/

    @Test
    public void test_login() throws InterruptedException {
        dictSteps.login(user,pass);
        if(user.equals("gtrompi@yahoo.com")){
            dictSteps.verifyGoodLogin(webdriver);
        }else{
            dictSteps.verifyBadLogin(webdriver);
        }
    }




}
