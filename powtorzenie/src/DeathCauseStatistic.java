import java.util.Arrays;

public class DeathCauseStatistic {
    private String icd10;
    private int[] death;

    public DeathCauseStatistic(String icd10, int[] death) {
        this.icd10 = icd10;
        this.death = death;
    }

    public static DeathCauseStatistic fromCsvLine(String line){
        String[] value = line.split(",");
        String icd10Code = value[0];
        int[] x = new int[20];
        int index = 0;

        for(int i = 2; i < value.length; i++){
            if(!value[i].equals("-")){
                x[index] = Integer.parseInt(value[i]);
            } else {
                x[index] = 0;
            }
            index++;
        }
        return new DeathCauseStatistic(icd10Code.trim(), x);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "icd10='" + icd10 + '\'' +
                ", death=" + Arrays.toString(death) +
                '}';
    }

    public String getIcd10() {
        return icd10;
    }
}
