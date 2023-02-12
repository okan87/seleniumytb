package video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JunitAssertion1 {
    /*
    1.  Launch browser
    2.  Navigate to url "https://automationexercise.com"
    3.  Verify that home page is visible successfull
    4.  Click on "SignUp / Login" buton
    5.  Verify "Login to your account" is visible
    6.  Enter correct email address and password
    7.  Click 'login' button
    8.  Verify that "Logged in as username" is visible
    9.  Click "Logout" button
    10. Verify that user is navigated to login page
    11. Close driver
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
//        1.  Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){
//        11. Close driver
        driver.close();
    }
    @Test
    public void test01(){
//        2.  Navigate to url "https://automationexercise.com"
        driver.get("https://automationexercise.com");

//        3.  Verify that home page is visible successfull
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());

//        4.  Click on "SignUp / Login" buton
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5.  Verify "Login to your account" is visible
        WebElement lgnYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(lgnYaziElementi.isDisplayed());

//        6.  Enter correct email address and password
        WebElement emailaddressBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailaddressBox.sendKeys("ahmet@nehaber.com");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordBox.sendKeys("12345");
//        7.  Click 'login' button
        WebElement lgnButtonElement = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        lgnButtonElement.click();

//        8.  Verify that "Logged in as username" is visible
        WebElement loggedInYazisi = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInYazisi.isDisplayed());

//        9.  Click "Logout" button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        logoutButton.click();

//        10. Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
