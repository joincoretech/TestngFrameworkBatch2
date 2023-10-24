package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigReader.readProperties(Constants.CONFIG_FILE_PATH);

        switch (ConfigReader.getPropertiesValue("browser")){

            case "chrome":
              //  System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;

            case "firefox":
              //  System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertiesValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @AfterMethod(alwaysRun = true)
    public static void closeBrowser(){
        driver.quit();
    }

}
