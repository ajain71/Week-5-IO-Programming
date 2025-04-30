import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVtoJSON {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        String line = br.readLine();
        String[] headers = line.split(",");

        List<JSONObject> jsonList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            JSONObject obj = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                obj.put(headers[i], values[i]);
            }
            jsonList.add(obj);
        }
        br.close();

        JSONArray jsonArray = new JSONArray(jsonList);
        System.out.println(jsonArray.toString(2));
    }
}