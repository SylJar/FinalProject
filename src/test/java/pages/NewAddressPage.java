package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage extends PageBase {

    public NewAddressPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "form-control")
    private WebElement aliasInput;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[@class='btn btn-primary float-xs-right'][@type='submit']")
    private WebElement saveButton;

    public void selectCountry() {
        Select countryDrp = new Select(driver.findElement(By.name("id_country")));
        countryDrp.selectByVisibleText("United Kingdom");
    }

    public void fillAndConfirmNewAddressForm(String alias, String address, String city, String postalCode, String phone) throws InterruptedException {

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        postalCodeInput.sendKeys(postalCode);
        cityInput.sendKeys(city);
        selectCountry();
        try {
            Thread.sleep(1000);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        phoneInput.sendKeys(phone);

        saveButton.click();
    }
}

