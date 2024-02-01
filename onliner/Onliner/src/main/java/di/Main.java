package di;

public class Main {
    public static void main(String[] args) {
        CarComponent component = DaggerCarComponent.create();
        Car car = component.getCar();
        car.getCat();
    }

}
