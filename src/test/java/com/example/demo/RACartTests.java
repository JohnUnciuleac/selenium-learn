package com.example.demo;

import PageModels.RACartPage;
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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RACartTests {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private WebDriverWait wait;
    private RACartPage raCartPage;

    @BeforeAll
    void beforeAll() {

        driver = browserHelper.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        raCartPage = PageFactory.initElements(driver, RACartPage.class);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
    }

    @AfterAll
    void afterAll() {
        driver.close();
    }

    @Test
    void cartPageTests() {

        raCartPage.buttonAddToCart.click();
        raCartPage.buttonSeeCart.click();
        raCartPage.buttonCheckout.click();
        raCartPage.inputPromoCode.sendKeys("rahulshettyacademy");
        raCartPage.buttonApplyPromoCode.click();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(raCartPage.textSuccessfullyAppliedPromoCode)).getText(),"Code applied ..!");
    }

}
