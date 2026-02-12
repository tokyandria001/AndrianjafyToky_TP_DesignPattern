package Factory_Method.rockets;

public class PassengerRocket implements Rocket {
    @Override
    public void launch(){
        System.out.println("Lancement de la fusée Passagers pour transporter des astronautes !");
    }
}
