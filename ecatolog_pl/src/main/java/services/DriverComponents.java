package services;

import dagger.Component;
import pages.homepage.HomePage;

@Component
public interface DriverComponents {
    HomePage getHomePage();
}