package Factory_Method;

import Factory_Method.factories.CargoRocketFactory;
import Factory_Method.factories.PassengerRocketFactory;
import Factory_Method.factories.RocketFactory;
import Factory_Method.rockets.Rocket;

public class FactoryMethodExample {
    public static void main(String[] args){
        RocketFactory cargoFactory = new CargoRocketFactory();
        Rocket cargo = cargoFactory.createRocket();
        cargo.launch();

        RocketFactory passengerFactory = new PassengerRocketFactory();
        Rocket passenger = passengerFactory.createRocket();
        passenger.launch();
    }
}
