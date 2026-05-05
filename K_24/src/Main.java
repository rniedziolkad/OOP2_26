import java.util.Map;

public class Main {
    public static void main(String[] args) {

        DigitalClock clock = new DigitalClock(DigitalClock.Type.H12);
        clock.setTime(1, 0, 0);
        System.out.println("Czas: " + clock.toString());

        Map<String, City> cities = City.parseFile("strefy.csv");
        System.out.println(cities.toString());
    }
}