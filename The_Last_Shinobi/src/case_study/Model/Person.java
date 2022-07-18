package case_study.Model;

public abstract class Person {
    private int id;
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String dateOfBirth, int gender, String idCard, String phone, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        if (this.gender == 1) {
            return "Male";
        }

        if (this.gender == 2) {
            return "Female";
        }

        return "LGBT";
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: " + getId() +
                ", Name: " + getName() +
                ", Date Of Birth: " + getDateOfBirth() +
                ", Gender: " + getGender() +
                ", Id Card: " + getIdCard() +
                ",\n\tPhone: " + getPhone() +
                ", Email: " + getEmail();
    }
}
