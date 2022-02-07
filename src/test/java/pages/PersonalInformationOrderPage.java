package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PersonalInformationOrderPage extends PageBase{

    public PersonalInformationOrderPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    private WebElement continueAddressButton;

    @FindBy(xpath = "//*[@id='delivery_option_1']")
    private WebElement prestaShopDeliveryInput;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement continueDeliveryButton;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckInput;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement iAgreeInput;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement orderButton;

    @FindBy(xpath = "//*[@id='content-hook_payment_return']//span[@class='price']")
    private static WebElement totalPriceElement;

    public void clickContinueAddressButton() {

        continueAddressButton.click();
    }

    public void chooseAndConfirmShippingMethod() {
        if(!prestaShopDeliveryInput.isSelected()) {
            prestaShopDeliveryInput.click();
        }
        continueDeliveryButton.click();
    }

    public void chooseAndConfirmPaymentOption() {

        payByCheckInput.click();
    }

    public void acceptConditionAndOrder() {
        if(!iAgreeInput.isSelected()){
            iAgreeInput.click();
        }

        orderButton.click();
    }

    public void takeSnapShoot(WebDriver driver) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG", new File(("target//ScreenshotOrderConfirmation.png")));
    }

    public double savePrice() {

        return Double.parseDouble(totalPriceElement.getText().substring(1));
    }
}

