package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RADropdownsPage {

    // main dropdowns elements
    @FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
    public WebElement dropdownCurrency;
    @FindBy(xpath = "//div[@id='divpaxinfo']")
    public WebElement dropdownPassengers;
    @FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
    public WebElement dropdownFromCity;

    // auto suggestive dropdown elements
    @FindBy(xpath = "//input[@id='autosuggest']")
    public WebElement inputAutoSuggest;
    @FindBy(xpath = "//li[@class='ui-menu-item']/a")
    public List<WebElement> listOfCountries;

    // trip type checkboxes elements
    @FindBy(xpath = "//div[@id='travelOptions']//input[@value='OneWay']")
    public WebElement checkboxOneWay;
    @FindBy(xpath = "//div[@id='travelOptions']//input[@value='RoundTrip']")
    public WebElement checkboxRoundTrip;
    @FindBy(xpath = "//div[@id='travelOptions']")
    public List<WebElement> checkboxesTravelOptions;

    //discount checkboxes
    @FindBy(xpath = "//div[@id='discount-checkbox']//label")
    public List<WebElement> checkboxesDiscount;

    // passengers dropdown options
    @FindBy(xpath = "//span[@id='hrefIncAdt']")
    public WebElement buttonIncreaseAdultsNumber;
    @FindBy(xpath = "//input[@id='btnclosepaxoption']")
    public WebElement buttonDoneSelectingAdultsNumber;

    // city dropdown options
    @FindBy(xpath = "//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='JAI']")
    public WebElement optionFromCity;
    @FindBy(xpath = "//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DXB']")
    public WebElement optionToCity;

    // calendar dropdowns options
    @FindBy(xpath = "//input[contains(@id,'mainContent_view_date1')]")
    public WebElement dropdownFromDate;
    @FindBy(xpath = "//input[contains(@id,'mainContent_view_date2')]")
    public WebElement dropdownReturnDate;
    @FindBy(css = "a[class*='ui-state-highlight']")
    public WebElement dateDepart;

    // search button
    @FindBy(xpath = "//input[@id='ctl00_mainContent_btn_FindFlights']")
    public WebElement buttonSearch;
}
