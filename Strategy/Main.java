package Strategy;

public class Main {
    public static void main(String[] args) {
        double distance1 = 5.0; // km
        double distance2 = 50.0; // km

        Order order = new Order(new NationalDelivery());
        System.out.println("Livraison nationale (5 km): " + order.calculateDeliveryFee(distance1));
        System.out.println("Livraison nationale (50 km): " + order.calculateDeliveryFee(distance2));
        
        //double distance = 20.0; // Distance in kilometers
        
        //Order order = new Order(new LocalDelivery());
        //System.out.println("Livraison locale: " + order.calculateDeliveryFee(distance));
        
        //order.setDeliveryStrategy(new NationalDelivery());
        //System.out.println("Livraison nationale: " + order.calculateDeliveryFee(distance));
        
        //order.setDeliveryStrategy(new ExpressDelivery());
        //System.out.println("Livraison express: " + order.calculateDeliveryFee(distance));
    }
}
