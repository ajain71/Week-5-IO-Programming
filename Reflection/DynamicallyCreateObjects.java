class Student {
    String name;
    int roll;
    Student() {
        name = "Ram";
        roll = 101;
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Student s = (Student) obj;
        System.out.println(s.name + " " + s.roll);
    }
}