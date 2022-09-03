package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='cart-coupon']/div[1]/button")
    public WebElement discountCodeSpan;
    @FindBy(xpath = "//*[@id='discountCode']")
    public WebElement discountCodeTextField;
    @FindBy(xpath = "//*[@id='SEC_cart-coupon']/form/div[2]/button")
    public WebElement submitDiscountCodeButton;
    @FindBy(xpath = "//*[@id='discount-code__error']/span[2]")
    public WebElement invalidDiscountCodeErrorMessage;
}
