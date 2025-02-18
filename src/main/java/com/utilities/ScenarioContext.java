package com.utilities;

import com.exceptions.ATFRuntimeException;
import com.storage.ScenarioKeys;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class ScenarioContext {
    private static Map<ScenarioKeys, Object> storage = new HashMap<>();

    public static void save(ScenarioKeys key, Object obj) {
        if (storage.get(key) != null) {
            //log that key is already in place
        }
        storage.put(key, obj);
    }

    public static <T> T get(ScenarioKeys key) {
        if (!storage.containsKey(key)) {
            throw new ATFRuntimeException(format("key not found %s", key));
        }
        return getOrDefault(key);
    }

    public static <T> T getOrDefault(ScenarioKeys key) {
        return (T) storage.get(key);
    }
}
