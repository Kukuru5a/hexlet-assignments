package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {
    private static final String[] FREE_EMAILS = {"gmail.com", "yandex.ru", "hotmail.com"};

    public static int getCountOfFreeEmails(List<String> emails) {
        var edited1 = emails.stream()
                .filter(e -> e.endsWith("gmail.com"))
                .collect(Collectors.toList());
        var result1 = edited1.stream().count();
        var edited2 = emails.stream()
                .filter(e -> e.endsWith("yandex.ru"))
                .collect(Collectors.toList());
        var result2 = edited2.stream().count();
        var edited3 = emails.stream()
                .filter(e -> e.endsWith("hotmail.com"))
                .collect(Collectors.toList());
        var result3 = edited3.stream().count();
        var totalRes = result1 + result2 + result3;
        return (int) totalRes;

    }


    public static void main(String[] args) {
        List<String> list = List.of("mk@host.com",
                "support@hexlet.io",
                "support.yandex.ru@host.com",
                "support.yandex.ru@hexlet.io");
        var res = getCountOfFreeEmails(list);
        System.out.println(res);
    }
}
// END
