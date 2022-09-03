package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;
    @FindBy(id = "clear-input")
    public WebElement clearSearchBarButton;
    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBar;
    @FindBy(xpath = "/html/body/header/div/div/div/ul/li[5]/a")
    public WebElement goToCartButton;

}
