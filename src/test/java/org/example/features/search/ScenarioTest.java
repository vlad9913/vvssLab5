package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
@RunWith(SerenityRunner.class)
public class ScenarioTest {
    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps dictSteps;


    @Test
    public void scenario() throws InterruptedException {
        String username = "gtrompi@yahoo.com";
        String password = "vvsslab05";
        dictSteps.login(username,password);
        dictSteps.verifyGoodLogin(webdriver);
        dictSteps.search("gradina");
        dictSteps.verifySearch(webdriver,"gradina");
        dictSteps.accessAd(webdriver);
        dictSteps.addToFaves(webdriver);
        //dictSteps.logout(webdriver);
        //dictSteps.verifyBadLogin(webdriver);
        dictSteps.deleteFavs(webdriver);
        dictSteps.verifyNoOfFaves(webdriver);
    }
}
