package samples;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Class<?>, Object> context = new HashMap<>();

    public void add(Class<?> clazz, Object object){
        if (context.containsKey(clazz)){
            //Error message
        }
        context.put(clazz, object);
    }

    public Object get(Class clazz){
        return context.get(clazz);
    }
}
