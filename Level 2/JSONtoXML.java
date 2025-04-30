import org.json.JSONObject;
import org.json.XML;

public class JSONtoXML {
    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Sanjay");
        jsonObj.put("age", 22);
        jsonObj.put("email", "sanjay@gmail.com");

        String xml = XML.toString(jsonObj);
        System.out.println(xml);
    }
}
