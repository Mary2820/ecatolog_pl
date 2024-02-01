package di;

import javax.inject.Inject;

public class Fuel {

    private String fuelType;
    @Inject
    public Fuel() {
    }

    void getFuelType() {
        if (true) {
            fuelType = "benzine";
        } else {
            fuelType = "diesel";
        }
    }
}
