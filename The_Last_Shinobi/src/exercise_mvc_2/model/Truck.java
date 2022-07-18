package exercise_mvc_2.model;

public class Truck extends Vehicle {
    private double tonnage;

    public Truck() {
    }

    public Truck(String licensePlates, String manufacturer, int yearOfManufacture, String owner, double tonnage) {
        super(licensePlates, manufacturer, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Trọng tải: " + getTonnage() + " (tấn)";
    }
}
