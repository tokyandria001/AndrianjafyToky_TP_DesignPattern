package Observer;

public class Lamp implements LightObserver {
    private String name;

    public Lamp(String name) {
        this.name = name;
    }

    @Override
    public void updateLight(int lightLevel) {
        if (lightLevel < 50) {
            System.out.println(name + " s'allume. Le niveau actuel: " + lightLevel);
        } else {
            System.out.println(name + " s'éteint. Le niveau actuel: " + lightLevel);
        }
    }
    
}
