package exercise;

import java.util.Arrays;
import java.util.Scanner;

// BEGIN
public class App {
    public static String[] double_trouble(String[] value) {
        return Arrays.stream(value)
                .flatMap(vl -> Arrays.stream(new String[]{vl, vl}))
                .toArray(String[]::new);
    }
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] enlargeImage = Arrays.stream(image)
                .map(App::double_trouble).toArray(String[][]::new);
        return Arrays.stream(enlargeImage)
                .flatMap(vl -> Arrays.stream(new String[][] {vl, vl}))
                .toArray(String[][]::new);
    }
}
// END
