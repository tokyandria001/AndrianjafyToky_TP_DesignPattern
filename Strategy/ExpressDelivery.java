package Strategy;

public class ExpressDelivery implements DeliveryStrategy {
    @Override
    public double calculateFee(double distance) {
        return 10 + (1.0 * distance);
    }
}
