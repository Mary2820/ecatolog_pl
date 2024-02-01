package example;

import javax.inject.Inject;

public class Thermosiphon implements Pump {
    private final CoffeeLogger logger;
    private final Heater heater;

    @Inject
    Thermosiphon(CoffeeLogger logger, Heater heater) {
        this.logger = logger;
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            logger.log("=> => pumping => =>");
        }
    }
}
