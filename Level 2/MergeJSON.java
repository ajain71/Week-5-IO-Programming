import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class MergeJSON {
    public static void main(String[] args) throws Exception {
        String s1 = new String(Files.readAllBytes(Paths.get("file1.json")));
        String s2 = new String(Files.readAllBytes(Paths.get("file2.json")));

        JSONObject o1 = new JSONObject(s1);
        JSONObject o2 = new JSONObject(s2);

        JSONObject merged = new JSONObject(o1.toMap());
        merged.putAll(o2.toMap());

        System.out.println(merged.toString(2));
    }
}
