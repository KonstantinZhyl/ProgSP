/**
 * Created by ozzy on 03.10.2018.
 */
public class Pupil extends Learner {
    char letter;
    int form;

    public Pupil(String fio, SEX sex, int age, char letter, int form) {
        super(fio, sex, age);
        this.form = form;
        this.letter = letter;
    }

    public Pupil(char letter, int form) {
        super();
        this.form = form;
        this.letter = letter;
    }

    public Pupil() {
        super();
        this.form = 1;
        this.letter = 'A';
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
}
