import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            if (!row[0].equalsIgnoreCase("Name") && row[2].equalsIgnoreCase("IT")) {
                double sal = Double.parseDouble(row[3]);
                sal *= 1.1;
                row[3] = String.valueOf(sal);
            }
            bw.write(String.join(",", row));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}

