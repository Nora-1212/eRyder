public class VIPUser extends RegularUser{
    public VIPUser() {
    }

    public VIPUser(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardExpiryData, String cardProvider, int cvv, String userType) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardExpiryData, cardProvider, cvv, userType);
    }

    @Override
    public double calculateFare(double baseFare) {
        return baseFare * 0.8;
    }
    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }
}
