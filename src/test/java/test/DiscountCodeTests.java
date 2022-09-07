package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchListPage;
import pages.ShoppingCartPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class DiscountCodeTests extends TestBase {

    HomePage homePage;
    SearchListPage searchListPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void testSetup() {
        homePage = new HomePage();
        searchListPage = new SearchListPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test
    public void givenUserSubmitsInvalidDiscountCodeThenVerifyErrorMessageIsDisplayed() throws InterruptedException {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        // Accept cookies
        homePage.acceptCookies.click();

        // Search for first item (sofa)
        homePage.searchBar.sendKeys(ConfigReader.getProperty("firstItemSofa"));
        homePage.searchBar.sendKeys(Keys.ENTER);
        // Add first item to cart (sofa)
        action.sendKeys(Keys.ARROW_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(searchListPage.firstItemInTheList));
        searchListPage.firstItemInTheList.click();

        // Clean the search bar
        action.sendKeys(Keys.PAGE_UP).perform();

        // Search for second item (table)
        homePage.clearSearchBarButton.click();
        homePage.searchBar.sendKeys(ConfigReader.getProperty("secondItemTable"));
        homePage.searchBar.sendKeys(Keys.ENTER);
        // Add second item to cart (table)
        action.sendKeys(Keys.ARROW_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(searchListPage.thirdItemInTheList));
        searchListPage.thirdItemInTheList.click();

        // Go to cart
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(10000);
        homePage.goToCartButton.click();
        // Verify 2 items added to cart
        List<WebElement> itemsInTheCart = driver.findElements(By.className("product_product__2t5j0"));
        Assert.assertEquals(itemsInTheCart.size(),2);

        // Apply discount code
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shoppingCartPage.discountCodeSpan);
        shoppingCartPage.discountCodeSpan.click();
        shoppingCartPage.discountCodeTextField.sendKeys(ConfigReader.getProperty("invalidDiscountCode"));
        shoppingCartPage.submitDiscountCodeButton.click();
        // Verify invalid discount code error message is displayed
        Assert.assertTrue(shoppingCartPage.invalidDiscountCodeErrorMessage.isDisplayed());
    }

}
