import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonToValidateJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("data.json"));
        if (node.has("name") && node.has("email") && node.has("age")) {
            System.out.println("Valid JSON structure");
        } else {
            System.out.println("Invalid JSON structure");
        }
    }
}