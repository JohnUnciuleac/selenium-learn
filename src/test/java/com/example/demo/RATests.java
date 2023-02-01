package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserHelper;
import utils.RAPage;

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
    }

    @AfterAll
    void afterAll() {
        driver.close();
    }

    @Test
    void shouldNotBeAbleToLogin() {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        raPage.inputUsername.sendKeys("Selenium Test");
        raPage.inputPassword.sendKeys("Selenium");

        raPage.checkboxRememberMe.click();
        raPage.checkboxAgreeTandC.click();

        raPage.buttonSign.click();

        System.out.println(new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(raPage.errorText)).getText());

    }

}
