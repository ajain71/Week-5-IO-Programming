import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Alice")
    void loginFeature() {}

    @Todo(task = "Add logout", assignedTo = "Bob", priority = "HIGH")
    void logoutFeature() {}

    void dashboard() {}
}

class TodoAnnotation {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + ": " + t.task() + ", " + t.assignedTo() + ", " + t.priority());
            }
        }
    }
}
