package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage db) {
        Set<String> keyset = new TreeSet<>(db.toMap().keySet()) {
        };
        for (var key : keyset) {
            var tempValue = db.get(key, "default");
            db.unset(key);
            db.set(tempValue, key);
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
//        storage.get("key", "default"); // "default"
        storage.get("value", "default"); // "key"

        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    }
}
// END
