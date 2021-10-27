package mystore.Task2;

import common.Utils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.sections.HeaderSection;
import pages.sections.ShoppingCartSection;

import java.io.IOException;

public class PurchasingProcess {

    private WebDriver driver;
    double totalPrice;

    @Given("user with MyStore account with opened website")
    public void userWithMyStoreAccountWithOpenedWebsite() {
        driver = Utils.setUpDriver();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("user logs in with {string} and {string} to store")
    public void userLogsIn(String email, String password) {
        HeaderSection mainPage = new HeaderSection(driver);
        LogInPage logInPage = new LogInPage(driver);
        mainPage.clickSignInButton();
        logInPage.loginAs(email,password);
    }

    @And("user adds address and fills {string} as alias, {string} as address, {string} as city, {string} as postal Code, country and {string} as phone")
    public void usersAddedAddressAndFillsInputs(String alias, String address, String city, String postalCode, String phone) throws InterruptedException {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        NewAddressPage newAddressPage = new NewAddressPage(driver);

        yourAccountPage.clickAddFirstAddressButton();
        newAddressPage.fillAndConfirmNewAddressForm(alias,address,city,postalCode,phone);

    }

    @When("user choose a clothes category")
    public void userChooseAClothesCategory() {
        HeaderSection headerSection = new HeaderSection(driver);

        headerSection.clickClothesCategoryButton();
    }

    @And("user choose the Hummingbird Printed Sweater for purchase")
    public void userChooseTheHummingbirdPrintedSweater() {
        ClothesPage clothesPage = new ClothesPage(driver);

        clothesPage.chooseHummingbirdPrintedSweater();
    }

    @Then("check if the discount on it is correct")
    public void checkIfTheDiscountOnItIsCorrect() {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);

        hummingbirdPrintedSweaterPage.checkDiscount();
    }

    @When("user selects the {string}")
    public void userSelectsThe(String size) {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);

        hummingbirdPrintedSweaterPage.selectDrpSize(size);
    }

    @And("selects {string} pieces of product")
    public void selectsPiecesOfProduct(String quantity) {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);

        hummingbirdPrintedSweaterPage.selectQuantity(quantity);

    }

    @And("add the product to the cart")
    public void addTheProductToTheCart() {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);

        hummingbirdPrintedSweaterPage.addToCart();
    }

    @And("go to the option - checkout")
    public void goToTheOptionCheckout() {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        ShoppingCartSection shoppingCartSection = new ShoppingCartSection(driver);

        hummingbirdPrintedSweaterPage.proceedToCheckOut();
        shoppingCartSection.proceedToCheckoutShoppingCart();
    }

    @Then("user has {string} products in the cart")
    public void userHasProductsInTheCart(String quantity) {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);

        Assertions.assertEquals(quantity,hummingbirdPrintedSweaterPage.getAmountOfProductsInCart());
    }

    @When("confirm the address")
    public void confirmTheAddress() {
        PersonalInformationOrderPage personalInformationOrderPage = new PersonalInformationOrderPage(driver);
        personalInformationOrderPage.clickContinueAddressButton();
    }

    @And("choose shipping method - PrestaShop pick up in store")
    public void chooseShippingMethodPrestaShop() {
        PersonalInformationOrderPage personalInformationOrderPage = new PersonalInformationOrderPage(driver);

        personalInformationOrderPage.chooseAndConfirmShippingMethod();
    }

    @And("selects the payment option - Pay by Check")
    public void selectsThePaymentOptionPayByCheck() {
        PersonalInformationOrderPage personalInformationOrderPage = new PersonalInformationOrderPage(driver);

        personalInformationOrderPage.chooseAndConfirmPaymentOption();
    }

    @And("accept the conditions and click on the order with an obligation to pay")
    public void acceptTheConditionsAndClickOnTheOrderButton() {
        PersonalInformationOrderPage personalInformationOrderPage = new PersonalInformationOrderPage(driver);

        personalInformationOrderPage.acceptConditionAndOrder();

    }

    @Then("take a screenshot with the order confirmation")
    public void takeAScreenshotWithTheOrderConfirmation() throws IOException, InterruptedException {
        PersonalInformationOrderPage personalInformationOrderPage = new PersonalInformationOrderPage(driver);

        personalInformationOrderPage.takeSnapShoot(driver);
        totalPrice = personalInformationOrderPage.savePrice();

    }

    @And("user goes to Order history and details page")
    public void userGoesToOrderHistoryAndDetailsPage() {
        HeaderSection headerSection = new HeaderSection(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);

        headerSection.goToCustomerAccount();
        yourAccountPage.goToOrderHistoryAndDetail();
    }

    @And("user checks if the order is on the list with Awaiting check payment status and the same amount")
    public void userChecksIfTheOrderIsOnTheListWithAwaitingCheckPaymentStatusAndTheSameAmount() {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);

        Assert.assertEquals(totalPrice, yourAccountPage.getTotalPriceAtOrderHistory(), 0);
        Assert.assertEquals("Awaiting check payment", yourAccountPage.getOrderStatus());
    }

    @Then("delete user address")
    public void deleteUserAddress() {
        HeaderSection headerSection = new HeaderSection(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        headerSection.goToCustomerAccount();
        yourAccountPage.goToAddressesUser();
        yourAddressesPage.deleteAddress();
    }

    @After
    public void close() {
        driver.quit();
    }
}
