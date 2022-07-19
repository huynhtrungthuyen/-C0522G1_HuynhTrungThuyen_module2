package exercise_mvc.model;

public abstract class Person {
    private int id;
    private String name;
    private String dayOfBirth;
    private int gender;

    public Person() {
    }

    public Person(int id, String name, String dayOfBirth, int gender) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        if (this.gender == 1) {
            return "Nam";
        }

        if (this.gender == 2) {
            return "Nữ";
        }

        return "LGBT";
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Id:" + getId() + ", Tên: " + getName() + ", Ngày sinh: " + getDayOfBirth() + ", Giới tính: " + getGender();
    }
}
