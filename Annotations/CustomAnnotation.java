import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Sanjay")
    void completeTask() {
        System.out.println("Task completed");
    }
}

class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method m = TaskManager.class.getMethod("completeTask");
        TaskInfo info = m.getAnnotation(TaskInfo.class);
        System.out.println(info.priority());
        System.out.println(info.assignedTo());
    }
}
