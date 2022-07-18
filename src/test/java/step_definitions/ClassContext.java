package step_definitions;

import java.util.HashMap;
import java.util.Map;

public class ClassContext {
    private Map<String, Object> classContext;

    public ClassContext() {
        classContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        classContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return classContext.get(key.toString());
    }
}
