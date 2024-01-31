import org.testng.annotations.AfterTest;
import startUp.DriverInitializer;

public class BaseTest {
    @AfterTest
    public void teardown() {
        DriverInitializer.getDriver().quit();
    }
}