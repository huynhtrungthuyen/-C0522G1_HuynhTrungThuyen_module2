package exercise_mvc.model;

public class Teacher extends Person {
    private String technique;

    public Teacher() {
    }

    public Teacher(int id, String name, String dayOfBirth, String gender, String technique) {
        super(id, name, dayOfBirth, gender);
        this.technique = technique;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s\n", this.getId(), this.getName(), this.getDayOfBirth(), this.getGender(), this.getTechnique());
    }

    @Override
    public String toString() {
        return super.toString() + ", Chuyên môn: " + getTechnique();
    }
}
