package com.utilities;

import com.exceptions.ATFRuntimeException;
import com.storage.Keys;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class ScenarioContext {
    private static Map<Keys, Object> storage = new HashMap<>();

    public static void save(Keys key, Object obj) {
        if (storage.get(key) != null) {
            //log that key is already in place
        }
        storage.put(key, obj);
    }

    public static <T> T get(Keys key) {
        if (!storage.containsKey(key)) {
            throw new ATFRuntimeException(format("key not found %s", key));
        }
        return getOrDefault(key);
    }

    public static <T> T getOrDefault(Keys key) {
        return (T) storage.get(key);
    }
}
