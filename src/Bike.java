import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Bike(){

    }

    /**
     * @param bikeID 自行车ID
     * @param isAvailable 是否可租赁
     * @param batteryLevel 电量
     * @param lastUsedTime 上一次使用时间
     * @param location 停放位置
     */

    public Bike(String bikeID, boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bike: " +
                "\nbikeID= " + bikeID +
                "\nisAvailable= " + isAvailable +
                "\nbatteryLevel= " + batteryLevel +
                "\nlastUsedTime= " + lastUsedTime +
                "\nlocation= " + location ;
    }
}
