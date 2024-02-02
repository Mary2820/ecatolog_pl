package gameOfTrons;

import javax.inject.Inject;

public class Starks implements House {

    @Inject
    public Starks() {
    }

    @Override
    public void prepareForWar() {
        System.out.println(this.getClass().getSimpleName()+" prepared for war");
    }
    @Override
    public void reportForWar() {
        System.out.println(this.getClass().getSimpleName()+" reporting..");
    }
}
