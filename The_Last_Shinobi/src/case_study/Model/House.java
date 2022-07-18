package case_study.Model;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, double areaUse, double rentalCosts, int maxNumberOfPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(serviceName, areaUse, rentalCosts, maxNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "HOUSE - " + super.toString() +
                "\n\tRoom Standard: " + getRoomStandard() +
                ", Number Of Floors: " + getNumberOfFloors();
    }
}
