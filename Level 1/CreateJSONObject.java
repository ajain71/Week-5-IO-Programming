import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObject {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Sanjay");
        obj.put("age", 22);

        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Science");
        subjects.put("English");
        obj.put("subjects", subjects);

        System.out.println(obj.toString(2));
    }
}
