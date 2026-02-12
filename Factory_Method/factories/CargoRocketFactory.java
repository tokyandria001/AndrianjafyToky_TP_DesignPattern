package Factory_Method.factories;

import Factory_Method.rockets.CargoRocket;
import Factory_Method.rockets.Rocket;

public class CargoRocketFactory extends RocketFactory{
    @Override
    public Rocket createRocket() {
        return new CargoRocket();
    }
}
