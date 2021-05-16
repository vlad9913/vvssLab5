package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

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

    public String verifyGoodLogin() throws InterruptedException {
        WebElementFacade menu = find(By.id("menu"));
        List <WebElement> lis =  menu.findElements(By.tagName("li"));
        WebElement li = lis.get(10);

            System.out.println(li.getText());

        return li.getText();

    }



}