/**
 * Created by ozzy on 03.10.2018.
 */
public class Main {
    public static void main(String[] args) {
        Learner l = new Learner("Alexey Alexeevich Pinchuk", SEX.Man, 21);
        System.out.println(l.eduInstitution());
        System.out.println();

        Pupil p = new Pupil("Dydyshko Andrey Vladimirovich", SEX.Man, 19, 'Я', 1);
        System.out.println(p.eduInstitution());
        System.out.println();

        Student s = new Student("Zhylinskiy Konstantin Sergeevich", SEX.Man, 21, "ИЭФ", "ИСиТ(э)", "672303");
        System.out.println(s.eduInstitution());
        System.out.println();

        PostGrad a = new PostGrad("Kanonchik Tolstyak Valerievich", SEX.Man, 21, "Что-то очень умное", "Алехина Алина Энодиевна");
        System.out.println(a.eduInstitution());
        System.out.println();
    }
}
