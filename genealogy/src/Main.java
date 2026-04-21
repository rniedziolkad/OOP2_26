import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: zadanie 6 "Pliki, wyjątki"
        List<Person> loaded = Person.fromCsv("family.csv");
        Person.toBinaryFile("osoby.data", loaded);
        List<Person> fromBinary = Person.fromBinaryFile("osoby.data");
        System.out.println("Wczytana lista:");
        if (fromBinary != null) {
            for (Person p : fromBinary) {
                System.out.println(p);
                System.out.println("dzieci: " + p.getChildren());
            }
        }

        String uml = "@startuml\n" +
                "class Person {\n" +
                "    - name : String\n" +
                "    + getName() : String\n" +
                "}\n" +
                "\n" +
                "class Student {\n" +
                "    - year : int\n" +
                "    + getYear() : int\n" +
                "}\n" +
                "\n" +
                "Person --|> Student\n" +
                "@enduml";

        PlantUMLRunner.setJarPath("/home/student/Pobrane/plantuml-1.2026.2.jar");
        PlantUMLRunner.generateUml(uml, "/home/student/Pobrane/", "output");
    }
}