package Observer;

public interface LightSensorSubject {
    void attach(LightObserver observer);
    void detach(LightObserver observer);
    void notifyObservers();
}
