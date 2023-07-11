package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> aparts, int n) {

        List<String> res = new ArrayList<>();
        if (aparts.isEmpty()) {
           return new ArrayList<>();
        }
        aparts.sort(comparator);

        for (int i = 0; i < n; i++) {
            res.add(aparts.get(i).toString());
        }
        return res;
    }

    public static Comparator<Home> comparator = new Comparator<Home> () {

        @Override
        public int compare(Home o1, Home o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };

}
// END
