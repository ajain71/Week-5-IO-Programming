import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) {
        String path = "employees.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write("ID,Name,Department,Salary");
            bw.write("1,A,Analyst,35000");
            bw.write("1,B,Systems Engineer,30000");
            bw.write("1,C,Data Scientist,30000");
            bw.write("1,D,Software Tester,27000");
            bw.write("1,E,Associate Engineer,20000");
            System.out.println("Data written successfully");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}