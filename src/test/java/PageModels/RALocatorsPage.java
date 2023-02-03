package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RALocatorsPage {

    //Login page elements
    @FindBy(xpath = "//input[@id='inputUsername']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='inputPassword']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@class='submit signInBtn']")
    public WebElement buttonSign;

    @FindBy(xpath = "//p[@class='error']")
    public WebElement errorText;

    @FindBy(xpath = "//input[@id='chkboxOne']")
    public WebElement checkboxRememberMe;

    @FindBy(xpath = "//*[@id='chkboxTwo']")
    public WebElement checkboxAgreeTAndC;

    @FindBy(xpath = "//div[@class='forgot-pwd-container']/a")
    public WebElement linkForgotYourPassword;


    //Reset credentials page elements
    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement inputNameResetCredentials;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement inputEmailResetCredentials;

    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    public WebElement inputPhoneNumberResetCredentials;

    @FindBy(xpath = "//button[@class='reset-pwd-btn']")
    public WebElement buttonResetLogin;

    @FindBy(xpath = "//button[@class='go-to-login-btn']")
    public WebElement buttonGoToLoginPage;

    @FindBy(xpath = "//p[@class='infoMsg']")
    public WebElement textInfoResetCredentials;

    // Successful login page elements

    @FindBy(xpath = "//div[@class='login-container']/p")
    public WebElement textSuccessfulLogin;

    @FindBy(xpath = "//button[@class='logout-btn']")
    public WebElement buttonLogout;

    @FindBy(xpath = "//div[@class='login-container']/h2")
    public WebElement textUsernameSuccessfulLogin;
}
