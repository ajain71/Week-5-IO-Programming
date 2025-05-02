import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    String currentRole;

    AccessControl(String role) {
        this.currentRole = role;
    }

    @RoleAllowed("ADMIN")
    void deleteUser() {
        System.out.println("User deleted");
    }

    void execute(String methodName) throws Exception {
        Method m = this.getClass().getMethod(methodName);
        if (m.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed r = m.getAnnotation(RoleAllowed.class);
            if (!r.value().equals(currentRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }
        m.invoke(this);
    }
}

class RoleBasedAccessControl {
    public static void main(String[] args) throws Exception {
        new AccessControl("ADMIN").execute("deleteUser");
        new AccessControl("USER").execute("deleteUser");
    }
}
