package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1. driver.get("url")
//        driver.get("https://amazon.com");

        //2. driver.getTitle()
//        System.out.println("Page Title " + driver.getTitle());

        //3. driver.getCurrentUrl()
//        System.out.println(driver.getCurrentUrl());

        //4. driver.getPageSource()
//        System.out.println(driver.getPageSource());

        //5. driver.getWindowHandle() ==> Unique hash code
//        System.out.println(driver.getWindowHandle());

        //6. driver.getWindowHandles() ==> when working driver Unique hash code of all webpages
//        System.out.println(driver.getWindowHandles());



    }
}
