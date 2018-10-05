/**
 * Created by ozzy on 03.10.2018.
 */
public class PostGrad implements Learner, Object {
    String fio;
    SEX sex;
    int age;
    String sciWork;
    String sciDir;

    public PostGrad(String fio, SEX sex, int age, String sciWork, String sciDir) {
        this.fio = fio;
        this.sex = sex;
        this.age = age;
        this.sciWork = sciWork;
        this.sciDir = sciDir;
    }

    public PostGrad(String sciWork, String sciDir) {
        this.fio = "Unknown";
        this.sex = SEX.Woman;
        this.age = 22;
        this.sciWork = sciWork;
        this.sciDir = sciDir;
    }

    public PostGrad() {
        this.fio = "Unknown";
        this.sex = SEX.Woman;
        this.age = 22;
        this.sciWork = "unknown";
        this.sciDir = "unknown";
    }

    @Override
    public String getFio() {
        return fio;
    }

    @Override
    public SEX getSex() {
        return sex;
    }

    @Override
    public int getAge() {
        return age;
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

    @Override
    public void print() {
        System.out.println(fio + ", научная работа: " + sciWork + ", руководитель: " + sciDir);
    }
}
