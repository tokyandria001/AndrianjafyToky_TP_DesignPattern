package Observer;

import java.util.ArrayList;
import java.util.List;

public class LightSensor implements LightSensorSubject {
    private List<LightObserver> observers = new ArrayList<>();
    private int lightLevel;

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel; // change l'état
        System.out.println("\nCapteur : niveau de lumière = " + lightLevel);
        notifyObservers();            // prévient les observateurs
    }

    @Override
    public void attach(LightObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(LightObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (LightObserver o : observers) {
            o.updateLight(lightLevel);
        }
    }
}
