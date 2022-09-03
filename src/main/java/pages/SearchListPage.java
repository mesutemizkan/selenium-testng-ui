package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchListPage {

    public SearchListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/main/div/div/div[2]/section/div/div/div[1]/div[3]/div[1]/button")
    public WebElement firstItemInTheList;
    @FindBy(xpath = "/html/body/main/div/div/div[2]/section/div/div/div[3]/div[3]/div[1]/button")
    public WebElement thirdItemInTheList;

}

