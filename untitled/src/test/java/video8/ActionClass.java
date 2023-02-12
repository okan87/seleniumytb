package video8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass {
    static WebDriver driver;
    /*
        1.  Launch browser
        2.  Navigate to url "https://automationexercise.com"
        3.  Click on "Signup/Login" button
        4.  Enter name and email adress
        5.  Click "Signup" button
        6.  Fill details: Title, name, email, password, date of birth
        7.  Select checkbox 'Sign up for our newsletter!'
        8.  Select checkbox "Receive special offers from our partners!"
        9.  Fill details: first name, last name, company, Adress, Adress2, Country, State, City, Zipcode, Mobile number
        10. Click 'Create Account button'
        11. Verify that 'ACCOUNT CREATED!' is visible
         */
    @Test
    public void test01(){
//        1.  Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        2.  Navigate to url "https://automationexercise.com"
        driver.get("https://automationexercise.com");

//        3.  Click on "Signup/Login" button
        WebElement signupElementi = driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions = new Actions(driver);
        actions.click(signupElementi).perform();

//        4.  Enter name and email adress
//        5.  Click "Signup" button
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameBox)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("c@bcde.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

//        6.  Fill details: Title, name, email, password, date of birth
//        7.  Select checkbox 'Sign up for our newsletter!'
//        8.  Select checkbox "Receive special offers from our partners!"
//        9.  Fill details: first name, last name, company, Adress, Adress2, Country, State, City, Zipcode, Mobile number
//        10. Click 'Create Account button'
        WebElement titleCheckBox = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(titleCheckBox)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("12345").sendKeys(Keys.TAB)
                .sendKeys("12").sendKeys(Keys.TAB).sendKeys("May").sendKeys(Keys.TAB).sendKeys("2020").sendKeys(Keys.TAB)
                .click().sendKeys(Keys.TAB).click().sendKeys(Keys.TAB)
                .sendKeys("Ahmet").sendKeys(Keys.TAB)
                .sendKeys("Bul").sendKeys(Keys.TAB)
                .sendKeys("kendisi").sendKeys(Keys.TAB)
                .sendKeys("ul cadde no90").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("United States").sendKeys(Keys.TAB)
                .sendKeys("Teksas").sendKeys(Keys.TAB)
                .sendKeys("Dallas").sendKeys(Keys.TAB)
                .sendKeys("04000").sendKeys(Keys.TAB)
                .sendKeys("55556544565").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

//        11. Verify that 'ACCOUNT CREATED!' is visible
        String expectedText = "ACCOUNT CREATED!";
        String actualText = driver.findElement(By.xpath("h2[data-qa='account-created']")).getText();
        Assert.assertEquals(actualText,expectedText);

        driver.close();



    }
}
