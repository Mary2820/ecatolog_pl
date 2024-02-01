package di;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;

public class Car {
    private Engine engine;

    @Inject
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void getCat() {
        System.out.println("Donne!");
    }
}




