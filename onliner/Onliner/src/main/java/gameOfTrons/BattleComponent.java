package gameOfTrons;

import dagger.Component;

@Component(modules = BraavosModule.class)
interface BattleComponent {
    War getWar();
    Cash getCash ();
    Soldiers getSoldiers ();
}
