package example;

import dagger.Lazy;

import javax.inject.Inject;

public class CoffeeMaker {
    private final CoffeeLogger logger;
    private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.
    private final Pump pump;

    @Inject
    CoffeeMaker(CoffeeLogger logger, Lazy<Heater> heater, Pump pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.get().on();
        pump.pump();
        logger.log(" [_]P coffee! [_]P ");
        heater.get().off();
    }
}
