package mystore.Task1;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/mystore-add-delete-address.feature",
        plugin = {"pretty", "html:target/cucumber-reports1.html"}
)
public class AddAndDeleteNewAddressTest {

}
