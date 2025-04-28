import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByColumn {
    public static void main(String[] args) throws IOException {
        String path = "employees.csv";
        ArrayList<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        if (line == null) {
            br.close();
            return;
        }
        data.add(line.split(","));
        while ((line = br.readLine()) != null) {
            data.add(line.split(","));
        }
        br.close();
        Collections.sort(data.subList(1, data.size()), new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Integer.parseInt(b[2].trim()) - Integer.parseInt(a[2].trim());
            }
        });
        String[] head = data.get(0);
        System.out.println(String.join(", ", head));
        for (int i = 1; i <= Math.min(5, data.size() - 1); i++) {
            String[] row = data.get(i);
            System.out.println(String.join(", ", row));
        }
    }
}
