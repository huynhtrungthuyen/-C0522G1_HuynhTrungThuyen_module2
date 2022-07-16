package exercise2.model;

public abstract class Vehicle {
    private String licensePlates;
    private String manufacturer;
    private int yearOfManufacture;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlates, String manufacturer, int yearOfManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Biển kiểm soát: " + getLicensePlates() +
                ", Hãng sản xuất: " + getManufacturer() +
                ", Năm sản xuất: " + getYearOfManufacture() +
                ", Chủ sở hữu: " + getOwner();
    }
}
