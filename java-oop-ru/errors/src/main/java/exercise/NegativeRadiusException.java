package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException(String mes) {
        super(mes);
    }
    public String getDes() {
        return this.getMessage();
    }

//    public String toString() {
//        return "Не удалось посчитать площадь";
//    }
}
// END
