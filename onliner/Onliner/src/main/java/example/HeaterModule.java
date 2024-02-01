package example;

import dagger.Binds;
import dagger.Module;

import javax.inject.Singleton;

@Module
interface HeaterModule {
    @Binds
    @Singleton
    Heater bindHeater(ElectricHeater impl);
}