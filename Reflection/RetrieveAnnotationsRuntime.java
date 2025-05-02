import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Sanjay")
class Book {}

public class RetrieveAnnotationsRuntime {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author a = cls.getAnnotation(Author.class);
            System.out.println(a.name());
        }
    }
}