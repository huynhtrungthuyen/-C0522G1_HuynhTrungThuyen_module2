package case_study.model;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, double areaUse, int rentalCosts, int maxNumberOfPeople, String rentalType, String roomStandard, int numberOfFloors) {
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
        return "NHÀ - " + super.toString() +
                "\n\tTiêu chuẩn phòng: " + getRoomStandard() +
                ", Số tầng: " + getNumberOfFloors();
    }
}
