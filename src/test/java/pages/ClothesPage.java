package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothesPage extends PageBase {

    public ClothesPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//article[@data-id-product='2']")
    private WebElement hummingbirdPrintedSweater;

    public void chooseHummingbirdPrintedSweater() {

        hummingbirdPrintedSweater.click();
    }
}
