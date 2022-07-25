package case_study.model;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String serviceName, double areaUse, int rentalCosts, int maxNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(serviceName, areaUse, rentalCosts, maxNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "PHÒNG - " + super.toString() +
                "\n\tDịch vụ miễn phí đi kèm: " + getFreeServiceIncluded();
    }
}
