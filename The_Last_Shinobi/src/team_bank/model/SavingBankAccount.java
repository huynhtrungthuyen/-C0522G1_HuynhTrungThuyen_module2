package team_bank.model;

public class SavingBankAccount extends BankAccount {
    private int moneySaving;
    private String dateSaving;
    private double interestRate;
    private int time;

    public SavingBankAccount() {
    }

    public SavingBankAccount(int id, String code, String name, String date, int moneySaving, String dateSaving, double interestRate, int time) {
        super(id, code, name, date);
        this.moneySaving = moneySaving;
        this.dateSaving = dateSaving;
        this.interestRate = interestRate;
        this.time = time;
    }

    public int getMoneySaving() {
        return moneySaving;
    }

    public void setMoneySaving(int moneySaving) {
        this.moneySaving = moneySaving;
    }

    public String getDateSaving() {
        return dateSaving;
    }

    public void setDateSaving(String dateSaving) {
        this.dateSaving = dateSaving;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", getId(), getCode(), getName(), getDate(), getMoneySaving(),
                getDateSaving(), getInterestRate(), getTime());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Số tiền gửi tiết kiệm (VNĐ): " + getMoneySaving() +
                ", Ngày gửi: " + getDateSaving() +
                ", Lãi suất (%): " + getInterestRate() +
                ", Kì hạn (tháng): " + getTime();
    }
}
