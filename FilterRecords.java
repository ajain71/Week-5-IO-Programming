import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords{
   public static void main(String[] args) {
       String path = "student.csv";
       try{
           BufferedReader br = new BufferedReader(new FileReader(path));
           String line;
           System.out.printf("%-5s %-10s %-5s %-5s\n", " ID", " Name", " Age", " Marks");
           while((line=br.readLine())!=null){
               String[] columns = line.split(",");
               int marks = Integer.parseInt(columns[3]);
               if(marks>80){
                   System.out.printf("%-5s %-10s %-5s %-5s\n", columns[0], columns[1], columns[2], columns[3]);
               }
           }
           br.close();
       } catch(IOException e){
           e.printStackTrace();
       }
   }
}