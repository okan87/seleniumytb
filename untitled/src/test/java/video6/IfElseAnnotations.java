package video6;

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

public class IfElseAnnotations {
    /*
    1.  https://amazon.com adresine git
    2.  Arama Kutusuna Nutella yaz
    3.  Enter a bas ve aramayi baslat
    4.  Arama sonucunun Nutella kelimesini icerip icermedigini kontrol et
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
//        1.  https://amazon.com adresine git
        driver.get("https://amazon.com");

//        2.  Arama Kutusuna Nutella yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella");

//        3.  Enter a bas ve aramayi baslat
        aramaKutusu.submit();

//        4.  Arama sonucunun Nutella kelimesini icerip icermedigini kontrol et
        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String expextedText = "Nutella";
        String actualResult = resultText.getText();
        Assert.assertTrue(actualResult.contains(expextedText));

    }

}
