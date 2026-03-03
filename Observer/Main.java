package Observer;

public class Main {
    public static void main(String[] args) {
        LightSensor lightSensor = new LightSensor();
        Lamp lamp1 = new Lamp("Lampe salon");
        Lamp lamp2 = new Lamp("Lampe chambre");

        lightSensor.attach(lamp1);
        lightSensor.attach(lamp2);

        lightSensor.setLightLevel(30); // Les lampes devraient s'allumer
        lightSensor.setLightLevel(70); // Les lampes devraient s'éteindre

        lightSensor.detach(lamp2);
        lightSensor.setLightLevel(20); // Seule la lampe du salon devrait s'allumer
    }
}
