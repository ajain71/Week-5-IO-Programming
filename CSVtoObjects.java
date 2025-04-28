import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoObjects {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        List<Student> list = new ArrayList<>();
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                Student s = new Student(parts[0], parts[1], Integer.parseInt(parts[2]));
                list.add(s);
            }
        }
        for (Student s : list) {
            System.out.println(s);
        }
        br.close();
    }
}

class Student {
    String name;
    String email;
    int age;

    Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String toString() {
        return name + "," + email + "," + age;
    }
}
