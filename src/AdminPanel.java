import java.util.*;

public class AdminPanel {
    LinkedList<RegisteredUsers> registeredUsersList = new LinkedList<>();
    UserService userService = new UserService(registeredUsersList);
    Scanner scanner = new Scanner(System.in);
    public void userManagementOptions(){
        while (true){
            System.out.println("Please select an option: \n" +
                    "1.Add New Users\n" +
                    "2.View Registered Users\n" +
                    "3.Remove Registered Users\n" +
                    "4.Update Registered Users\n" +
                    "5.EXIT\n" +
                    "6. View System Logs\n" +
                    "7. Manage Pending Bike Requests");

            int choice;
            choice = Integer.parseInt(scanner.nextLine());
            BikeService bikeService = new BikeService();

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
                case 6:
                    bikeService.viewLogs();
                    break;
                case 7:
                    manageRequests();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }


    }
    public void manageRequests(){
        BikeService bikeService = new BikeService();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. View Queue\n" +
                    "2. Update Queue (Remove First)\n" +
                    "3. Exit");
            if (!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            int c = sc.nextInt();
            sc.nextLine();

            if (c == 1){
                bikeService.Queue();
            } else if (c == 2) {
                bikeService.removeFirstRequest();
            } else if (c == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            sc.close();
        }
    }


}