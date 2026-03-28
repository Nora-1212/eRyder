import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    public String getBikeID() {
        return bikeID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public ActiveRental() {
    }

    /**
     * 全参构造方法
     * @param bikeID 自行车ID
     * @param userEmail 用户邮箱
     * @param tripStartTime 租赁开始时间
     */

    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }

    @Override
    public String toString() {
        return "ActiveRental:\n" +
                "\nBikes Currently In Use{" +
                "\nbikeID:" + bikeID +
                "\nuserEmail=" + userEmail +
                "\ntripStartTime=" + tripStartTime;
    }
}
