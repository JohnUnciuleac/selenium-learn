package com.example.demo;

import PageModels.RADropdownsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserHelper;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RADropdownsTests {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private RADropdownsPage raDropdownsPage;

    @BeforeAll
    void beforeAll() {

        driver = browserHelper.getChromeDriver();

        raDropdownsPage = PageFactory.initElements(driver, RADropdownsPage.class);

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @AfterAll
    void afterAll() {
        driver.close();
    }

    @Test
    void dropdownsTest() throws InterruptedException {

        raDropdownsPage.checkboxRoundTrip.click();

        Select dropdownOptions = new Select(raDropdownsPage.dropdownCurrency);
        dropdownOptions.selectByIndex(3);

        raDropdownsPage.dropdownPassengers.click();
        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {
            raDropdownsPage.buttonIncreaseAdultsNumber.click();
        }

        raDropdownsPage.buttonDoneSelectingAdultsNumber.click();

        raDropdownsPage.inputAutoSuggest.sendKeys("ind");
        Thread.sleep(1000);

        for (WebElement country : raDropdownsPage.listOfCountries) {
            if (country.getText().equals("India")) {
                country.click();
                break;
            }
        }

        raDropdownsPage.dropdownFromCity.click();
        Thread.sleep(1000);
        raDropdownsPage.optionFromCity.click();
        Thread.sleep(1000);
        raDropdownsPage.optionToCity.click();

    }

}
