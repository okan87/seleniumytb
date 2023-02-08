package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*get and Navigate are almost the same.
        Because both of them goes the webpages.
        But Navigate method load pages. You can navigate(Forward and backward).
        but it is not necessary for get methods.
        */
        //1. driver.navigate().to()
//        driver.get("https://amazon.com");
//        driver.navigate().to("https://facebook.com");

        //2. driver.navigate().back()
//        driver.navigate().back();

        //3. driver.navigate().forward()
//        driver.navigate().forward();

        //4. driver.navigate().refresh();
//        driver.navigate().refresh();

        //driver.close()==> when created a driver close only open window
//        driver.close();

        //driver.quit() ==> it close all windows
//        driver.quit();
        /*
        .close() and .quit() don't work together
         */
    }
}
