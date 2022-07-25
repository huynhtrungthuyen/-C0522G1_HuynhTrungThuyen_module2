package case_study.model;

public class Booking {
    private int bookingId;
    private String startDay;
    private String endDay;
    private int customerId;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(int bookingId, String startDay, String endDay, int customerId, String serviceName, String serviceType) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "ĐẶT CHỖ - " +
                "Mã đặt chỗ: " + getBookingId() +
                ", Ngày bắt đầu: " + getStartDay() +
                ", Ngày kết thúc: " + getEndDay() +
                ", Mã khách hàng: " + getCustomerId() +
                ", Tên dịch vụ: " + getServiceName() +
                ", Loại dịch vụ: " + getServiceType();
    }
}
