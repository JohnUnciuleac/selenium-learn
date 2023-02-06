package com.example.demo;

import PageModels.RADropdownsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserHelper;

import java.time.Duration;


public class RADropdownsTests {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private WebDriverWait wait;
    private RADropdownsPage raDropdownsPage;

    @BeforeMethod
    void beforeMethod() {

        driver = browserHelper.getChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        raDropdownsPage = PageFactory.initElements(driver, RADropdownsPage.class);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    void dropdownsTest() throws InterruptedException {

        raDropdownsPage.checkboxRoundTrip.click();
        Assert.assertTrue(raDropdownsPage.checkboxRoundTrip.isSelected());
        Assert.assertTrue(raDropdownsPage.dropdownReturnDate.isEnabled());

        Select dropdownOptions = new Select(raDropdownsPage.dropdownCurrency);
        dropdownOptions.selectByIndex(3);

        raDropdownsPage.dropdownPassengers.click();

        for (int i = 0; i < 5; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(raDropdownsPage.buttonIncreaseAdultsNumber)).click();
        }

        Assert.assertEquals(raDropdownsPage.dropdownPassengers.getText(), "6 Adult");

        raDropdownsPage.buttonDoneSelectingAdultsNumber.click();

        raDropdownsPage.inputAutoSuggest.sendKeys("ind");

        for (WebElement country : raDropdownsPage.listOfCountries) {
            if (country.getText().equals("India")) {
                country.click();
                break;
            }
        }

        for (WebElement discount : raDropdownsPage.checkboxesDiscount) {
            if (discount.getText().equals("Student")) {
                discount.click();
                break;
            }
        }

        raDropdownsPage.dropdownFromCity.click();

        wait.until(ExpectedConditions.elementToBeClickable(raDropdownsPage.optionFromCity)).click();
        wait.until(ExpectedConditions.elementToBeClickable(raDropdownsPage.optionToCity)).click();
        wait.until(ExpectedConditions.elementToBeClickable( raDropdownsPage.dateDepart)).click();
        wait.until(ExpectedConditions.elementToBeClickable( raDropdownsPage.buttonSearch)).click();
    }

}
