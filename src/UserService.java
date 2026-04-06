import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private LinkedList<RegisteredUsers> registeredUsersList;
    Scanner scanner = new Scanner(System.in);

    public UserService(LinkedList<RegisteredUsers> registeredUsersLists){
        this.registeredUsersList = registeredUsersLists;
    }

    public RegisteredUsers addNewUsers() {
        System.out.println("How many users would you like to add? ");
        int userCount;
        try {
            String input = scanner.nextLine().trim();
            userCount = Integer.parseInt(input);
            if (userCount <= 0) {
                System.out.println("Please enter a positive number.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;

        }

        RegisteredUsers createdUser = null;

        for (int i = 0;i < userCount;i++){
            System.out.println("\n---Entering details for User "+(i+1)+"---");

            System.out.println("Enter user type (e.g., Rider/Driver/VIP): ");
            String userTypeInput = scanner.nextLine();

            System.out.println("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.println("Enter email address: ");
            String emailAddress = scanner.nextLine();

            System.out.println("Enter date of birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();

            System.out.println("Enter card number: ");
            long cardNumber = Long.parseLong(scanner.nextLine());

            System.out.println("Enter card expiry date (MM/YY): ");
            String cardExpiryData = scanner.nextLine();

            System.out.println("Enter card provider: ");
            String cardProvider = scanner.nextLine();

            System.out.println("Enter CVV: ");
            int cvv = Integer.parseInt(scanner.nextLine());

            RegisteredUsers newUser;
            if (userTypeInput.equalsIgnoreCase("VIP")){
                newUser = new VIPUser(fullName,emailAddress,dateOfBirth,cardNumber,cardExpiryData,cardProvider,cvv,userTypeInput);
            } else {
                newUser = new RegularUser(fullName,emailAddress,dateOfBirth,cardNumber,cardExpiryData,cardProvider,cvv,userTypeInput);
            }

            registeredUsersList.add(newUser);


            System.out.println("\n--- Enter last three trips for this user ---");
            String[] trips = new String[3];
            for (int j =0;j < 3;j++){
                System.out.println("\nTrip " + (j + 1) + ":");

                System.out.println("Enter date of trip (YYYY-MM-DD): ");
                String tripDate = scanner.nextLine();

                System.out.println("Enter source: ");
                String source = scanner.nextLine();

                System.out.println("Enter destination: ");
                String destination = scanner.nextLine();

                System.out.println("Enter fare paid: ");
                String fare = scanner.nextLine();

                System.out.println("Enter user feedback (can be empty for NULL): ");
                String feedback = scanner.nextLine();
                if (feedback.trim().isEmpty()){
                    feedback = "NULL";
                }

                StringBuilder tripSb = new StringBuilder();
                tripSb.append("Date: ").append(tripDate)
                        .append(", Source: ").append(source)
                        .append(", Destination: ").append(destination)
                        .append(", Fare (€): ").append(fare)
                        .append(", Feedback: ").append(feedback);

                trips[j] = tripSb.toString();
            }
            newUser.setLastThreeTrips(trips);

            registeredUsersList.add(newUser);
            System.out.println("\nUser " + (i + 1) + " added successfully!");
        }
        return createdUser;
    }

    public void viewRegisteredUsers() {
        System.out.println("\n--- Registered Users ---");

        if (registeredUsersList.isEmpty()){
            System.out.println("No registered users to display");
            return;
        }

        int userCount = 1;
        for (RegisteredUsers user : registeredUsersList){
            System.out.println("\n--- User " + userCount + " ---");
            System.out.println(user);
            userCount++;
        }
    }

    public void removeRegisteredUsers(){
        System.out.println("\n--- Remove Registered User ---");

        if (registeredUsersList.isEmpty()){
            System.out.println("No registered users to remove");
            return;
        }

        System.out.println("Enter the email address of the user to remove: ");
        String targetEmail = scanner.nextLine();

        boolean userFound = false;
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();

        while (iterator.hasNext()){
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(targetEmail)){
                iterator.remove();
                userFound = true;
                System.out.println("User removed successfully!");
                break;
            }
        }

        if (!userFound) {
            System.out.println("No user found with this email address");
        }
    }

    public void updateRegisteredUsers(){
        System.out.println("\n--- Update Registered User ---");

        if (registeredUsersList.isEmpty()){
            System.out.println("No registered users to update");
            return;
        }

        System.out.println("Enter the email address of the user to update: ");
        String targetEmail = scanner.nextLine();

        RegisteredUsers userToUpdate = null;
        for (RegisteredUsers user : registeredUsersList){
            if (user.getEmailAddress().equals(targetEmail)){
                userToUpdate = user;
                break;
            }
        }
        if (userToUpdate == null){
            System.out.println("No user found with this email address");
            return;
        }

        System.out.println("\n--- Updating details for " + userToUpdate.getFullName() + " ---");

        System.out.println("Type new full name: ");
        String fullname = scanner.nextLine();
        if (!fullname.isEmpty()){
            userToUpdate.setFullName(fullname);
        }

        System.out.println("Type new email address: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()){
            userToUpdate.setEmailAddress(email);
        }

        System.out.println("Type new date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()){
            userToUpdate.setDateOfBirth(dob);
        }

        System.out.println("Type new card provider: ");
        String cardProvider = scanner.nextLine();
        if (!cardProvider.isEmpty()){
            userToUpdate.setCardProvider(cardProvider);
        }

        System.out.println("Type new card number: ");
        String cardNumber = scanner.nextLine();
        if (!cardNumber.equals("0")){
            userToUpdate.setCardNumber(Long.parseLong(cardNumber));
        }

        System.out.println("Type new card expiry date (MM/YY): ");
        String cardExpiry = scanner.nextLine();
        if (!cardExpiry.equals("0")){
            userToUpdate.setCardExpiryData(cardExpiry);
        }

        System.out.println("Type new CVV: ");
        int cvv = scanner.nextInt();
        if (cvv != 0){
            userToUpdate.setCvv(cvv);
        }

        System.out.println("User updated successfully!");
    }
}
