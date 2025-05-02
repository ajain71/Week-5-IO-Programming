import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class CustomSerializationAnnotation {
    public static void main(String[] args) throws Exception {
        User u = new User("Sanjay", 25);
        StringBuilder json = new StringBuilder("{");
        Field[] fields = u.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                f.setAccessible(true);
                json.append("\"").append(jf.name()).append("\":");
                if (f.get(u) instanceof String) {
                    json.append("\"").append(f.get(u)).append("\"");
                } else {
                    json.append(f.get(u));
                }
                json.append(",");
            }
        }
        if (json.charAt(json.length() - 1) == ',') json.deleteCharAt(json.length() - 1);
        json.append("}");
        System.out.println(json);
    }
}
