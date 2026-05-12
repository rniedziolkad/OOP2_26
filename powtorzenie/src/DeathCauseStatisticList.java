import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> statisticList = new ArrayList<>();

    public void repopulate(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.nextLine();
            scanner.nextLine();
            statisticList.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);
                statisticList.add(stat);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int wiek, int n) {

    }

    @Override
    public String toString() {
        return "statisticList=" + statisticList;
    }
}
