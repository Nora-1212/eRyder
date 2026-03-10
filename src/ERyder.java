//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private double usageInMinutes;
    private double totalFare;


    public static final String COMPANY_NAME = "ERyder";
    public static final Double BASE_FARE = 1.0;
    public static final double PRE_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final long LINKED_PHONE_NUMBER;


    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "greetg";
        this.LINKED_PHONE_NUMBER = 1234567;
        this.usageInMinutes = 0;
        this.totalFare = 0.0;
    }
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String LINKED_ACCOUNT, long LINKED_PHONE_NUMBER) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = LINKED_ACCOUNT;
        this.LINKED_PHONE_NUMBER = LINKED_PHONE_NUMBER;
        this.usageInMinutes = 0;
        this.totalFare = 0.0;
    }
    public void ride(){
        if (batteryLevel>0 && isAvailable){
            System.out.println("The bike is available.");
        }else {
            System.out.println("The bike is not available.");
        }
    }
    public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID + ".");
        System.out.println("The linked account is "+LINKED_ACCOUNT+".");
        System.out.println("The linked phone number is "+LINKED_PHONE_NUMBER+".");
        System.out.println("The total fare is "+calculateFare(usageInMinutes)+".");
        System.out.println("Battery Level: " + batteryLevel+".");
        System.out.println("Is Available: " + isAvailable+".");
        System.out.println("Distance Travelled: " + kmDriven+".");
    }
    public void printRideDetails(int usageInMinutes){
        double fare = calculateFare(usageInMinutes);
        System.out.println("The total fare is $" + fare + ".");
    }

    public double calculateFare(double usageInMinutes) {
        return BASE_FARE + (PRE_MINUTE_FARE * usageInMinutes);
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public void setCOMPANY_NAME(String COMPANY_NAME) {
        this.COMPANY_NAME = COMPANY_NAME;
    }

    public Double getBASE_FARE() {
        return BASE_FARE;
    }

    public void setBASE_FARE(Double BASE_FARE) {
        this.BASE_FARE = BASE_FARE;
    }

    public double getPRE_MINUTE_FARE() {
        return PRE_MINUTE_FARE;
    }

    public void setPRE_MINUTE_FARE(double PRE_MINUTE_FARE) {
        this.PRE_MINUTE_FARE = PRE_MINUTE_FARE;
    }

    public String getLINKED_ACCOUNT() {
        return LINKED_ACCOUNT;
    }

    public String getLINKED_PHONE_NUMBER() {
        return LINKED_PHONE_NUMBER;
    }
}