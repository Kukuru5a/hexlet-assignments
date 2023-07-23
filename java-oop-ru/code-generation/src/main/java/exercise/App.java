package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    private static String path;
    public static void save(Path filePath, Car car) throws IOException {
        var serializedCar = car.serialize();
        Path filePath1 = Paths.get(String.valueOf(filePath));
        try (FileWriter fw = new FileWriter(String.valueOf(filePath1), true)) {
            fw.append(serializedCar);
            fw.flush();
        }

    }
    public static Car extract(Path filePath) throws IOException {
        File file = new File(String.valueOf(filePath));
        ObjectMapper om = new ObjectMapper();
        return om.readValue(file, Car.class);
    }
}
// END
