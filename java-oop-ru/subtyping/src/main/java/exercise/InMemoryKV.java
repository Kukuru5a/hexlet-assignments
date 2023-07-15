package exercise;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{

    private final Map<String, String> mp;

    public InMemoryKV(Map<String, String> storage) {
        this.mp = new HashMap<>();
        this.mp.putAll(storage);
    }

    @Override
    public void set(String key, String value) {
    mp.put(key, value);
    }

    @Override
    public void unset(String key) {
    mp.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
//
        return mp.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> mm = new HashMap<>();
        for (Map.Entry<String, String> rr : mp.entrySet()) {
            mm.put(rr.getKey(), rr.getValue());
        }
        return mm;
    }

    public static void main(String[] args) {
        Map<String, String> mm = new HashMap<>(Map.of("ll", "1"));

        var tt = new InMemoryKV(mm);

//        tt.get("ll", "default");
//        System.out.println(tt.toMap());
//        tt.set("ll", "2");
//        tt.set("nn", "3");
        tt.unset("ll");
        tt.get("ll", "default");

        System.out.println(tt.toMap());


    }
}
// END
