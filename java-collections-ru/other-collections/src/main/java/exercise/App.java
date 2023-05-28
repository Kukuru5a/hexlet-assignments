package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String,Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String,String> finalMap = new LinkedHashMap<>();
        Set<String> set = new TreeSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        for (var ss : set) {
            if(map1.containsKey(ss) && map2.containsKey(ss)) {
                var val1 = map1.get(ss);
                var val2 = map2.get(ss);
                if (val1.equals(val2)){
                    finalMap.put(ss, "unchanged");
                } else {
                    finalMap.put(ss, "changed");
                }
            }
            if(map1.containsKey(ss) && !map2.containsKey(ss)) {
                finalMap.put(ss, "deleted");
            }
            if (!map1.containsKey(ss) && map2.containsKey(ss)) {
                finalMap.put(ss, "added");
            }
        }
        return finalMap;
    }

    public static void main(String[] sss) {
        HashMap<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );

        HashMap<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result);
    }
}
//END
