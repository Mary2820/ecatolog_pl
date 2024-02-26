package base;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import startUp.DriverInitializer;

public class BaseTest {
    @AfterTest
    public void teardown() {
        DriverInitializer.setDriverNull();
    }

    @BeforeTest
    public void startDriver () {
        DriverInitializer.getDriver();
    }
}
