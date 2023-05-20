package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static HashMap<String, Integer> getWordCount(String text) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] arrText = text.split(" ");
        if (arrText.length == 0) {
            return hm;
        }
        for (String word : arrText) {
            int count = 0;
            for (String wordPair : arrText) {
                if (word.equalsIgnoreCase(wordPair)) {
                    count += 1;
                }
            }
            hm.put(word, count);
        }
        return hm;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()){
            return "{}";
        }
        StringBuilder finalStr = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            finalStr.append("  " + maps.getKey() + ": ").append(maps.getValue() + "\n");
        }
        finalStr.append("}");
        return finalStr.toString();
    }

    public static void main (String[] args) {
        var text = "the java is the best programming language java";
        var r1 = getWordCount(text);
        var r2 = toString(r1);
        System.out.println(r2);
    }
}
//END
