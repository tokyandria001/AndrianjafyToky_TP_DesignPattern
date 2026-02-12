package Factory_Method.rockets;

public class CargoRocket implements Rocket{
    @Override
    public void launch(){
        System.out.println("Lancement de la fusée Cargo pour transporter du matériel !");
    }
}
