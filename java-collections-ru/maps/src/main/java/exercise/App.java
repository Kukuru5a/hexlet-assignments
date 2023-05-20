package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App{
    public static HashMap<String, Integer> getWordCount(String text) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] arrText = text.split(" ");
        for (String word : arrText) {
            int count = 0;
            for (String wordPair : arrText) {
                if(word.equalsIgnoreCase(wordPair)) {
                    count+=1;
                }
            }
            hm.put(word, count);
        }
        return hm;
    }
    public static String toString (Map<String, Integer> map) {
        return map.toString().replace("{", "  ").replace("}", "")
                .replace("=", ": ").replace(",", "\n ");
    }
}
//END
