package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManagerMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //A. driver.manage().window()  methods

        //1. driver.manage().window().getSize() ==> pixel
//        System.out.println(driver.manage().window().getSize());
        /*
        You can set up height and width after getsize() methods
         */

        //2. driver.manage().window().getPosition() ==> it start left and down
//        System.out.println(driver.manage().window().getPosition());

        //3.driver.manage().window().setPosition(new Point(x,y))
//        driver.manage().window().setPosition(new Point(12,12));

        //4. driver.manage().window().setSize(new Dimension(w,h))
//        driver.manage().window().setSize(new Dimension(900,600));

//        System.out.println("new window size : " + driver.manage().window().getSize());
//        System.out.println("new window locate : " + driver.manage().window().getPosition());

        //5. driver.manage().window().maximize(); ==> always do

        //6. driver.manage().window().fullscreen();
        //7. driver.manage().window().minimize();


        //B. driver.manage().timeouts() Methods
        //1. driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Wait politly
        // you must do everytime
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
