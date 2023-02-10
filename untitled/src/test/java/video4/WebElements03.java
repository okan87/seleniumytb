package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElements03 {
    /*
    1.  Go https://www.bestbuy.com
    2.  Accept if there is cookies
    3.  Write down how many button there are
    4.  Write the text on each button on the page
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1.  Go https://www.bestbuy.com
        driver.get("https://www.bestbuy.com");

//        2.  Accept if there is cookies
        System.out.println("No cookies");

//        3.  Write down how many button there are
        List<WebElement> buttonLists = driver.findElements(By.tagName("button"));
        System.out.println(buttonLists.size() + "buttons available");

//        4.  Write the text on each button on the page
        for (WebElement each: buttonLists) {
            System.out.println(each.getText());
        }


    }
}
