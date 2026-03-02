package Strategy;

public class LocalDelivery implements DeliveryStrategy {
    @Override
    public double calculateFee(double distance) {
        return 5.0;
    }

}
