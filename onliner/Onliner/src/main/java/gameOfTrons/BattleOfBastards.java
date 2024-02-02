package gameOfTrons;

public class BattleOfBastards {

    public static void main(String[] args){
        Cash cash = new Cash();
        Soldiers soldiers = new Soldiers();
        BattleComponent component = DaggerBattleComponent
                .builder()
                .braavosModule(new BraavosModule(cash, soldiers))
                .build();

        War war = component.getWar();
        war.prepare();
        war.report();

        component.getCash();
        component.getSoldiers();

    }
}
