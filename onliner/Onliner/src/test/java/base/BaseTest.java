package base;

import org.junit.After;
import org.junit.Before;
import startUp.DriverInitializer;

public class BaseTest {
    @After
    public void teardown() {
        DriverInitializer.setDriverNull();
    }

    @Before
    public void startDriver () {
        DriverInitializer.getDriver();
    }
}
