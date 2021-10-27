package mystore.Task1;

import common.Utils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LogInPage;
import pages.sections.HeaderSection;
import pages.NewAddressPage;
import pages.YourAccountPage;
import pages.YourAddressesPage;
import org.junit.jupiter.api.Assertions;


public class AddAndDeleteNewAddress {

    private WebDriver driver;

    @Given("user with mystore account with opened website")
    public void userWithMystoreAccountWithOpenedWebsite() {
        driver = Utils.setUpDriver();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("user logs in with {string} and {string}")
    public void userLogsIn(String email, String password) {
        HeaderSection mainPage = new HeaderSection(driver);
        LogInPage logInPage = new LogInPage(driver);

        mainPage.clickSignInButton();
        logInPage.loginAs(email,password);
    }

    @And("user goes to Addresses page")
    public void userGoesToAddressesPage() {
        YourAccountPage yourAccountFooter = new YourAccountPage(driver);

        yourAccountFooter.clickAddressFooterButton();
    }

    @And("user clicks on + Create new address button")
    public void userClicksOnCreateNewAddressButton() {
        YourAddressesPage yourAddressesSection = new YourAddressesPage(driver);

        yourAddressesSection.clickCreateNewAddressButton();
    }

    @When("user fills {string} as alias, {string} as address, {string} as city, {string} as postal Code, country and {string} as phone")
    public void userFillsAsAliasAsAddressAsCityAsPostalCodeCountryAndAsPhone(String alias, String address, String city, String postalCode, String phone) throws InterruptedException {
        NewAddressPage newAddressPage = new NewAddressPage(driver);

        newAddressPage.fillAndConfirmNewAddressForm(alias,address,city,postalCode,phone);

    }

    @Then("data in the added address is correct on Your Addresses page")
    public void dataInTheAddedAddressIsCorrect() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        Assertions.assertEquals("Address successfully added!", yourAddressesPage.getAddressAddedDeletedSuccessMessage());
        Assertions.assertEquals("autotest\n" +
                "Automation Tester\n" +
                "Oxford 10\n" +
                "London\n" +
                "66-666\n" +
                "United Kingdom\n" +
                "567-890-123" ,yourAddressesPage.getFullAddressData());
    }

    @When("user delete the above address by clicking on delete button")
    public void userDeleteExistingAddress() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.deleteAddress();

    }

    @Then("address has been removed")
    public void addressHasBeenRemoved() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        Assertions.assertEquals("Address successfully deleted!",yourAddressesPage.getAddressAddedDeletedSuccessMessage());
    }

    @After
    public void close() {
        driver.quit();
    }
}

