import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class UserRegistration {
    public static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    public static final double VIP_DISCOUNT_OVER_18 = 20.0;
    public static final int VIP_BASE_FEE = 100;

    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;

    private String userType;

    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean validCVV;

    public void registration(){
        System.out.println("Here are your two choices:");
        System.out.println("1. Regular User");
        System.out.println("2. VIP User");
        System.out.print("Please enter your choice(1 or 2): ");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice){
                case 1:

                    userType="Regular User";
                    print(scanner);
                    finalCheckpoint();
                    break;
                case 2:
                    userType="VIP User";
                    print(scanner);
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    return;
            }
            if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV){
                System.out.println("Registration successful!");
                scanner.close();
                break;
            } else {
                System.out.println("Registration failed. Please try again.");
            }
        }
    }
    private boolean analyseEmail(String email){
        emailValid = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,4}");
        if (!emailValid){
            System.out.println("Invalid email address.Going back to the start of the registration.");
            registration();
        } else {
            System.out.println("Email is valid.");
        }
        return emailValid;
    }
    private boolean analyseAge(LocalDate dob){
        boolean isBirthday = dob.getMonthValue() == LocalDate.now().getMonthValue() && dob.getDayOfMonth() == LocalDate.now().getDayOfMonth();
        int period = Period.between(dob, LocalDate.now()).getYears();
        ageValid = period >= 18 || (period == 17 && isBirthday);
        if (!ageValid){
            System.out.println("You must be at least 18 years old or 17 years old with a birthday today. Going back to the start of the registration.");
        } else {
            System.out.println("Congratulations!You are old enough to register.");
        }
        if (userType.equals("VIP User")){
            if (isBirthday){
                if (period<=18 && period>12){
                    System.out.println("Happy birthday! Since you are under 18 and your birthday is today,you will receive a 25% discount on your subscription fee.");
                    minorAndBirthday = true;
                }
            } else {
                if (period<=18 && period>12){
                    System.out.println("Since you are under 18 and your birthday is not today,you will receive a 20% discount on your subscription fee.");
                    minor = true;
                }
            }
        }
        if (period<=12 || period>=120){
            System.out.println("It looks like you either are too young or have passed away.We're sorry,but you cannot become a user.");
            System.exit(0);
        }
        return ageValid;
    }
    private boolean analyseCardNumber(long cardNumber) {
        String cardNUmberStr = Long.toString(cardNumber);
        int firstTwoDigits = parseInt(cardNUmberStr.substring(0, 2));
        int firstFourDigits = parseInt(cardNUmberStr.substring(0, 4));
        if (cardNUmberStr.startsWith("4") && (cardNUmberStr.length() == 13 || cardNUmberStr.length() == 15)) {
            cardProvider = "VISA";
            cardNumberValid = true;
        } else if (cardNUmberStr.length() == 16) {
            if (firstTwoDigits > 51 && firstTwoDigits <= 55 || firstFourDigits >= 2221 && firstFourDigits <= 2720) {
                cardProvider = "MasterCard";
                cardNumberValid = true;
            }
        } else if (cardNUmberStr.length() == 15 && (cardNUmberStr.startsWith("34") || cardNUmberStr.startsWith("37"))) {
            cardProvider = "American Express";
            cardNumberValid = true;
        }
        if (!cardNumberValid) {
            System.out.println("Sorry,we only accept VISA,Mastercard,or American Express.Please try again with a valid card.Return to the registration start page.");
        } else {
            System.out.println("Your card provider is " + cardProvider);
        }
        registration();
        return cardNumberValid;
    }

    private boolean
    analyseCardExpiryDate(String expiryDate) {
        int month=parseInt(cardExpiryDate.substring(0,2));
        int year=parseInt(cardExpiryDate.substring(3,5))+2000;
        LocalDate currentDate=LocalDate.now();
        int currentYear=currentDate.getYear();
        int currentMonth=currentDate.getMonthValue();
        if(year>currentYear||(year==currentYear&&month>currentMonth)){
            System.out.println("Your card is still valid.");
            cardStillValid=true;
        }else {
            cardStillValid = false;

            System.out.println("Sorry,your card has expired. Please use another card. Return to the registration start page.");
        }
        registration();
        return cardStillValid;
    }
    private boolean analyseCVV(int cvv) {
        String cvvStr=Integer.toString(cvv);
        if(cardProvider.equals("American Express")&&cvvStr.length()==4||cardProvider.equals("VISA")&&cvvStr.length()==3||cardProvider.equals("MasterCard")&&cvvStr.length()==3) {
            System.out.println("Card CVV is valid.");
            validCVV = true;
        }else {
            System.out.println("Invalid CVV for the given card.Going back to the start of the registration progress.");
            validCVV = false;
        }
        registration();
        return validCVV;
    }

    private void finalCheckpoint(){
        if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV){
            chargeFees();
        } else {
            System.out.println("Sorry,your registration was not successful.The reasons are as follow:");
            if (!emailValid) {
                System.out.println("Email address invalid.");
            }
            if (!ageValid) {
                System.out.println("Age invalid.");
            }
            if (!cardNumberValid) {
                System.out.println("Card number invalid.");
            }
            if (!cardStillValid) {
                System.out.println("Card expired.");
                System.out.println("Returning to the start of the registration process.");
                registration();
            }
        }
    }
    private void chargeFees(){
        double feeToCharge;
        if (minorAndBirthday){
            feeToCharge=VIP_BASE_FEE-VIP_DISCOUNT_UNDER_18_BIRTHDAY;
        } else if (minor) {
            feeToCharge=VIP_BASE_FEE-VIP_DISCOUNT_OVER_18;
        } else {
            feeToCharge=VIP_BASE_FEE;
        }
        String s = Long.toString(cardNumber);
        System.out.println("Thank you for your payment.A fee of" + feeToCharge + "has been charged to your card ending in " + s.substring(s.length()-4));
    }
    @Override
    public String toString() {
        String cardNumberStr = Long.toString(cardNumber);
        String censoredPart = cardNumberStr.replaceAll("lastFourDigits","*");
        String lastFourDigits = cardNumberStr.substring(cardNumberStr.length()-4);
        String censoredNumber = censoredPart + lastFourDigits;
        return "Registration successful!Here are your details:\n" + "User Type:" + userType + "\nFull Name: " + fullName + "\nEmail Address: " + emailAddress + "\nDate of Birth: " + dateOfBirth + "\nCard Number: " + censoredNumber + "\nCard Provider: " + cardProvider + "\nCard Expiry Date: " + cardExpiryDate;
    }
    private void print(Scanner scanner){
        System.out.println("Please enter your full name:");
        fullName = scanner.nextLine();
        System.out.println("Please enter your email address:");
        emailAddress = scanner.nextLine();
        emailValid = analyseEmail(emailAddress);
        System.out.println("Please enter your date of birth (yyyy-MM-dd):");
        dateOfBirth = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        ageValid = analyseAge(dob);
        System.out.println("Please enter your card number:");
        System.out.println("Please enter your card provider(VISA,Mastercard or American Express):");
        cardNumber = scanner.nextLong();
        cardNumberValid = analyseCardNumber(cardNumber);
        System.out.println("Please enter your card expiration date:");
        cardExpiryDate = scanner.nextLine();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);
        System.out.println("Please enter your card CVV:");
        cvv = scanner.nextInt();
        validCVV = analyseCVV(cvv);
    }
}
