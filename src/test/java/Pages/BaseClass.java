package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    protected PageFactory pageFactory;
    WebDriver driver;

    public void setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Data.properties");
        Properties data = new Properties();
        data.load(reader);
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to(data.getProperty("url"));
        pageFactory = new PageFactory(driver);
    }
}
