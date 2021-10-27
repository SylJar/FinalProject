package mystore.Task2;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/mystore-purchase-process.feature",
        plugin = {"pretty", "html:target/cucumber-reports2.html"}
)
public class PurchasingProcessTest {
}
