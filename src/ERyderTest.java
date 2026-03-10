public class ERyderTest {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder("B001",80,true,150);
        ERyder bike2 = new ERyder("B002",75,false,120,"user_john","13900139000");

        bike1.printRideDetails(25);
        bike2.printRideDetails(35);
    }
}
