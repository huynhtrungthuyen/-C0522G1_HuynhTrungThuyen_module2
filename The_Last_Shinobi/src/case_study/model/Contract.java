package case_study.model;

public class Contract {
    private int numberContract;
    private int bookingId;
    private int depositMoney;
    private int sumMoney;
    private int customerId;

    public Contract() {
    }

    public Contract(int numberContract, int bookingId, int depositMoney, int sumMoney, int customerId) {
        this.numberContract = numberContract;
        this.bookingId = bookingId;
        this.depositMoney = depositMoney;
        this.sumMoney = sumMoney;
        this.customerId = customerId;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "HỢP ĐỒNG - " +
                "Số hợp đồng: " + getNumberContract() +
                ", Mã booking: " + getBookingId() +
                ", Số tiền cọc trước (VNĐ): " + getDepositMoney() +
                ", Tổng số tiền thanh toán (VNĐ): " + getSumMoney() +
                ", Mã khách hàng: " + getCustomerId();
    }
}
