package Factory_Method.rockets;

public class CargoRocket implements Rocket{
    @Override
    public void launch(){
        System.out.println("Lancement d'une fusée Cargo pour transporter du matériel !");
    }
}
