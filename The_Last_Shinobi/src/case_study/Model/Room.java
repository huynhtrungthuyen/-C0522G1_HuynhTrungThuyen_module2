package case_study.Model;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String serviceName, double areaUse, double rentalCosts, int maxNumberOfPeople, String rentalType, String freeServiceIncluded) {
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
        return "ROOM - " + super.toString() +
                "\n\tFree Service Included: " + getFreeServiceIncluded();
    }
}
