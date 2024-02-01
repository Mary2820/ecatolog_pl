package di;

import javax.inject.Inject;

public class Engine {
    Fuel fuel;

    @Inject
    public Engine(Fuel fuel) {
        this.fuel = fuel;
    }
}
