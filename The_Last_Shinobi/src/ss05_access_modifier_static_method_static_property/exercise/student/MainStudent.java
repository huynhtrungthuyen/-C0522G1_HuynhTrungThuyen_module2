package ss05_access_modifier_static_method_static_property.exercise.student;

public class MainStudent {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("STUDENT 1:\n" + student1);

        Student student2 = new Student();
        student2.setName("Thuyên");
        student2.setClasses("C05");
        System.out.println("STUDENT 2:\n" + student2);
    }
}
