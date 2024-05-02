import org.testng.annotations.AfterTest;
import startUp.DriverInitializer;

public class BaseTest {
    DriverInitializer driverInitializer;

    public BaseTest(DriverInitializer driverInitializer) {
        this.driverInitializer = driverInitializer;
    }

    @AfterTest
    public void teardown() {
        driverInitializer.getDriver().quit();
    }
}