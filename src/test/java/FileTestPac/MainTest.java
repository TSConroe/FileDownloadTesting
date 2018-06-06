package FileTestPac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class MainTest {

    public WebDriver driver;
    String url = "https://www.seleniumhq.org/download/";
    File file = new File("C:\\Users\\conroe1\\Downloads\\selenium-java-3.12.0.zip");

    @BeforeTest
    public void Before(){
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();
        if (file.exists())
         file.delete();

    }

    @Test
    public void TitleTest() {
        driver.navigate().to(url);


        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/table[1]/tbody/tr[1]/td[4]/a")).click();
        while (!file.exists()) {
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(file.exists());
    }

    @AfterTest
    public void After(){
        file.delete();
        driver.close();
    }
}
