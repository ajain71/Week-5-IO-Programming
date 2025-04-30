import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONfromDatabase {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        JSONArray jsonArray = new JSONArray();
        while (rs.next()) {
            JSONObject obj = new JSONObject();
            obj.put("id", rs.getInt("id"));
            obj.put("name", rs.getString("name"));
            obj.put("age", rs.getInt("age"));
            obj.put("email", rs.getString("email"));
            jsonArray.put(obj);
        }

        rs.close();
        stmt.close();
        conn.close();

        System.out.println(jsonArray.toString(2));
    }
}
