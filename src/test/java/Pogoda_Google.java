import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Pogoda_Google {
    WebDriver driver;

    @BeforeClass
    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver11.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void closeBrowser() {
     //   driver.manage().deleteAllCookies();
     //   driver.quit();
    }


    @org.testng.annotations.Test
    public void sendMessageTest() {
        driver.get("https://www.google.by/");
        //проверка открытия страницы
        WebElement pageHeader =
                driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Не найден заголовок страницы");
        //находим и заполняем поле Фамилия

        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        field.sendKeys("Погода в гомеле" + Keys.ENTER);
    }
    @Test
    public void sendMessageTest2() {

        driver.get("https://yandex.by/");

        WebElement pageHeader2 =
                driver.findElement(By.xpath("//*[@id=\"text\"]"));
        Assert.assertTrue(pageHeader2.isDisplayed(), "Не найден заголовок страницы");
        //находим и заполняем поле Фамилия

        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"text\"]"));
        field2.sendKeys("Погода в гомеле" + Keys.ENTER);
    }
}
