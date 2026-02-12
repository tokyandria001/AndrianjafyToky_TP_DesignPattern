package Factory_Method.factories;

import Factory_Method.rockets.PassengerRocket;
import Factory_Method.rockets.Rocket;

public class PassengerRocketFactory extends RocketFactory{
    @Override
    public Rocket createRocket(){
        return new PassengerRocket();
    }
}
