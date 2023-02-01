package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSign;

    @FindBy(css = "button[class^='submit']")
    public WebElement buttonSign2;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/iunciuleac/Downloads/chromedriver_mac64/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();

        driver.findElement(By.id("inputUsername")).sendKeys("Selenium Test");
        driver.findElement(By.name("inputPassword")).sendKeys("password");
        driver.findElement(By.className("signInBtn")).click();


        // Thread.sleep(3000);

        // WebElement errorText = driver.findElement(By.cssSelector("p[class='error']"));

        WebElement errorText = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[class='error']")));
        System.out.println(errorText.getText());


        driver.quit();
    }
}
