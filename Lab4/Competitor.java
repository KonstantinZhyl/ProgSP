import java.time.Period;

/**
 * Created by ozzy on 05.10.2018.
 */
public class Competitor implements Comparable<Competitor> {
    int num;
    String surname;
    double result;

    Competitor(int num, String surname) {
        this.num = num;
        this.surname = surname;
        result = 0;
    }

    public int compareTo(Competitor obj) {
        if (result > obj.result) {
            return -1;
        }
        if (result < obj.result) {
            return 1;
        }
        return 0;
    }
}
