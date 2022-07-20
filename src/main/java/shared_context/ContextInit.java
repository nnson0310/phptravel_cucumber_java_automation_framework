package shared_context;

import shared_context.ClassContext;

public class ContextInit {
//    public ClassContext classContext;
//
//    public ContextInit() {
//        classContext = new ClassContext();
//    }
//
//    public ClassContext getClassContext() {
//        return classContext;
//    }

    private static ClassContext classContext;

    public static ClassContext getClassContext() {
        if (classContext == null) {
            return classContext = new ClassContext();
        }
        return classContext;
    }
}