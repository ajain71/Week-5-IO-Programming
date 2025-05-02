import java.lang.reflect.Field;

class Product {
    String name = "Phone";
    int price = 50000;
}

public class GenerateJSONRepresentation {
    public static void main(String[] args) throws Exception {
        Product p = new Product();
        Class<?> cls = p.getClass();
        Field[] flds = cls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < flds.length; i++) {
            flds[i].setAccessible(true);
            sb.append("\"").append(flds[i].getName()).append("\":");
            Object val = flds[i].get(p);
            if (val instanceof String) sb.append("\"").append(val).append("\"");
            else sb.append(val);
            if (i != flds.length - 1) sb.append(",");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}