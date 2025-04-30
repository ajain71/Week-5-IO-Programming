import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JavaObjectsToJSONArray {
   public static void main(String[] args) {
       List<Student> list = new ArrayList<>();
       list.add(new Student("Ram", 21, "ram@example.com"));
       list.add(new Student("Priya", 22, "priya@example.com"));
       list.add(new Student("Amit", 20, "amit@example.com"));

       JSONArray arr = new JSONArray();
       for (Student s : list) {
           JSONObject obj = new JSONObject();
           obj.put("name", s.name);
           obj.put("age", s.age);
           obj.put("email", s.email);
           arr.put(obj);
       }

       System.out.println(arr.toString(2));
   }
}

class Student {
   String name;
   int age;
   String email;

   Student(String name, int age, String email) {
       this.name = name;
       this.age = age;
       this.email = email;
   }
}