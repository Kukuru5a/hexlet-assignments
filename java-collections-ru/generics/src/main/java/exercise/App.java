package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> bookList, Map<String, String> where) {
        List<Map<String, String>> resString = new ArrayList<>();
        for (Map<String, String> book : bookList) {
            int flag = 0;
            for (Map.Entry<String, String> ss : where.entrySet()) {
                if (book.containsKey(ss.getKey()) && book.containsValue(ss.getValue())) {
                    flag += 1;
                } else {
                    flag -= 1;
                }
                if (book.containsValue(ss.getValue())) {
                    flag += 1;
                } else {
                    flag -= 1;
                }

            }
            if (flag > 2) {
                resString.add(book);

            }

        }
        return resString;
    }


    public static void main(String[] args) {

        List<Map<String, String>> books = new ArrayList<>();
        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> result = findWhere(books, where);
        System.out.println(result);
    }
}


//END
