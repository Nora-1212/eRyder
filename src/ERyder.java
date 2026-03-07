//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public void Bike() {
        this.bikeID = "";
        this.batteryLevel = 0;
        this.isAvailable = false;
        this.kmDriven = 0.0;
    }
    public void Bike(String bikeID, int batteryLevel, boolean isAvailable, double keDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = keDriven;
    }
    public void ride(){
        if (batteryLevel>0 && isAvailable){
            System.out.println("The bike is available.");
        }else {
            System.out.println("The bike is not available.");
        }
    }
    public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Is Available: " + isAvailable);
        System.out.println("Distance Travelled: " + kmDriven);
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
}