package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();

        // Go to home page
        driver.get(ConfigReader.getProperty("homePage"));

        // Verify the page URL
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("homePage"));
    }

    // Close the web browser
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}