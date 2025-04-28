import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONtoCSV {
    public static void main(String[] args) throws Exception {
        convertJSONtoCSV("students.json", "students.csv");
        convertCSVtoJSON("students.csv", "output.json");
    }

    public static void convertJSONtoCSV(String input, String output) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(input)));
        JSONArray arr = new JSONArray(content);
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        bw.write("Name,Email,Age");
        bw.newLine();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            String line = obj.getString("name") + "," + obj.getString("email") + "," + obj.getInt("age");
            bw.write(line);
            bw.newLine();
        }

        bw.close();
    }

    public static void convertCSVtoJSON(String input, String output) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(input));
        List<JSONObject> list = new ArrayList<>();
        String line = br.readLine();

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            JSONObject obj = new JSONObject();
            obj.put("name", parts[0]);
            obj.put("email", parts[1]);
            obj.put("age", Integer.parseInt(parts[2]));
            list.add(obj);
        }

        JSONArray arr = new JSONArray(list);
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        bw.write(arr.toString(2));
        bw.close();
        br.close();
    }
}
