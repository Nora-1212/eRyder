import java.time.LocalDateTime;
import java.util.*;

public class BikeService {
    private Stack<ERyderLog> logStack = new Stack<>();

    public void addLog(String logId, String event) {
        ERyderLog eryderLog=new ERyderLog(logId,event,LocalDateTime.now());
        logStack.push(eryderLog);
    }

    public void viewLogs() {
        if (!logStack.isEmpty()){
            for (ERyderLog eryderLog : logStack){
                System.out.println(eryderLog);
            }
        } else {
            System.out.println("No system logs available.");
        }
    }

    private Queue<ActiveRental> bikeRequestQueue = new ArrayDeque<>();

    public void addToQueue(String bikeID, String email,String location) {
        ActiveRental req = new ActiveRental(bikeID,email,LocalDateTime.now());
        bikeRequestQueue.add(req);
    }

    private String emailAddress;
    private LocalDateTime tripStartTime;
    private boolean locationValid;
    UserRegistration userRegistration = new UserRegistration();
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental activeRental : activeRentalsList){
                System.out.println(activeRental);
            }
        }
    }
    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }
    public String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes){
            if (bike == null) continue;
            if (bike.getLocation() != null
                    && bike.getLocation().trim().equalsIgnoreCase(location.trim())
                    && bike.getIsAvailable()){
                System.out.println("A bike is available at the location you requested.\n");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bike are available at the location you requested.");
        return null;
    }

    public void reserveBike(String bikeID) {
        if (bikeID == null){
            System.out.println("Sorry, no bike are available at the location you requested.");
            return;
        }
        for (Bike bike : BikeDatabase.bikes){
            if (bike.getBikeID().equals(bikeID)){
                bike.setIsAvailable(false);
                System.out.println("Reserving the bike with the " + bikeID + ".\nPlease follow the on-screen direction to locate the bike and start your trip.\n");
                break;
            }
        }
    }

    public void Queue(){
        System.out.println("=== Pending Requests ===");
        for (ActiveRental req : bikeRequestQueue){
            System.out.println(req);
        }
    }

    public void removeFirstRequest(){
        if (!bikeRequestQueue.isEmpty()){
            bikeRequestQueue.remove();
        }
    }
}
