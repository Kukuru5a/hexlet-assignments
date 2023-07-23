package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// BEGIN
@AllArgsConstructor
@Getter
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Car car = new Car(this.id, this.brand, this.model, this.color, this.owner);
//        om.writeValue(new File("car.json"), car);
        return om.writeValueAsString(car);
    }

    public String unserialize() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Car car = new Car(this.id, this.brand, this.model, this.color, this.owner);
        var serCar = car.serialize();
        return String.valueOf(om.readValue(serCar, Car.class));
    }

    public static void main(String[] args) throws IOException {
        Car car = new Car(1, "BMW", "x5", "red",
                new User(1, "Roman","Zagorulya", 23));
        var res = car.serialize();
        System.out.println(res);
        var res2 = car.unserialize();
        System.out.println(res2);
    }
    // END
}
