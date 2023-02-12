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
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class JunitAssertion2 {
    /*
    1.  Launch browser
    2.  Navigate to url "https://automationexercise.com"
    3.  Verify that home page is visible successfull
    4.  Click on "Products" buton
    5.  Verify that user is navigated to ALL PRODUCTS page successfully
    6.  Enter product name in search input and click search button
    7.  Verify 'Searched PRODUCTS' is visible
    8.  Close driver
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
//        8. Close driver
        driver.close();
    }
    @Test
    public void test01(){
//        2.  Navigate to url "https://automationexercise.com"
        driver.navigate().to("https://automationexercise.com");

//        3.  Verify that home page is visible successfull
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());

//        4.  Click on "Products" buton
        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        productButton.click();

//        5.  Verify that user is navigated to ALL PRODUCTS page successfully
        WebElement allProductVisible = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProductVisible.isDisplayed());

//        6.  Enter product name in search input and click search button
        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@name='search']"));
        searchBoxElement.sendKeys("Blue Top");
        WebElement searcbnoxElementSend = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        searcbnoxElementSend.click();

//        7.  Verify 'Searched PRODUCTS' is visible
        WebElement searchedProductText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchedProductText.isDisplayed());

    }
}
