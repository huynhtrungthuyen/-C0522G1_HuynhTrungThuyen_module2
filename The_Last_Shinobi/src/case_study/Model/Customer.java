package case_study.Model;

public class Customer extends Person {
    private int customerType;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, int gender, String idCard, String phone, String email, int customerType, String address) {
        super(id, name, dateOfBirth, gender, idCard, phone, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        switch (this.customerType) {
            case 1:
                return "Diamond";
            case 2:
                return "Platinium";
            case 3:
                return "Gold";
            case 4:
                return "Silve";
            default:
                return "Member";
        }
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CUSTOMER - " + super.toString() +
                ", Customer: " + getCustomerType() +
                ", Address: " + getAddress();
    }
}
