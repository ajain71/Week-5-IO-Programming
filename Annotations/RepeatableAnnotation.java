import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Array index out of bounds")
    void run() {
        System.out.println("Running software");
    }
}

class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method m = Software.class.getMethod("run");
        BugReport[] reports = m.getAnnotationsByType(BugReport.class);
        for (BugReport b : reports) {
            System.out.println(b.description());
        }
    }
}
