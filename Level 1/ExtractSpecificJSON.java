import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtractSpecificJSON {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("users.json")));
        JSONArray arr = new JSONArray(content);

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            String name = obj.getString("name");
            String email = obj.getString("email");
            System.out.println(name + " - " + email);
        }
    }
}