package pages.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.PageBase;

public class HeaderSection extends PageBase {

    public HeaderSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "#_desktop_user_info span")
    private WebElement signInButtonTop;

    @FindBy(id = "category-3")
    private WebElement clothesCategoryButton;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement customerAccountButton;

    public void clickSignInButton() {

        signInButtonTop.click();
    }

    public void clickClothesCategoryButton() {
        clothesCategoryButton.click();

    }

    public void goToCustomerAccount() {
        customerAccountButton.click();
    }
}
