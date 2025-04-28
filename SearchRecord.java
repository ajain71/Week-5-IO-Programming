import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "employees.csv";
        System.out.print("Enter name to search: ");
        String name = sc.next();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null){
                String[] columns = line.split(",");
                if(columns[1]==name){
                    System.out.print("Department: " + columns[2] + "\nSalary: " + columns[3]);
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}