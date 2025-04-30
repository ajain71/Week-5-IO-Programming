import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

import java.util.Iterator;

public class ReadJSON {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("sample.json")));
        JSONObject obj = new JSONObject(content);
        Iterator<String> keys = obj.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            Object value = obj.get(key);
            System.out.println(key + ": " + value);
        }
    }
}