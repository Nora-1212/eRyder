public class RegularUser extends RegisteredUsers {


    public RegularUser() {
    }

    public RegularUser(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardExpiryData, String cardProvider, int cvv, String userType) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardExpiryData, cardProvider, cvv, userType);
    }

    @Override
    public double calculateFare(double baseFare){
        return super.calculateFare(baseFare);
    }
    @Override
    public void displayUserType(){
        System.out.println("Regular User");
    }
}
