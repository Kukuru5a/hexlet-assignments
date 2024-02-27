package exercise.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LeeetClass {
    public static boolean isAnagram(String s, String t) {
        String strS = s.toLowerCase();
        String strsT = t.toLowerCase();
        if (strS.length() != strsT.length()) {
            return false;
        }
        char[] charArrS = strS.toCharArray();
        char[] charArrT = strsT.toCharArray();

        Arrays.sort(charArrS);
        Arrays.sort(charArrT);

        return Arrays.equals(charArrS,charArrT);
    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var wordA = Arrays.stream(word1).collect(Collectors.joining());
        var wordB = Arrays.stream(word2).collect(Collectors.joining());
        if (wordA.equalsIgnoreCase(wordB)) {
            return true;
        }else {
            return false;
        }

    }
    public static char findTheDifference(String s, String t) {

        char[] charArrA = s.toCharArray();
        char[] charArrT = t.toCharArray();
        Arrays.sort(charArrA);
        Arrays.sort(charArrT);
        char res = 0;
        if (s.isEmpty()) {
            for (var ch : charArrT) {
                res = ch;
            }
        } else {
            for (var ch : charArrA) {
                for (var ch2 : charArrT) {
                    if (ch != ch2) {
                        res = ch2;
                    } else if (charArrT.length > charArrA.length) {
                        res = ch2;
                    }
                }
            }
        }
        return res;
    }

    public static double myPow(double x, int n) {
        var res = Math.pow(x, (double)n);

        return res;
    }

    public static String destCity(List<List<String>> paths) {
        String res = null;
        List<String> cityList1 = new ArrayList<>();
        List<String> cityList2 = new ArrayList<>();



        for (var cities : paths) {
            for (var city : cities) {
                if (cities.get(cities.indexOf(city)).contains(city)
                        && cities.get(cities.lastIndexOf(city)).contains(city)) {
                    res = city;
                } else if (cities.get(cities.lastIndexOf(city)) != cities.get(cities.indexOf(city))) {
                    res = cities.get(cities.indexOf(city));
                }
            }
        }
        return res;
    }
    public static int numSpecial(int[][] mat) {
        int result = 0;
        int [] columns = new int [mat[0].length];
        for (int i = 0; i < mat.length; i ++) {
            int ones_in_the_row = 0;
            int column = 0;
            for (int j = 0; j < mat[i].length; j ++) {
                if (mat[i][j] == 1) {
                    ones_in_the_row ++;
                    if (ones_in_the_row == 1) {
                        columns[j] = columns[j] == 0 ? 1 : 2;
                        column = j;
                    }
                    else {
                        columns[column] = 2;
                        columns[j] = 2;
                    }
                }
            }

        }
        for (int column : columns) {
            result += (column == 1 ? 1 : 0);
        }
        return result;
    }
    public static void main(String[] args) {
//        var a = "car";
//        var b = "rac";
//        var res = isAnagram(a,b);
//        System.out.println(res);
        List<List<String>> paths = new ArrayList<>();
        List<String> cities1 = List.of("a", "b");
        List<String> cities2 = List.of("c", "d");

        paths.add(cities1);
        paths.add(cities2);
        int[][] arr = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(numSpecial(arr));
//        var c = "ae";
//        var d = "aea";
//
//        var res = findTheDifference(c,d);


    }
}
