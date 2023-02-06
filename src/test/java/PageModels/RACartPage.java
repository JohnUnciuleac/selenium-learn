package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RACartPage {

    @FindBy(xpath = "//div[@class='product']//h4[@class='product-name']")
    public List<WebElement> products;

    // cart actions elements
    @FindBy(xpath = "//button[text()='ADD TO CART']")
    public WebElement buttonAddToCart;
    @FindBy(xpath = "//img[@alt='Cart']")
    public WebElement buttonSeeCart;
    @FindBy(xpath = "//div[@class='cart-preview active']//button")
    public WebElement buttonCheckout;

    // checkout page elements
    @FindBy(xpath = "//input[@class='promoCode']")
    public WebElement inputPromoCode;
    @FindBy(xpath = "//button[@class='promoBtn']")
    public WebElement buttonApplyPromoCode;
    @FindBy(xpath = "//span[@class='promoInfo']")
    public WebElement textSuccessfullyAppliedPromoCode;
}
