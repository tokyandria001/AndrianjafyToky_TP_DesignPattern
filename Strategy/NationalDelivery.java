package Strategy;

public class NationalDelivery implements DeliveryStrategy {
    @Override
    public double calculateFee(double distance) {
        return 0.5 * distance;
    }
}
