package pages;

import services.DriverService;

import javax.inject.Inject;

public class BasePage {
    protected DriverService driverService;
    public BasePage(DriverService driverService) {
        this.driverService = driverService;
        driverService.initPageElements(this);
    }
}