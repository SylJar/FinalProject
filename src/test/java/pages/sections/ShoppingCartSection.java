package pages.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ShoppingCartSection extends PageBase {

    public ShoppingCartSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutCartButton;


    public void proceedToCheckoutShoppingCart() {
        proceedToCheckoutCartButton.click();
    }
}
