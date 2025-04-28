import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MergeCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("merged.csv"));
        HashMap<String, String[]> map = new HashMap<>();

        String line1 = br1.readLine();
        String line2 = br2.readLine();
        bw.write("ID,Name,Age,Marks,Grade");
        bw.newLine();

        while ((line1 = br1.readLine()) != null) {
            String[] parts = line1.split(",");
            if (parts.length >= 3) map.put(parts[0], new String[]{parts[1], parts[2]});
        }

        while ((line2 = br2.readLine()) != null) {
            String[] parts = line2.split(",");
            if (parts.length >= 3 && map.containsKey(parts[0])) {
                String[] val = map.get(parts[0]);
                bw.write(parts[0] + "," + val[0] + "," + val[1] + "," + parts[1] + "," + parts[2]);
                bw.newLine();
            }
        }

        br1.close();
        br2.close();
        bw.close();
    }
}
