package exercise2.model;

public class Motorbike extends Vehicle {
    private double wattage;

    public Motorbike() {
    }

    public Motorbike(String licensePlates, String manufacturer, int yearOfManufacture, String owner, double wattage) {
        super(licensePlates, manufacturer, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Công suất: " + getWattage() + " (kW)";
    }
}
