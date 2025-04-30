import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ValidateEmailUsingJSONSchema {
    public static void main(String[] args) {
        String schemaStr = """
        {
            "type": "object",
            "properties": {
                "email": {
                    "type": "string",
                    "format": "email"
                }
            },
            "required": ["email"]
        }
        """;

        String jsonStr = """
        {
            "email": "test@example.com"
        }
        """;

        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStr));
        Schema schema = SchemaLoader.load(rawSchema);
        JSONObject data = new JSONObject(new JSONTokener(jsonStr));
        schema.validate(data);
        System.out.println("Valid email format.");
    }
}