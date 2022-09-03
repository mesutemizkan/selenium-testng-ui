package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){
    }
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}