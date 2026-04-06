import java.util.Arrays;

public class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardExpiryData;
    private String cardProvider;
    private int cvv;
    private String userType;

    private String[] lastThreeTrips;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryData() {
        return cardExpiryData;
    }

    public void setCardExpiryData(String cardExpiryData) {
        this.cardExpiryData = cardExpiryData;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }

    public RegisteredUsers() {
        this.lastThreeTrips = new String[3];
    }

    public void addTrip(String trip){
        for (int i = 0; i < lastThreeTrips.length; i++) {
            lastThreeTrips[i] = lastThreeTrips[i+1];
        }
        lastThreeTrips[lastThreeTrips.length-1] = trip;
    }

    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardExpiryData, String cardProvider, int cvv, String userType) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryData = cardExpiryData;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
    }

    public double calculateFare(double basrFare){
        return basrFare;
    }

    public void displayUserType(){
        System.out.println("Registered User");
    }

    @Override
    public String toString() {
        return "RegisteredUsers:" +
                "\nfullName=" + fullName +
                "\nemailAddress=" + emailAddress +
                "\ndateOfBirth=" + dateOfBirth +
                "\ncardNumber=" + cardNumber +
                "\ncardExpiryData=" + cardExpiryData +
                "\ncardProvider=" + cardProvider +
                "\ncvv=" + cvv +
                "\nuserType=" + userType +
                "\nlastThreeTrips=" + Arrays.toString(lastThreeTrips) ;
    }

}
