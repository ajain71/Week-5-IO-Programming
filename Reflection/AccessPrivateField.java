import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 35);
        System.out.println(f.getInt(p));
    }
}