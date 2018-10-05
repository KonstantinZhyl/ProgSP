/**
 * Created by ozzy on 03.10.2018.
 */
public class Main {
    public static void main(String[] args) {
        PayedStudent p = new PayedStudent("Kononchik Tolstyak Valerievich", SEX.Man, 19, "ИЭФ", "ИСИТ(э)", "672303");
        p.learningForm(7.0);
        p.learningForm(8.1);
        p.learningForm(9.1);
        p.print();
        System.out.println(p.eduInstitution());

        BudStudent d = new BudStudent("Andrey Valerievich Dydyshko", SEX.Man, 19, "ФРЭ", "Автотракторный", "672302");
        d.learningForm(7.25);
        d.learningForm(8.5);
        d.learningForm(10.0);
        d.print();
        System.out.println(d.eduInstitution());

        Pupil s = new Pupil("Zhylinskiy Konstantin Sergeevich", SEX.Man, 22, 'A', 1);
        s.print();
        System.out.println(s.eduInstitution());

        PostGrad pg = new PostGrad("Anastasia Olegovna Tumentseva", SEX.Woman, 26,
                    "Построение высотных зданий используя модель Бойса", "Vafeev Alexandr Alexeevich");
        pg.print();
        System.out.println(pg.eduInstitution());
    }
}
