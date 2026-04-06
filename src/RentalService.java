import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class RentalService {
    public static final double BASE_FARE = 3.0;

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public RentalService(LinkedList<ActiveRental> activeRentalsList){
        this.activeRentalsList = activeRentalsList;
    }

    public void startRental(String bikeID, String userEmail, LocalDateTime tripStartTime){
        ActiveRental activeRental = new ActiveRental(bikeID, userEmail, tripStartTime);
        activeRentalsList.add(activeRental);
    }

    public void endRental(String bikeID,RegisteredUsers user){
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us!");
                System.out.println();
                break;
            }
        }
        System.out.println("\n=====================================");
        System.out.println("           TRIP COMPLETED           ");
        System.out.println("=====================================");
        user.displayUserType();
        double finalFare = user.calculateFare(BASE_FARE);
        System.out.println("Base Fare: €" + BASE_FARE);
        System.out.println("Final Fare Paid: €" + finalFare);
        System.out.println("Thank you for riding with ERyder!\n");
    }

    public void removeTrip(String bikeID){
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while(iterator.hasNext()){
            ActiveRental a=iterator.next();
            if(a.getBikeID().equals(bikeID)){
                iterator.remove();;
                break;
            }
        }
    }


    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental activeRental : activeRentalsList){
                System.out.println(activeRental);
            }
        }
    }

}
