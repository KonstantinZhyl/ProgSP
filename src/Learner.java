/**
 * Created by ozzy on 03.10.2018.
 */
public class Learner {
    String fio;
    SEX sex;
    int age;

    public Learner(String fio, SEX sex, int age) {
        this.fio = fio;
        this.sex = sex;
        this.age = age;
    }

    public Learner(String fio) {
        this.fio = fio;
        this.sex = SEX.Woman;
        this.age = 18;
    }

    public Learner() {
        this.fio = "Unknown";
        this.sex = SEX.Woman;
        this.age = 0;
    }

    public String getFio() {
        return fio;
    }

    public SEX isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String eduInstitution() {
        String ans = fio;
        if (sex == SEX.Man) {
            ans += " учащийся ";
        }
        else {
            ans += " учащаяся ";
        }
        ans += "возраст: ";
        ans += Integer.toString(age);
        return ans;
    }
}
