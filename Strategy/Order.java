package Strategy;

public class Order {
    private DeliveryStrategy deliveryStrategy;
    
    public Order(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }
    
    public double calculateDeliveryFee(double distance) {
        return this.deliveryStrategy.calculateFee(distance);
    }
}
