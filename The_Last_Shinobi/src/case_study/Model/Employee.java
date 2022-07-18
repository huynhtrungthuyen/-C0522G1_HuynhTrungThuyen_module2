package case_study.Model;

public class Employee extends Person {
    private int level;
    private int position;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, int gender, String idCard, String phone, String email, int level, int position, double salary) {
        super(id, name, dateOfBirth, gender, idCard, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        switch (this.level) {
            case 1:
                return "Intermediate Degree";
            case 2:
                return "The Degree Of Associate";
            case 3:
                return "College Degree";
            default:
                return "Postgraduate";
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPosition() {
        switch (this.position) {
            case 1:
                return "Receptionist";
            case 2:
                return "Maid";
            case 3:
                return "Expert";
            case 4:
                return "Supervision";
            case 5:
                return "Manager";
            default:
                return "Director";
        }
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EMPLOYEE - " + super.toString() +
                ", Level: " + getLevel() +
                ", Position: " + getPosition() +
                ", Salary: " + getSalary();
    }
}
