/**
 * Created by ozzy on 03.10.2018.
 */
class Pupil implements Learner, Object {
    String fio;
    SEX sex;
    char letter;
    int age, form;

    public Pupil(String fio, SEX sex, int age, char letter, int form) {
        this.fio = fio;
        this.sex = sex;
        this.age = age;
        this.form = form;
        this.letter = letter;
    }

    public Pupil(char letter, int form) {
        this.fio = "Unknown";
        this.sex = SEX.Woman;
        this.age = 7;
        this.form = form;
        this.letter = letter;
    }

    public Pupil() {
        this.fio = "Unknown";
        this.sex = SEX.Woman;
        this.age = 7;
        this.form = 1;
        this.letter = 'A';
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

    public char getLetter() {
        return letter;
    }

    public int getForm() {
        return form;
    }

    @Override
    public String eduInstitution() {
        String ans = fio;
        if (sex == SEX.Man) {
            ans += " ученик ";
        }
        else {
            ans += " ученица ";
        }
        ans += "возраст: ";
        ans += Integer.toString(age);
        ans += ", " + form + " " + letter + " класс";
        return ans;
    }

    @Override
    public void print() {
        System.out.println(fio + " " +  form + " " + letter + " класс");
    }
}
