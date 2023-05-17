package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String character, String word) {
        String[] charArr = character.toLowerCase().split("");
        List<String> charList = new ArrayList<>(Arrays.asList(charArr));
        String[] wordArr = word.toLowerCase().split("");
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
        for (String ch : wordList) {
            if (!(charList.contains(ch))) {
                return false;
            }
            charList.remove(ch);
        }
        return true;
    }
}
//END
