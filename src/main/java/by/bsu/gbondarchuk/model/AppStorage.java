package by.bsu.gbondarchuk.model;

import by.bsu.gbondarchuk.model.enums.ObjectKey;

import java.util.HashMap;
import java.util.Map;

public class AppStorage {
    private static final Object lock = 0;
    private static Map<String, Object> objectMap = new HashMap<String, Object>();

    public static Object getObject(ObjectKey key) {
        return getObject(key.name());
    }

    public static Object getObject(String key) {
        synchronized (lock) {
            return objectMap.get(key);
        }
    }

    public static Object writeObject(ObjectKey key, Object value) {
        return writeObject(key.name(), value);
    }

    public static Object writeObject(String key, Object value) {
        synchronized (lock) {
            return objectMap.put(key, value);
        }
    }
}
