public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder("B001",80,true,120);
        bike1.printBikeDetails();
        System.out.println("----------------------------------");

        ERyder bike2 = new ERyder("B001", 75, true, 123.45);
        bike2.ride();
        bike2.printBikeDetails();
    }
}
