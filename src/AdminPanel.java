import java.util.*;

public class AdminPanel {
    private LinkedList<RegisteredUsers> registeredUsersList = new LinkedList<>();
    private UserService userService = new UserService(registeredUsersList);
    Scanner scanner = new Scanner(System.in);
    public void userManagementOptions(){
        while (true){
            System.out.println("Please select an option: \n" +
                    "1.Add New Users\n" +
                    "2.View Registered Users\n" +
                    "3.Remove Registered Users\n" +
                    "4.Update Registered Users\n" +
                    "5.EXIT");

            int choice;
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    userService.addNewUsers();
                    break;
                case 2:
                    userService.viewRegisteredUsers();
                    break;
                case 3:
                    userService.removeRegisteredUsers();
                    break;
                case 4:
                    userService.updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
            }

        }


    }


}