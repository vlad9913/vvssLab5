package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@DefaultUrl("https://www.publi24.ro/")
public class DictionaryPage extends PageObject {


    public void login(String user, String pass){
        open();

        WebElementFacade startLogin = find(By.className("open-login-modal"));
        startLogin.click();
        WebElementFacade loginModal = find(By.id("form0"));
        WebElementFacade emailInput = loginModal.find(By.name("Email"));
        WebElementFacade passwordInput = loginModal.find(By.name("Password"));
        emailInput.type(user);
        passwordInput.type(pass);
        loginModal.submit();

    }

    public String verifyGoodLogin(WebDriver driver) throws InterruptedException {

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        for(int i=0 ; i<linkList.size() ; i++)
           try {
            if (linkList.get(i).getAttribute("href").contains("mesaje") && (linkList.get(i).getText().equals( "Mesaje")))
                {

                    return "Mesaje";
                }
           }catch(NullPointerException e){

        }

        return "Favorite";

        /*WebElementFacade menu = find(By.id("menu"));
        List <WebElement> lis =  menu.findElements(By.tagName("li"));
        WebElement li = lis.get(10);

        System.out.println(li.getText());

        return li.getText();*/

    }


    public void searchKeyword(String keyword){
        WebElementFacade searchBar = find(By.id("keyword"));
        //searchBar.click();
        searchBar.typeAndEnter(keyword);

    }

    public String verifySearch(WebDriver driver){

        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String accessAd(WebDriver driver){
        WebElement ul = driver.findElement(By.xpath("//ul[@class='listing radius']"));
        List <WebElement> ads = ul.findElements(By.tagName("li"));
        WebElement ad = ads.get(1);
        String link = "";
        try {
            WebElement linkclick = ad.findElement(By.tagName("a"));
            link = linkclick.getAttribute("href");
            linkclick.click();

        }
        catch (Exception e){

        }
        System.out.println(link);
        return link;

    }
    public String addToFaves(WebDriver driver){
        driver.findElement(By.id("denyWebPushNotification")).click();
        WebElement heart = driver.findElement(By.xpath("//span[@class='fa fa-heart favoriteIcon inactive']"));
        heart.click();
        return heart.getAttribute("class");
    }

    public void logout(WebDriver driver) throws InterruptedException {
        driver.navigate().refresh();

        WebElement contulMeu = driver.findElement(By.xpath("//a[@href='/pagini-personale']"));
        //WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='2178383837']")));
        contulMeu.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        String logout = driver.findElement(By.xpath("//a[@id='logout']")).getAttribute("href");
        driver.navigate().to("www.publi24.ro"+logout);

    }

    public void deleteFavs(WebDriver driver) {

        driver.findElement(By.xpath("//a[@href='/favorite']")).click();
        driver.findElement(By.xpath("//a[@class='errorbg radius deleteall']")).click();
        getAlert().accept();
    }

    public int verifyNoOfFavs(WebDriver driver){
        List<WebElement> list = driver.findElements(By.className("listing-image"));
        System.out.println(list);
        System.out.println(list.size());
        return list.size();
    }




}