import org.json.JSONObject;

public class MergeJSON {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Sanjay");
        obj1.put("age", 22);

        JSONObject obj2 = new JSONObject();
        obj2.put("city", "Chennai");
        obj2.put("email", "sanjay@example.com");

        JSONObject merged = new JSONObject(obj1.toMap());
        merged.putAll(obj2.toMap());

        System.out.println(merged.toString(2));
    }
}