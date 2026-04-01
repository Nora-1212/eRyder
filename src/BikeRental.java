//import java.time.LocalDateTime;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class BikeRental {
//    private boolean isRegisteredUser;
//    private String emailAddress;
//    private String location;
//    private LocalDateTime tripStartTime;
//    private String bikeID;
//    private boolean locationValid;
//
//    private UserRegistration userRegistration = new UserRegistration();
//    private ActiveRental activeRental;
//    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<ActiveRental>();
//
//    public BikeRental() {
//
//    }
//
//    public BikeRental(boolean isRegisteredUser, String emailAddress, String location, boolean locationValid, String bikeID, LocalDateTime tripStartTime) {
//        this.bikeID = bikeID;
//        this.tripStartTime = tripStartTime;
//        this.isRegisteredUser = isRegisteredUser;
//        this.emailAddress = emailAddress;
//        this.location = location;
//        this.locationValid = locationValid;
//    }
//
//    public void simulateApplicationInput() {
//        System.out.println("This is the simulation of the bike rental process.");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("State if the user is a registered user (true/false):");
//        isRegisteredUser = scanner.nextBoolean();
//
//        System.out.println("Enter the email address of the user: ");
//        emailAddress = scanner.next();
//        scanner.nextLine();
//
//        System.out.println("Enter the location of the bike: ");
//        location = scanner.nextLine();
//
//        System.out.println("\nSimulating the analysis of the rental request...");
//        bikeID = analyseRequest();
//
//        if (bikeID == null){
//            System.out.println("Exiting the program. Please try again later when we have bikes available at your location. Thank you!");
//            return;
//        }
//
//        System.out.println("Simulating bike reservation…");
//        reserveBike(bikeID);
//
//        System.out.println("Displaying the active rentals…");
//        viewActiveRentals();
//
//        System.out.println("\nSimulating the end of the trip…");
//        removeTrip(bikeID);
//
//        System.out.println("Displaying the active rentals after trip end…");
//        viewActiveRentals();
//    }
//
//    private void removeTrip(String bikeID) {
//        if (bikeID == null) return;
//
//        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
//        while (iterator.hasNext()){
//            ActiveRental activeRental = iterator.next();
//            if (activeRental.getBikeID().equals(bikeID)){
//                iterator.remove();
//                break;
//            }
//        }
//
//        for (Bike bike : BikeDatabase.bikes){
//            if (bike.getBikeID().equals(bikeID)){
//                bike.setIsAvailable(true);
//                bike.setLastUsedTime(LocalDateTime.now());
//                System.out.println("Your trip has ended. Thank you for riding with us.\n");
//                break;
//            }
//        }
//    }
//
//    private void viewActiveRentals() {
//        if (activeRentalsList.isEmpty()){
//            System.out.println("No active rentals at the moment.");
//        } else {
//            for (ActiveRental activeRental : activeRentalsList){
//                System.out.println(activeRental);
//            }
//        }
//    }
//
//    private void reserveBike(String bikeID) {
//        if (bikeID == null){
//            System.out.println("Sorry, no bike are available at the location you requested.");
//            return;
//        }
//        for (Bike bike : BikeDatabase.bikes){
//            if (bike.getBikeID().equals(bikeID)){
//                tripStartTime = LocalDateTime.now();
//                bike.setIsAvailable(false);
//                bike.setLastUsedTime(tripStartTime);
//                System.out.println("Reserving the bike with the " + bikeID + ".\nPlease follow the on-screen direction to locate the bike and start your trip.\n");
//                activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
//                activeRentalsList.add(activeRental);
//                break;
//            }
//        }
//    }
//
//    private String analyseRequest() {
//        if (!isRegisteredUser) {
//            System.out.println("You’re not our registered user. Please consider registering.");
//            userRegistration.registration();
//        } else {
//            System.out.println("Welcome back, " + emailAddress + "!");
//        }
//        return validateLocation(location);
//    }
//
//    private String validate(String location) {
//        locationValid = true;
//        return bikeID;
//    }
//
//    private String validateLocation(String location) {
//        for (Bike bike : BikeDatabase.bikes){
//            if (bike == null) continue;
//            if (bike.getLocation() != null
//                    && bike.getLocation().trim().equalsIgnoreCase(location.trim())
//                    && bike.getIsAvailable()){
//                System.out.println("A bike is available at the location you requested.\n");
//                locationValid = true;
//                return bike.getBikeID();
//            }
//        }
//        System.out.println("Sorry, no bike are available at the location you requested.");
//        locationValid = false;
//        return null;
//    }
//}
