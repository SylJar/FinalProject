package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HummingbirdPrintedSweaterPage extends PageBase {

    public HummingbirdPrintedSweaterPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//span[@class='regular-price']")
    private WebElement regularPriceText;

    @FindBy(xpath = "//*[@itemprop='price']")
    private WebElement currentPriceText;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement drpSize;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//*[@id='_desktop_cart']//span[@class='cart-products-count']")
    private static WebElement cartElement;

    public double checkDiscount() {
        String originalPrice = regularPriceText.getText();
        String discountPrice = currentPriceText.getText();

        String originalPriceRemoveCurrentSymbol = originalPrice.substring(1, originalPrice.length());
        String discountPriceRemoveCurrentSymbol = discountPrice.substring(1, discountPrice.length());

        double discount = 0.2;
        double valueOfDiscount = Double.parseDouble(originalPriceRemoveCurrentSymbol) * discount;

        double result = Double.parseDouble(discountPriceRemoveCurrentSymbol) + valueOfDiscount;

        if(result == Double.parseDouble(originalPriceRemoveCurrentSymbol)) {
            System.out.println("Discount value is correct: " + discount);
        }else {
            System.out.println("Discount value is incorrect");
        }
        return result;
    }

    public void selectDrpSize(String size) {
        Select sizeDrp = new Select(drpSize);
        sizeDrp.selectByVisibleText(size);
    }

    public void selectQuantity(String quantity) {
        for(int i=0; i<6; i++) {
            quantityInput.clear();
        }
        quantityInput.sendKeys(quantity);
    }

    public void addToCart() {

        addToCartButton.click();
    }

    public String getAmountOfProductsInCart() {

        return cartElement.getAttribute("innerHTML").replace("(", "").replace(")","");
    }

    public void proceedToCheckOut() {
        proceedToCheckOutButton.click();

    }
}
