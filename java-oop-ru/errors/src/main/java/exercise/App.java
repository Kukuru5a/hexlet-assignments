package exercise;

// BEGIN
public class App {
    static NegativeRadiusException nn = new NegativeRadiusException("Не удалось посчитать площадь\nВычисление окончено");
    public static void printSquare(Circle circle) throws NegativeRadiusException {
        try {
            System.out.println(Math.round(circle.getSquare()) + "\nВычисление окончено");
        }
            catch(NegativeRadiusException nn) {
                System.out.println(nn.getDes() + "\nВычисление окончено");
            }

    }

    public static void main(String[] args) throws Exception {
        Circle cir = new Circle(new Point(2,4), -5);
        App.printSquare(cir);
    }
}
// END
