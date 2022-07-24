package case_study.Model;

public abstract class Facility {
    private String serviceName;
    private double areaUse;
    private int rentalCosts;
    private int maxNumberOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, double areaUse, int rentalCosts, int maxNumberOfPeople, String rentalType) {
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Tên dịch vụ: " + getServiceName() +
                ", Diện tích sử dụng (m2): " + getAreaUse() +
                ", Chi phí thuê (VNĐ): " + getRentalCosts() +
                ", Số người tối đa: " + getMaxNumberOfPeople() +
                ", Kiểu thuê: " + getRentalType();
    }
}
