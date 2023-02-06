package com.example.demo;

import PageModels.RACartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserHelper;

import java.time.Duration;

public class RACartTests {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private WebDriverWait wait;
    private RACartPage raCartPage;

    @BeforeMethod
    void beforeMethod() {

        driver = browserHelper.getChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        raCartPage = PageFactory.initElements(driver, RACartPage.class);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
    }

    @AfterMethod
    void afterMethod() {
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
