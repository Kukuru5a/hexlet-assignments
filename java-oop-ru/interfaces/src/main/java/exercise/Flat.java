package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return  area + balconyArea;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    @Override
    public int compareTo(Home another) {
        Flat flat = new Flat(area, balconyArea, floor);
        var res = another.getArea() > flat.getArea() ? -1 : 1;
        return res;
    }

    @Override
    public String toString() {
        return "Квартира " +
                "площадью " + getArea() +
                " метров на " + floor +
                " этаже";
    }
    public static void main(String[] args) {
        var home = new Flat(125.5, 4.4, 3);
        System.out.println(home);
    }
}
// END
