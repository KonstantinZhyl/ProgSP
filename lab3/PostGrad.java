/**
 * Created by ozzy on 03.10.2018.
 */
public class PostGrad extends Learner {
    String sciWork;
    String sciDir;

    public PostGrad(String fio, SEX sex, int age, String sciWork, String sciDir) {
        super(fio, sex, age);
        this.sciWork = sciWork;
        this.sciDir = sciDir;
    }

    public PostGrad(String sciWork, String sciDir) {
        super();
        this.sciWork = sciWork;
        this.sciDir = sciDir;
    }

    public PostGrad() {
        super();
        this.sciWork = "unknown";
        this.sciDir = "unknown";
    }

    public String getSciWork() {
        return sciWork;
    }

    public String getSciDir() {
        return sciDir;
    }

    @Override
    public String eduInstitution() {
        String ans = fio;
        if (sex == SEX.Man) {
            ans += " аспирант ";
        }
        else {
            ans += " аспирантка ";
        }
        ans += "возраст: ";
        ans += Integer.toString(age);
        ans += ", работа: " + sciWork + ", руководитель: " + sciDir;
        return ans;
    }
}
