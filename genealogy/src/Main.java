import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: zadanie 6 "Pliki, wyjątki"
        List<Person> loaded = Person.fromCsv("family.csv");
        Person.toBinaryFile("osoby.data", loaded);
        List<Person> fromBinary = Person.fromBinaryFile("osoby.data");
        System.out.println("Wczytana lista:");

        String uml = Person.listToPlantUml(fromBinary);

        PlantUMLRunner.setJarPath("/home/student/Pobrane/plantuml-1.2026.2.jar");
        PlantUMLRunner.generateUml(uml, "/home/student/Pobrane/", "output");

        List<Person> filtered = Person.filterSubstring(fromBinary, "Kowal");
        System.out.println("Zawierające 'Kowal': ");
        for (Person p : filtered) {
            System.out.println(p);
        }

    }
}