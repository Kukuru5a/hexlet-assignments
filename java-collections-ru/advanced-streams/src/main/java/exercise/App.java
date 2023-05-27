package exercise;


import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String data) {
        String[] strs = data.split("\n"); // делаем сплитовку по переносу строки
        var res = Stream.of(strs)
                .filter(e -> e.startsWith("environment=")) // фильтруем по слову "environment="
                .map(e -> e.replaceAll("environment=", "")) // убираем это слово
                .map(e -> e.replaceAll("\"", "")) // убираем ковычки и делаем сплитовку по запятой
                .map(e -> e.split(","))
                .flatMap(Stream::of)// выпрямляем стрим
                .filter(e -> e.startsWith("X_FORWARDED_"))// фильтруем по слову в ковычках
                .map(e -> e.replaceAll("X_FORWARDED_", ""))// заменяем его
                .toList(); // приводим к листу
//        var res = Arrays.stream(strs)
//                .map(e -> Arrays.stream(e.split(","))
//                        .filter(o -> o.startsWith("X_FORWARDED_"))
//                        .map(c -> c.replaceAll("X_FORWARDED_", "")).toList())
//                .toList();

        return res.toString().replace("[", "")
                .replace("]", "")
                .replace(" ", ""); // приводим строку в читабельное состояние
    }

    public static void main(String[] args) {
        var str = "[program:prepare]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "autorestart=false\n" +
                "environment=\"X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "\n" +
                "[program:http_server]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"";
        var res = getForwardedVariables(str);
        System.out.println(res);
    }
}

//END
