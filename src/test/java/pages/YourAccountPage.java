package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountPage extends PageBase {

    public YourAccountPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@id='footer_account_list']/li[4]/a")
    private WebElement addressesFooterButton;

    @FindBy(id = "address-link")
    private WebElement addFirstAddressButton;

    @FindBy(xpath = "//*[@id='history-link']")
    private WebElement orderHistoryAndDetailsButton;

    @FindBy(xpath = "//*[@id='content']/table/tbody/tr[1]/td[2]")
    private WebElement lastTotalPriceElement;

    @FindBy(xpath = "//*[@id='content']/table/tbody/tr[1]/td[4]/span")
    private WebElement invoiceElement;

    @FindBy(id = "addresses-link")
    private WebElement addressesButton;


    public void clickAddressFooterButton() {

        addressesFooterButton.click();
    }

    public void clickAddFirstAddressButton() {
        addFirstAddressButton.click();

    }

    public void goToOrderHistoryAndDetail(){

        orderHistoryAndDetailsButton.click();
    }

    public double getTotalPriceAtOrderHistory(){
        return Double.parseDouble(lastTotalPriceElement.getText().substring(1));
    }

    public String getOrderStatus(){

        return invoiceElement.getText();
    }

    public void goToAddressesUser() {
        addressesButton.click();
    }
}


