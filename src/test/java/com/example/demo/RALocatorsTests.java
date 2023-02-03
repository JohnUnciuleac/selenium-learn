package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserHelper;
import PageModels.RAPage;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RATests {
    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private RAPage raPage;

    @BeforeAll
    void beforeAll() {
        driver = browserHelper.getChromeDriver();
        raPage = PageFactory.initElements(driver, RAPage.class);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
    }

    @AfterAll
    void afterAll() {
        driver.close();
    }

    @Test
    void shouldNotBeAbleToLogin() {

        raPage.inputUsername.sendKeys("Selenium Test");
        raPage.inputPassword.sendKeys("Selenium");

        raPage.checkboxRememberMe.click();
        raPage.checkboxAgreeTAndC.click();

        raPage.buttonSign.click();

        System.out.println(new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(raPage.errorText)).getText());

    }

    @Test
    void shouldBeAbleToResetCredentials() throws InterruptedException {

        raPage.linkForgotYourPassword.click();

        raPage.inputNameResetCredentials.sendKeys("Reset Credentials Test");
        raPage.inputEmailResetCredentials.sendKeys("rahulshettyacademy");
        raPage.inputPhoneNumberResetCredentials.sendKeys("8593762834");

        Thread.sleep(2000);

        raPage.buttonResetLogin.click();

        System.out.println(raPage.textInfoResetCredentials.getText());

    }

    @Test
    void shouldBeAbleToLogin() throws InterruptedException {

        raPage.inputUsername.sendKeys("Selenium Test");
        raPage.inputPassword.sendKeys("rahulshettyacademy");

        raPage.checkboxRememberMe.click();
        raPage.checkboxAgreeTAndC.click();

        raPage.buttonSign.click();

        Thread.sleep(3000);

        Assert.assertEquals(raPage.textSuccessfulLogin.getText(),"You are successfully logged in.");
        Assert.assertEquals(raPage.textUsernameSuccessfulLogin.getText(), "Hello Selenium Test,");

        raPage.buttonLogout.click();

    }

}
