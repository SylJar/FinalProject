package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAddressesPage extends PageBase {

    public YourAddressesPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement createNewAddressButton;

    @FindBy(xpath = "//article[@class='alert alert-success']")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@class='address-body']")
    private  WebElement fullAddressData;

    @FindBy(xpath = "//a[@data-link-action='delete-address']")
    private WebElement deleteButton;


    public void clickCreateNewAddressButton() {

        createNewAddressButton.click();
    }

    public String getAddressAddedDeletedSuccessMessage() {

        return successMessage.getText();
    }

    public String getFullAddressData() {
        return fullAddressData.getText();
    }

    public void deleteAddress() {

        deleteButton.click();
    }

    public void deleteAddressLogInUser() {

    }
}
