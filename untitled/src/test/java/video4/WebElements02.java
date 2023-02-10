package video4;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02 {
    /*
    1.  https://facebook.com adresine git
    2.  cookies cikarsa kabul et butonuna bas
    3.  e-posta kutusuna rastgele bir mail gir
    4.  sifre kismina rastgele bir sifre gir
    5.  giris yap butonuna bas
    6.  uyari olarak "The mail or mobile number you entered isn't connected to an account. Find your account and log in." mesajinin cikyigini test et
    7.  sayfayi kapat
    */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1.  https://facebook.com adresine git
        driver.get("https://facebook.com");

//        2.  cookies cikarsa kabul et butonuna bas
        driver.findElement(By.xpath("//button[@title='Only allow essential cookies']")).click();

//        3.  e-posta kutusuna rastgele bir mail gir
        WebElement memberBox = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        memberBox.sendKeys("asdfjjhagsd");

//        4.  sifre kismina rastgele bir sifre gir
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("12345");

//        5.  giris yap butonuna bas
        driver.findElement(By.xpath("//button[@name='login']")).click();

//        6.  uyari olarak "The mail or mobile number you entered isn't connected to an account. Find your account and log in." mesajinin cikyigini test et
        WebElement warnText = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedText = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        String actualText = warnText.getText();
        System.out.println(actualText);
        if(expectedText.equals(actualText))
            System.out.println("Test Passed");
        else
            System.out.println("Test Filed");

//        7.  sayfayi kapat
        driver.close();





    }
}
