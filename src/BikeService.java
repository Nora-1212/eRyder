import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeService {
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
}
