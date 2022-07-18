package case_study.Model;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String serviceName, double areaUse, double rentalCosts, int maxNumberOfPeople, String rentalType, String roomStandard, double poolArea, int numberOfFloors) {
        super(serviceName, areaUse, rentalCosts, maxNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "VILLA - " + super.toString() +
                "\n\tRoom Standard: " + getRoomStandard() +
                ", Pool Area: " + getPoolArea() +
                ", Number Of Floors: " + getNumberOfFloors();
    }
}
