package ss10_dsa_list.exercise.array_list;

public class TestMyList {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
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

        public String toString() {
            return "Name: " + getName() + ", id: " + getId();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"Văn Nam");
        Student student2 = new Student(2,"Bùi Hùng");
        Student student3 = new Student(3,"Hải Học");
        Student student4 = new Student(4,"Văn Tý");
        Student student5 = new Student(5,"Văn Phúc");
        Student student6 = new Student(6,"Văn Nam");
        Student student7 = new Student(7,"Đại Lợi");
        Student student8 = new Student(8,"Minh Trí");
        Student student9 = new Student(9,"Thủy Tiên");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        studentMyList.add(student5);
        studentMyList.add(student6);
        studentMyList.add(student7);
        studentMyList.add(3, student8);
        studentMyList.add(5, student9);
        studentMyList.remove(1);

        for (int i = 0; i < studentMyList.size(); i++) {
            System.out.println((i+1) + ". " + studentMyList.elements[i]);
        }

        System.out.println(studentMyList.get(1));
    }
}
