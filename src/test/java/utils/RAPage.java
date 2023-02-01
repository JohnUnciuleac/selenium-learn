package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RAPage {
    @FindBy(css = "input[id='inputUsername']")
    public WebElement inputUsername;

    @FindBy(css = "input[name='inputPassword']")
    public WebElement inputPassword;

    @FindBy(css = "button[class^='submit']")
    public WebElement buttonSign;

    @FindBy (css = "p[class='error']")
    public WebElement errorText;

    @FindBy (css = "input[id='chkboxOne']")
    public WebElement checkboxRememberMe;

    @FindBy(xpath = "//*[@id='chkboxTwo']")
    public WebElement checkboxAgreeTandC;
}
